package com.flyingrain.autotest.domain.core.executor;

import com.alibaba.fastjson.JSONObject;
import com.flyingrain.autotest.domain.constant.AutoTestResultCodeEnum;
import com.flyingrain.autotest.domain.core.executor.protocol.ProtocolHandler;
import com.flyingrain.autotest.domain.core.judge.CheckPoint;
import com.flyingrain.autotest.domain.core.judge.SendResultJudge;
import com.flyingrain.autotest.domain.core.requestHandler.RequestHandler;
import com.flyingrain.autotest.domain.core.requestHandler.SendRequest;
import com.flyingrain.autotest.domain.core.reuslthandler.ResultHandler;
import com.flyingrain.autotest.domain.core.reuslthandler.SendResult;
import com.flyingrain.autotest.domain.exception.AutoTestException;
import com.flyingrain.autotest.domain.model.Case;
import com.flyingrain.autotest.domain.model.RunContext;
import com.flyingrain.autotest.domain.model.Service;
import com.flyingrain.autotest.domain.model.runresult.CaseRunResult;
import com.flyingrain.autotest.domain.model.runresult.RunResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author wally
 * @date 2021-12-14
 */
@Component
public class CommonExecutor implements AutoTestExecutor, InitializingBean {

    private final Logger logger = LoggerFactory.getLogger(CommonExecutor.class);

    @Autowired
    private List<ProtocolHandler> protocolHandlers;

    @Autowired
    private List<RequestHandler> requestHandlers;

    @Autowired
    private List<SendResultJudge> judgeList;

    @Autowired
    private List<ResultHandler> resultHandlers;

    private final Map<String, SendResultJudge> stringSendResultJudgeMap = new HashMap<>();

    private final Map<String, RequestHandler> requestHandlerMap = new HashMap<>();

    private final Map<String, ProtocolHandler> protocolHandlerMap = new HashMap<>();

    private final Map<String, ResultHandler> resultHandlerMap = new HashMap<>();


    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 10, 100, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000));

    @Override
    public RunResult execute(RunContext runContext) {

        checkParam(runContext);

        return executeCases(runContext);

    }

    private RunResult executeCases(RunContext runContext) {
        RunResult runResult = new RunResult();
        List<Case> runCases = runContext.getRunCases();
        List<RunResult> details = new ArrayList<>();
        List<Case> sortedCases = runCases.stream().sorted(Comparator.comparingInt(Case::getPriority)).collect(Collectors.toList());
        CompletionService<RunResult> completionService = new ExecutorCompletionService<>(threadPool);
        for (Case runCase : sortedCases) {
            CaseRunTask caseRunTask = new CaseRunTask(runCase);
            completionService.submit(caseRunTask);
        }
        boolean executeResult = true;
        try {
            for (int i = 0; i < sortedCases.size(); i++) {
                RunResult result = completionService.take().get();
                details.add(result);
                executeResult &= result.isSuccess();
            }
        } catch (InterruptedException | ExecutionException e) {
            logger.error("execute case happen error!", e);
            executeResult = false;
        } finally {
            runResult.setDetails(details);
            runResult.setSuccess(executeResult);
        }
        return runResult;
    }

    private void checkParam(RunContext runContext) {
        List<Case> runCases = runContext.getRunCases();
        if (CollectionUtils.isEmpty(runCases)) {
            logger.error("runCase is empty!");
            throw new AutoTestException(AutoTestResultCodeEnum.NO_TEST_CASE);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        protocolHandlers.forEach(protocolHandler -> {
            protocolHandlerMap.put(protocolHandler.handProtocol().name(), protocolHandler);
        });
        requestHandlers.forEach(requestHandler -> {
            requestHandlerMap.put(requestHandler.supportType().name(), requestHandler);
        });
        resultHandlers.forEach(resultHandler -> {
            resultHandlerMap.put(resultHandler.supportType().name(), resultHandler);
        });
        judgeList.forEach(sendResultJudge -> {
            stringSendResultJudgeMap.put(sendResultJudge.judgeType().name(), sendResultJudge);
        });
    }

    class CaseRunTask implements Callable<RunResult> {

        private Case aCase;

        public CaseRunTask(Case aCase) {
            this.aCase = aCase;
        }

        @Override
        public RunResult call() throws Exception {
            logger.info("start to execute case:[{}]", aCase);
            long startTime = System.currentTimeMillis();
            List<Case> depCases = aCase.getDepCases();
            CaseRunResult result = runCases(aCase, depCases, new CaseResultCache());
            long endTime = System.currentTimeMillis();
            result.setUseTime(endTime - startTime);
            return result;
        }

        private CaseRunResult runCases(Case aCase, List<Case> depCases, CaseResultCache sendResultCache) {
            CaseRunResult runResult = new CaseRunResult();

            ProtocolHandler protocolHandler = getProtocolHandler(aCase);

            RequestHandler requestHandler = getRequestHandler(aCase);

            ResultHandler resultHandler = getResultHandler(aCase);

            SendResultJudge sendResultJudge = getJudge(aCase);
            try {
                if (CollectionUtils.isEmpty(depCases)) {
                    return runCase(aCase, sendResultCache, protocolHandler, requestHandler, resultHandler, sendResultJudge);
                } else {
                    for (Case depCase : depCases) {
                        //TODO 这里的结果处理没考虑两个根节点同时依赖一个叶节点
                        CaseRunResult caseRunResult = runCases(depCase, depCase.getDepCases(), sendResultCache);
                        runResult.addDetail(caseRunResult);
                        if (!caseRunResult.isSuccess()) {
                            logger.error("case run failed![{}]", caseRunResult);
                            runResult.setResult("case " + depCase.getId() + " run failed!");
                            throw new AutoTestException(AutoTestResultCodeEnum.CASE_RUN_ERROR);
                        }
                    }
                    CaseRunResult caseRunResult = runCase(aCase, sendResultCache, protocolHandler, requestHandler, resultHandler, sendResultJudge);
                    if (!caseRunResult.isSuccess()) {
                        logger.error("case run failed![{}]", caseRunResult);
                        throw new AutoTestException(AutoTestResultCodeEnum.CASE_RUN_ERROR);
                    }
                    runResult.setModelId(aCase.getId());
                    runResult.setRunTime(caseRunResult.getRunTime());
                    runResult.setSuccess(caseRunResult.isSuccess());
                    runResult.setResult(caseRunResult.getResult());
                    runResult.setRunTime(caseRunResult.getRunTime());
                }
                return runResult;
            } catch (AutoTestException autoTestException) {
                logger.error("run case happen exception!case:[{}]", aCase);
                logger.error("exception:", autoTestException);
                runResult.setSuccess(false);
            } catch (Exception e) {
                logger.error("run case happen unexpected exception!case:[{}]", aCase);
                logger.error("unexpected exception:", e);
                runResult.setSuccess(false);
                runResult.setResult(e.getMessage());
            }
            return runResult;
        }

        private CaseRunResult runCase(Case aCase, CaseResultCache sendResultCache, ProtocolHandler protocolHandler, RequestHandler requestHandler, ResultHandler resultHandler, SendResultJudge sendResultJudge) {
            SendRequest sendRequest = requestHandler.buildSendRequest(aCase, sendResultCache);

            long startTime = System.currentTimeMillis();

            SendResult sendResult = protocolHandler.handle(sendRequest);

            long endTime = System.currentTimeMillis();

            resultHandler.handleResult(sendResult, aCase);

            String checkPointStr = aCase.getCheckPoint();
            CheckPoint checkPoint = JSONObject.parseObject(checkPointStr, CheckPoint.class);

            sendResultJudge.judge(sendResult, checkPoint);

            CaseRunResult caseRunResult = buildCaseResult(sendResult, aCase);

            caseRunResult.setUseTime(endTime - startTime);

            sendResultCache.putResult(aCase.getId(), sendResult.getResultValues());

            return caseRunResult;
        }

        private CaseRunResult buildCaseResult(SendResult sendResult, Case aCase) {
            CaseRunResult caseRunResult = new CaseRunResult();
            caseRunResult.setModelId(aCase.getId());
            caseRunResult.setRunTime(new Date());

            if (sendResult != null) {
                caseRunResult.setSuccess(sendResult.isSuccess());
                caseRunResult.setResult(String.valueOf(sendResult.getOriginResult()));
                caseRunResult.setDetails(new ArrayList<>());
            } else {
                caseRunResult.setSuccess(false);
                caseRunResult.setResult("no result!");
            }
            return caseRunResult;
        }

        private SendResultJudge getJudge(Case aCase) {
            String checkPointStr = aCase.getCheckPoint();
            CheckPoint checkPoint = JSONObject.parseObject(checkPointStr, CheckPoint.class);
            SendResultJudge sendResultJudge = stringSendResultJudgeMap.get(checkPoint.getCheckPointCode());
            if (sendResultJudge == null) {
                logger.error("can't judge result!");
                throw new AutoTestException(AutoTestResultCodeEnum.NO_JUDGE);
            }
            return sendResultJudge;
        }

        private ResultHandler getResultHandler(Case aCase) {
            Service service = aCase.getService();
            String type = service.getResponseDataType();
            ResultHandler resultHandler = resultHandlerMap.get(type);
            if (resultHandler == null) {
                logger.error("not support such resultType:[{}]", type);
                throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_RESULT_TYPE);
            }
            return resultHandler;
        }

        private RequestHandler getRequestHandler(Case aCase) {
            Service service = aCase.getService();
            String type = service.getRequestDataType();
            RequestHandler requestHandler = requestHandlerMap.get(type);
            if (requestHandler == null) {
                logger.error("not support such requestType:[{}]", type);
                throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_REQUEST_TYPE);
            }
            return requestHandler;
        }

        private ProtocolHandler getProtocolHandler(Case aCase) {
            Service service = aCase.getService();
            String protocolType = service.getProtocolType();
            ProtocolHandler protocolHandler = protocolHandlerMap.get(protocolType);
            if (protocolHandler == null) {
                logger.error("not support such protocol:[{}]", protocolType);
                throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_PROTOCOL);
            }
            return protocolHandler;
        }
    }
}
