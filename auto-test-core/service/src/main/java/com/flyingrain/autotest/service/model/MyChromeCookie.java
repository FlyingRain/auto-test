package com.flyingrain.autotest.service.model;

import java.util.List;

public class MyChromeCookie {

    private String channelCode;

    private List<ChromeCookieUnit> data;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public List<ChromeCookieUnit> getData() {
        return data;
    }

    public void setData(List<ChromeCookieUnit> data) {
        this.data = data;
    }
}
