package com.flyingrain.autotest.facade.intf.model;

import java.util.List;
import java.util.Map;

public class CaseRunResults {

    private List<Map<String,Integer>> runResults;

    public List<Map<String, Integer>> getRunResults() {
        return runResults;
    }

    public void setRunResults(List<Map<String, Integer>> runResults) {
        this.runResults = runResults;
    }
}
