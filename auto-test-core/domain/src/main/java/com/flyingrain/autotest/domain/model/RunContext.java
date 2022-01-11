package com.flyingrain.autotest.domain.model;

import com.flyingrain.autotest.domain.model.runresult.RunResult;

import java.util.List;

/**
 * @author wally
 * @date 2021-12-13
 */
public class RunContext {

    private Model model;

    private List<Case> runCases;

    private RunResult result;

    private List<RunLog> runLogs;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public RunResult getResult() {
        return result;
    }

    public void setResult(RunResult result) {
        this.result = result;
    }

    public List<RunLog> getRunLogs() {
        return runLogs;
    }

    public void setRunLogs(List<RunLog> runLogs) {
        this.runLogs = runLogs;
    }

    public List<Case> getRunCases() {
        return runCases;
    }

    public void setRunCases(List<Case> runCases) {
        this.runCases = runCases;
    }
}
