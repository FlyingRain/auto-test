package com.flyingrain.autotest.service.model.yimi;

public class YimiMessage {
    private YimiAddress yimiAddress;

    private YimiPriceResult yimiPriceResult;

    public YimiAddress getYimiAddress() {
        return yimiAddress;
    }

    public void setYimiAddress(YimiAddress yimiAddress) {
        this.yimiAddress = yimiAddress;
    }

    public YimiPriceResult getYimiPriceResult() {
        return yimiPriceResult;
    }

    public void setYimiPriceResult(YimiPriceResult yimiPriceResult) {
        this.yimiPriceResult = yimiPriceResult;
    }
}
