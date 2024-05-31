package com.flyingrain.autotest.facade.intf.model.oder;

public class ChannelPrice {

    private double total;

    private String otherDetail;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOtherDetail() {
        return otherDetail;
    }

    public void setOtherDetail(String otherDetail) {
        this.otherDetail = otherDetail;
    }

    @Override
    public String toString() {
        return "ChannelPrice{" +
                "total=" + total +
                ", otherDetail='" + otherDetail + '\'' +
                '}';
    }
}
