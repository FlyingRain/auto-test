package com.flyingrain.autotest.domain.core.requestHandler;

import java.util.Map;

/**
 * @author wally
 * @date 2021-12-15
 */
public class SendRequest {

    private String url;

    private Object sendContent;

    private String sendType;

    private Map<Long, Map<String,Object>> depResultCache;

    public Object getSendContent() {
        return sendContent;
    }

    public void setSendContent(Object sendContent) {
        this.sendContent = sendContent;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getUrl() {
        return url;
    }

    public Map<Long, Map<String, Object>> getDepResultCache() {
        return depResultCache;
    }

    public void setDepResultCache(Map<Long, Map<String, Object>> depResultCache) {
        this.depResultCache = depResultCache;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SendRequest{" +
                "url='" + url + '\'' +
                ", sendContent=" + sendContent +
                ", sendType='" + sendType + '\'' +
                '}';
    }
}
