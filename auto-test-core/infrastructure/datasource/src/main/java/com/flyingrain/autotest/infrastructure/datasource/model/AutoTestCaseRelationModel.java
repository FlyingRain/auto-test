package com.flyingrain.autotest.infrastructure.datasource.model;

/**
 * @author wally
 * @date 2021-12-09
 */
public class AutoTestCaseRelationModel {

    private long id;

    private long caseId;

    private long depCaseId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    public long getDepCaseId() {
        return depCaseId;
    }

    public void setDepCaseId(long depCaseId) {
        this.depCaseId = depCaseId;
    }
}
