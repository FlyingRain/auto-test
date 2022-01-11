package com.flyingrain.autotest.domain.core.executor;

import com.flyingrain.autotest.domain.model.Case;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wally
 * @date 2021-12-16
 */
public class CaseResultCache {

    private long caseId;

    private Case currentCase;

    private final Map<Long, Map<String, Object>> depResult = new HashMap<>();

    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    public Case getCurrentCase() {
        return currentCase;
    }

    public void setCurrentCase(Case currentCase) {
        this.currentCase = currentCase;
    }

    public Map<Long, Map<String, Object>> getDepResult() {
        return depResult;
    }

    public void putResult(Long caseId, Map<String, Object> result) {
        depResult.put(caseId, result);
    }
}
