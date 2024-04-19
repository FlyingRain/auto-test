package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.common.util.PageQuery;
import com.flyingrain.autotest.common.util.PageableModel;
import com.flyingrain.autotest.domain.model.RunLog;
import com.flyingrain.autotest.domain.service.convert.RunLogModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestRunLogMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.AutoTestRunLogModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wally
 * @date 2021-12-13
 */
@Component
public class RunLogService {

    private final Logger logger = LoggerFactory.getLogger(RunLogService.class);

    @Autowired
    private AutoTestRunLogMapper autoTestRunLogMapper;

    public int saveRunLogs(List<RunLog> runLogs) {
        if (CollectionUtils.isEmpty(runLogs)) {
            logger.warn("save a empty runLogs!");
            return 0;
        }
        return autoTestRunLogMapper.insertRunLogBatch(runLogs.stream().map(RunLogModelConvert::convertRunLog).collect(Collectors.toList()));
    }

    public int insertRunLog(RunLog runLog) {
        logger.info("start to save runLog:[{}]", runLog);
        return autoTestRunLogMapper.insertRunLog(RunLogModelConvert.convertRunLog(runLog));
    }

    public PageableModel<RunLog> queryByPage(PageQuery<RunLog> queryCondition) {
        PageableModel<RunLog> pageableModel = new PageableModel<>();
        PageQuery<AutoTestRunLogModel> query = new PageQuery<>(queryCondition.getCurrentPage(), queryCondition.getPageSize(), RunLogModelConvert.convertRunLog(queryCondition.getConditions()));
        List<AutoTestRunLogModel> runLogModels = autoTestRunLogMapper.queryRunLogByPage(query);
        int count = autoTestRunLogMapper.queryRunLogByPageCount(query);
        pageableModel.setData(runLogModels.stream().map(RunLogModelConvert::convertRunLogModel).collect(Collectors.toList()));
        pageableModel.setPageSize(queryCondition.getPageSize());
        pageableModel.setTotal(count);
        pageableModel.setCurrentPage(queryCondition.getCurrentPage());
        return pageableModel;
    }

    public RunLog detail(int id) {
        AutoTestRunLogModel autoTestRunLogModel = autoTestRunLogMapper.queryDetail(id);
        return RunLogModelConvert.convertRunLogModel(autoTestRunLogModel);
    }

    public List<RunLog> queryByBatchNum(String batchNum) {
        logger.info("query by batchNum:[{}]", batchNum);
        return autoTestRunLogMapper.queryByBatchNum(batchNum).stream().map(RunLogModelConvert::convertRunLogModel).collect(Collectors.toList());
    }
}
