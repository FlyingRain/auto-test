package com.flyingrain.autotest.domain.core.judge;

import java.util.Map;

/**
 * @author wally
 * @date 2021-12-23
 */
public class CheckPoint {

    private String checkPointCode;

    private Map<String,Object> checkData;

    public String getCheckPointCode() {
        return checkPointCode;
    }

    public void setCheckPointCode(String checkPointCode) {
        this.checkPointCode = checkPointCode;
    }

    public Map<String, Object> getCheckData() {
        return checkData;
    }

    public void setCheckData(Map<String, Object> checkData) {
        this.checkData = checkData;
    }
}
