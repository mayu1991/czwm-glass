package com.czwm.dto.cust.deal;

import com.czwm.dto.BaseDto;

public class CustDealResultDto extends BaseDto {
    private Integer id;

    private Integer custId;

    private Byte dealResultType;

    private String dealTratorName;

    private Byte submitFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Byte getDealResultType() {
        return dealResultType;
    }

    public void setDealResultType(Byte dealResultType) {
        this.dealResultType = dealResultType;
    }

    public String getDealTratorName() {
        return dealTratorName;
    }

    public void setDealTratorName(String dealTratorName) {
        this.dealTratorName = dealTratorName == null ? null : dealTratorName.trim();
    }

    public Byte getSubmitFlag() {
        return submitFlag;
    }

    public void setSubmitFlag(Byte submitFlag) {
        this.submitFlag = submitFlag;
    }

}