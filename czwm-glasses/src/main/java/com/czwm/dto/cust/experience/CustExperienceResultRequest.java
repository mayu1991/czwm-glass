package com.czwm.dto.cust.experience;

import com.czwm.dto.cust.optometry.CustOptometryResultDto;

import java.util.List;

/**
 * 客户主要信息维护请求
 */
public class CustExperienceResultRequest {
    //体验记录
    private List<CustExperienceResultDto> experiences;
    //首次检测数据
    private CustOptometryResultDto optometry;

    private Integer custId;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public List<CustExperienceResultDto> getExperiences() {
        return experiences;
    }

    public void setExperiences(
            List<CustExperienceResultDto> experiences) {
        this.experiences = experiences;
    }

    public CustOptometryResultDto getOptometry() {
        return optometry;
    }

    public void setOptometry(CustOptometryResultDto optometry) {
        this.optometry = optometry;
    }
}