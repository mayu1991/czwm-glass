package com.czwm.dto.cust.experience;

import com.czwm.dto.BaseDto;

import java.util.Date;

public class CustExperienceResultDto extends BaseDto {
    private Integer id;

    private Integer custId;

    private Integer experienceFrequency;

    private Date appointmentTime;

    private String appointmentTimeStr;

    private Date experienceTime;

    private String experienceTimeStr;

    private String receptionName;

    private String submitFlag;

    public String getAppointmentTimeStr() {
        return appointmentTimeStr;
    }

    public void setAppointmentTimeStr(String appointmentTimeStr) {
        this.appointmentTimeStr = appointmentTimeStr;
    }

    public String getExperienceTimeStr() {
        return experienceTimeStr;
    }

    public void setExperienceTimeStr(String experienceTimeStr) {
        this.experienceTimeStr = experienceTimeStr;
    }

    public String getSubmitFlag() {
        return submitFlag;
    }

    public void setSubmitFlag(String submitFlag) {
        this.submitFlag = submitFlag;
    }

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

    public Integer getExperienceFrequency() {
        return experienceFrequency;
    }

    public void setExperienceFrequency(Integer experienceFrequency) {
        this.experienceFrequency = experienceFrequency;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Date getExperienceTime() {
        return experienceTime;
    }

    public void setExperienceTime(Date experienceTime) {
        this.experienceTime = experienceTime;
    }

    public String getReceptionName() {
        return receptionName;
    }

    public void setReceptionName(String receptionName) {
        this.receptionName = receptionName == null ? null : receptionName.trim();
    }

}