package com.czwm.dto.cust;

import com.czwm.dto.cust.detail.CustDetailDto;
import com.czwm.dto.cust.experience.CustExperienceResultDto;
import com.czwm.dto.cust.optometry.CustOptometryResultDto;

/**
 * 客户详情
 * Created by apple on 2017/5/19.
 */
public class CustDto {

    private CustDetailDto custDetail;

    private CustOptometryResultDto firstOptometryResult;

    private CustExperienceResultDto firstExperienceResult;

    private CustExperienceResultDto secondExperienceResult;

    private CustExperienceResultDto thirdExperienceResult;

    public CustDetailDto getCustDetail() {
        return custDetail;
    }

    public void setCustDetail(CustDetailDto custDetail) {
        this.custDetail = custDetail;
    }

    public CustOptometryResultDto getFirstOptometryResult() {
        return firstOptometryResult;
    }

    public void setFirstOptometryResult(
            CustOptometryResultDto firstOptometryResult) {
        this.firstOptometryResult = firstOptometryResult;
    }

    public CustExperienceResultDto getFirstExperienceResult() {
        return firstExperienceResult;
    }

    public void setFirstExperienceResult(
            CustExperienceResultDto firstExperienceResult) {
        this.firstExperienceResult = firstExperienceResult;
    }

    public CustExperienceResultDto getSecondExperienceResult() {
        return secondExperienceResult;
    }

    public void setSecondExperienceResult(
            CustExperienceResultDto secondExperienceResult) {
        this.secondExperienceResult = secondExperienceResult;
    }

    public CustExperienceResultDto getThirdExperienceResult() {
        return thirdExperienceResult;
    }

    public void setThirdExperienceResult(
            CustExperienceResultDto thirdExperienceResult) {
        this.thirdExperienceResult = thirdExperienceResult;
    }
}
