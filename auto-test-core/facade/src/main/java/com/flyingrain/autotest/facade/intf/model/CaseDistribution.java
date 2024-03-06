package com.flyingrain.autotest.facade.intf.model;

import java.util.List;
import java.util.Map;

public class CaseDistribution {

    private List<Map<String,Integer>>  distributions;

    public List<Map<String, Integer>> getDistributions() {
        return distributions;
    }

    public void setDistributions(List<Map<String, Integer>> distributions) {
        this.distributions = distributions;
    }
}
