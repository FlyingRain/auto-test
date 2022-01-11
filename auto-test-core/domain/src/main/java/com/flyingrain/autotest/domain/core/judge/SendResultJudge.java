package com.flyingrain.autotest.domain.core.judge;

import com.flyingrain.autotest.domain.core.reuslthandler.SendResult;

/**
 * @author wally
 * @date 2021-12-23
 */
public interface SendResultJudge {

    void judge(SendResult sendResult, CheckPoint checkPoint);

    JudgeTypeEnum judgeType();
}
