package com.flyingrain.autotest.facade.intf.model.oder;

import java.math.BigDecimal;

public class Cost {

    private BigDecimal totalCost;

    private BigDecimal platformFee;

    private BigDecimal sendFee;

    private BigDecimal backFee;

    private BigDecimal claimFee;

    private BigDecimal rewardFee;

    private BigDecimal otherFee;

    private String remark;

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getPlatformFee() {
        return platformFee;
    }

    public void setPlatformFee(BigDecimal platformFee) {
        this.platformFee = platformFee;
    }

    public BigDecimal getSendFee() {
        return sendFee;
    }

    public void setSendFee(BigDecimal sendFee) {
        this.sendFee = sendFee;
    }

    public BigDecimal getBackFee() {
        return backFee;
    }

    public void setBackFee(BigDecimal backFee) {
        this.backFee = backFee;
    }

    public BigDecimal getClaimFee() {
        return claimFee;
    }

    public void setClaimFee(BigDecimal claimFee) {
        this.claimFee = claimFee;
    }

    public BigDecimal getRewardFee() {
        return rewardFee;
    }

    public void setRewardFee(BigDecimal rewardFee) {
        this.rewardFee = rewardFee;
    }

    public BigDecimal getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(BigDecimal otherFee) {
        this.otherFee = otherFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "totalCost=" + totalCost +
                ", platformFee=" + platformFee +
                ", sendFee=" + sendFee +
                ", backFee=" + backFee +
                ", claimFee=" + claimFee +
                ", rewardFee=" + rewardFee +
                ", otherFee=" + otherFee +
                ", remark='" + remark + '\'' +
                '}';
    }
}
