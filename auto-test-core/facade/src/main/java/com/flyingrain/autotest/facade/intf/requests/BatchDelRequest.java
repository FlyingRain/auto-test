package com.flyingrain.autotest.facade.intf.requests;

import java.util.List;

public class BatchDelRequest {

    private List<Integer> serviceIds;

    public List<Integer> getServiceIds() {
        return serviceIds;
    }

    public void setServiceIds(List<Integer> serviceIds) {
        this.serviceIds = serviceIds;
    }

    @Override
    public String toString() {
        return "ServiceBatchDelRequest{" +
                "serviceIds=" + serviceIds +
                '}';
    }
}
