package com.flyingrain.autotest.facade.intf.model;

public class AutoTestMysqlOpt {


    private String dataSourceCode;

    private String script;

    public String getDataSourceCode() {
        return dataSourceCode;
    }

    public void setDataSourceCode(String dataSourceCode) {
        this.dataSourceCode = dataSourceCode;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    @Override
    public String toString() {
        return "AutoTestMysqlOpt{" +
                "dataSourceCode='" + dataSourceCode + '\'' +
                ", script='" + script + '\'' +
                '}';
    }
}
