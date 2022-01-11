package com.flyingrain.autotest.domain.model.runresult;


/**
 * @author wally
 * @date 2021-12-10
 */
public class CaseRunResult extends RunResult {

    private long useTime;

    public long getUseTime() {
        return useTime;
    }

    public void setUseTime(long useTime) {
        this.useTime = useTime;
    }
}
