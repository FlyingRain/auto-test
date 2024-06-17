package com.flyingrain.autotest.facade.intf.model.oder;

import java.math.BigDecimal;

public class Income {

    private BigDecimal totalIncome;

    private BigDecimal specialAreaFee;

    private BigDecimal transactionFee;

    private BigDecimal insureFee;

    private BigDecimal upstairsFee;

    private BigDecimal bigGoodsFee;

    private BigDecimal backOrderFee;

    private BigDecimal otherFee;

    private String remark;

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getSpecialAreaFee() {
        return specialAreaFee;
    }

    public void setSpecialAreaFee(BigDecimal specialAreaFee) {
        this.specialAreaFee = specialAreaFee;
    }

    public BigDecimal getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee) {
        this.transactionFee = transactionFee;
    }

    public BigDecimal getInsureFee() {
        return insureFee;
    }

    public void setInsureFee(BigDecimal insureFee) {
        this.insureFee = insureFee;
    }

    public BigDecimal getUpstairsFee() {
        return upstairsFee;
    }

    public void setUpstairsFee(BigDecimal upstairsFee) {
        this.upstairsFee = upstairsFee;
    }

    public BigDecimal getBigGoodsFee() {
        return bigGoodsFee;
    }

    public void setBigGoodsFee(BigDecimal bigGoodsFee) {
        this.bigGoodsFee = bigGoodsFee;
    }

    public BigDecimal getBackOrderFee() {
        return backOrderFee;
    }

    public void setBackOrderFee(BigDecimal backOrderFee) {
        this.backOrderFee = backOrderFee;
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
}
