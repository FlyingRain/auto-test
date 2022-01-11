package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.domain.model.RunLog;
import com.flyingrain.autotest.domain.service.convert.RunLogModelConvert;
import com.flyingrain.autotest.infrastructure.datasource.mapper.AutoTestRunLogMapper;
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

}
