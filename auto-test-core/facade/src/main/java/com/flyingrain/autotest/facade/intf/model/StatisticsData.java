package com.flyingrain.autotest.facade.intf.model;

public class StatisticsData {

    private int totalService;

    private int totalCases;

    private int success;

    private int failed;

    public int getTotalService() {
        return totalService;
    }

    public void setTotalService(int totalService) {
        this.totalService = totalService;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    @Override
    public String toString() {
        return "DataBoard{" +
                "totalService=" + totalService +
                ", totalCases=" + totalCases +
                ", success=" + success +
                ", failed=" + failed +
                '}';
    }
}
