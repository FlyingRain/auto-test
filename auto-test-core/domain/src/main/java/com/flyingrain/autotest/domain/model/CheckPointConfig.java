package com.flyingrain.autotest.domain.model;

import java.util.List;

public class CheckPointConfig {

    private String checkPointType;

    private String sourceCode;

    private String script;

    private String message;

    private List<JudgeConfig> judges;

    private String ref;

    public String getCheckPointType() {
        return checkPointType;
    }

    public void setCheckPointType(String checkPointType) {
        this.checkPointType = checkPointType;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public List<JudgeConfig> getJudges() {
        return judges;
    }

    public void setJudges(List<JudgeConfig> judges) {
        this.judges = judges;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CheckPointConfig{" +
                "checkPointType='" + checkPointType + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", script='" + script + '\'' +
                ", message='" + message + '\'' +
                ", judges=" + judges +
                ", ref='" + ref + '\'' +
                '}';
    }
}
