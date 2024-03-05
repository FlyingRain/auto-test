package com.flyingrain.autotest.domain.model.runresult;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wally
 * @date 2021-12-10
 */
public class RunResult {

    private boolean success;

    private String result;

    private long modelId;

    private Date runTime;

    private final List<RunResult> details = new ArrayList<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public List<RunResult> getDetails() {
        return details;
    }

    public void setDetails(List<RunResult> details) {
    }
    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public Date getRunTime() {
        return runTime;
    }

    public void setRunTime(Date runTime) {
        this.runTime = runTime;
    }

    public void addDetail(RunResult runResult){
        details.add(runResult);
    }

    @Override
    public String toString() {
        return "RunResult{" +
                "success=" + success +
                ", result='" + result + '\'' +
                ", modelId=" + modelId +
                ", details=" + details +
                '}';
    }
}
