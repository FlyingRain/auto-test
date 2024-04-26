package com.flyingrain.autotest.facade.intf.model;

public class AutoTestIn {

    private String in;

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    @Override
    public String toString() {
        return "AutoTestIn{" +
                "in='" + in + '\'' +
                '}';
    }
}
