package com.flyingrain.autotest.domain.model;

public class JudgeConfig {

    private String logic;

    private String expect;

    private String param;

    private String ref;

    public String getLogic() {
        return logic;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "JudgeConfig{" +
                "logic='" + logic + '\'' +
                ", expect='" + expect + '\'' +
                ", param='" + param + '\'' +
                '}';
    }
}
