package com.flyingrain.autotest.facade.intf.requests;

/**
 * @author wally
 * @date 2021-12-10
 */
public class RunRequest {

    private long modelId;

    /**
     * @see ModelTypeEnum
     */
    private String modelType;

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }
}
