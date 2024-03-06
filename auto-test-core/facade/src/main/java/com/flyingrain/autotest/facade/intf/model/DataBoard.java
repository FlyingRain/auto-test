package com.flyingrain.autotest.facade.intf.model;

public class DataBoard {

    private StatisticsData statisticsData;

    private CaseDistribution caseDistribution;

    private CaseRunResults caseRunResults;

    public StatisticsData getStatisticsData() {
        return statisticsData;
    }

    public void setStatisticsData(StatisticsData statisticsData) {
        this.statisticsData = statisticsData;
    }

    public CaseDistribution getCaseDistribution() {
        return caseDistribution;
    }

    public void setCaseDistribution(CaseDistribution caseDistribution) {
        this.caseDistribution = caseDistribution;
    }

    public CaseRunResults getCaseRunResults() {
        return caseRunResults;
    }

    public void setCaseRunResults(CaseRunResults caseRunResults) {
        this.caseRunResults = caseRunResults;
    }

    @Override
    public String toString() {
        return "DataBoard{" +
                "statisticsData=" + statisticsData +
                ", caseDistribution=" + caseDistribution +
                ", caseRunResults=" + caseRunResults +
                '}';
    }
}
