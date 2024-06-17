package com.flyingrain.autotest.service.model.yunda;

import com.alibaba.fastjson.annotation.JSONField;

public class YunDaCookie {

    @JSONField(name = "PHPSESSID")
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
