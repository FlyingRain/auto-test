package com.flyingrain.autotest.facade.intf.requests;

import java.util.List;

public class BatchDelRequest {

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "ServiceBatchDelRequest{" +
                "ids=" + ids +
                '}';
    }
}
