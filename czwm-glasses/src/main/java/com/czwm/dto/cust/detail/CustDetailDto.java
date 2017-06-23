package com.czwm.dto.cust.detail;

import com.czwm.dto.BaseDto;

import java.util.List;

public class CustDetailDto extends BaseDto {

    private Integer id;

    private String custName;

    private Byte sex;

    private String sexDesc;

    private Byte age;

    private String mobilePhone;

    private String schoolName;

    private String remark;

    private Byte dealFlag;

    private String dealFlagDesc;

    private String dealTratorName;

    //门市ID
    private Integer storeId;

    private List<String> storeIds;

    public List<String> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<String> storeIds) {
        this.storeIds = storeIds;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getDealFlagDesc() {
        return dealFlagDesc;
    }

    public void setDealFlagDesc(String dealFlagDesc) {
        this.dealFlagDesc = dealFlagDesc;
    }

    public String getDealTratorName() {
        return dealTratorName;
    }

    public void setDealTratorName(String dealTratorName) {
        this.dealTratorName = dealTratorName;
    }

    public Byte getDealFlag() {
        return dealFlag;
    }

    public void setDealFlag(Byte dealFlag) {
        this.dealFlag = dealFlag;
    }

    public String getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(String sexDesc) {
        this.sexDesc = sexDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

}