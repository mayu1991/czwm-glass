package com.czwm.dto.cust.optometry;

import com.czwm.dto.BaseDto;

import java.util.Date;

public class CustOptometryResultDto extends BaseDto {
    private Integer id;

    private Integer custId;

    private Date optometryTime;

    private Date experienceTime;

    private String optometryTimeStr;

    private String experienceTimeStr;

    private String receptionName;

    private String leftNakedVision;

    private String rightNakedVision;

    private String leftCombinedOptometryVision;

    private String rightCombinedOptometryVision;

    private String leftPrimaryMirrorNumber;

    private String rightPrimaryMirrorNumber;

    private String leftMirrorCollectionVision;

    private String rightMirrorCollectionVision;

    private Byte refractiveProperties;

    private Date appointmentTime;

    private String appointmentTimeStr;

    private String refractivePropertiesLevel;

    private Byte experienceType;

    private Byte submitFlag;

    private String interpupillaryAdjustmentRange;

    private String leftAdjustmentRange;

    private String rightAdjustmentRange;

    public String getLeftAdjustmentRange() {
        return leftAdjustmentRange;
    }

    public void setLeftAdjustmentRange(String leftAdjustmentRange) {
        this.leftAdjustmentRange = leftAdjustmentRange;
    }

    public String getRightAdjustmentRange() {
        return rightAdjustmentRange;
    }

    public void setRightAdjustmentRange(String rightAdjustmentRange) {
        this.rightAdjustmentRange = rightAdjustmentRange;
    }

    public String getInterpupillaryAdjustmentRange() {
        return interpupillaryAdjustmentRange;
    }

    public void setInterpupillaryAdjustmentRange(String interpupillaryAdjustmentRange) {
        this.interpupillaryAdjustmentRange = interpupillaryAdjustmentRange;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Date getOptometryTime() {
        return optometryTime;
    }

    public void setOptometryTime(Date optometryTime) {
        this.optometryTime = optometryTime;
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

    public String getLeftNakedVision() {
        return leftNakedVision;
    }

    public void setLeftNakedVision(String leftNakedVision) {
        this.leftNakedVision = leftNakedVision == null ? null : leftNakedVision.trim();
    }

    public String getRightNakedVision() {
        return rightNakedVision;
    }

    public void setRightNakedVision(String rightNakedVision) {
        this.rightNakedVision = rightNakedVision == null ? null : rightNakedVision.trim();
    }

    public String getLeftCombinedOptometryVision() {
        return leftCombinedOptometryVision;
    }

    public void setLeftCombinedOptometryVision(String leftCombinedOptometryVision) {
        this.leftCombinedOptometryVision =
                leftCombinedOptometryVision == null ? null : leftCombinedOptometryVision.trim();
    }

    public String getRightCombinedOptometryVision() {
        return rightCombinedOptometryVision;
    }

    public void setRightCombinedOptometryVision(String rightCombinedOptometryVision) {
        this.rightCombinedOptometryVision =
                rightCombinedOptometryVision == null ? null : rightCombinedOptometryVision.trim();
    }

    public String getLeftPrimaryMirrorNumber() {
        return leftPrimaryMirrorNumber;
    }

    public void setLeftPrimaryMirrorNumber(String leftPrimaryMirrorNumber) {
        this.leftPrimaryMirrorNumber =
                leftPrimaryMirrorNumber == null ? null : leftPrimaryMirrorNumber.trim();
    }

    public String getRightPrimaryMirrorNumber() {
        return rightPrimaryMirrorNumber;
    }

    public void setRightPrimaryMirrorNumber(String rightPrimaryMirrorNumber) {
        this.rightPrimaryMirrorNumber =
                rightPrimaryMirrorNumber == null ? null : rightPrimaryMirrorNumber.trim();
    }

    public String getLeftMirrorCollectionVision() {
        return leftMirrorCollectionVision;
    }

    public void setLeftMirrorCollectionVision(String leftMirrorCollectionVision) {
        this.leftMirrorCollectionVision =
                leftMirrorCollectionVision == null ? null : leftMirrorCollectionVision.trim();
    }

    public String getRightMirrorCollectionVision() {
        return rightMirrorCollectionVision;
    }

    public void setRightMirrorCollectionVision(String rightMirrorCollectionVision) {
        this.rightMirrorCollectionVision =
                rightMirrorCollectionVision == null ? null : rightMirrorCollectionVision.trim();
    }

    public Byte getRefractiveProperties() {
        return refractiveProperties;
    }

    public void setRefractiveProperties(Byte refractiveProperties) {
        this.refractiveProperties = refractiveProperties;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getRefractivePropertiesLevel() {
        return refractivePropertiesLevel;
    }

    public void setRefractivePropertiesLevel(String refractivePropertiesLevel) {
        this.refractivePropertiesLevel =
                refractivePropertiesLevel == null ? null : refractivePropertiesLevel.trim();
    }

    public Byte getExperienceType() {
        return experienceType;
    }

    public void setExperienceType(Byte experienceType) {
        this.experienceType = experienceType;
    }

    public Byte getSubmitFlag() {
        return submitFlag;
    }

    public void setSubmitFlag(Byte submitFlag) {
        this.submitFlag = submitFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptometryTimeStr() {
        return optometryTimeStr;
    }

    public void setOptometryTimeStr(String optometryTimeStr) {
        this.optometryTimeStr = optometryTimeStr;
    }

    public String getExperienceTimeStr() {
        return experienceTimeStr;
    }

    public void setExperienceTimeStr(String experienceTimeStr) {
        this.experienceTimeStr = experienceTimeStr;
    }

    public String getAppointmentTimeStr() {
        return appointmentTimeStr;
    }

    public void setAppointmentTimeStr(String appointmentTimeStr) {
        this.appointmentTimeStr = appointmentTimeStr;
    }
}