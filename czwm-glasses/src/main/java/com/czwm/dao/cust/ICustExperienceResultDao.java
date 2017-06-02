package com.czwm.dao.cust;

import com.czwm.dto.cust.experience.CustExperienceResultDto;
import com.czwm.dto.cust.experience.CustExperienceResultExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustExperienceResultDao {
    int countByExample(CustExperienceResultExample example);

    int deleteByExample(CustExperienceResultExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByCustId(Integer custId);

    int insert(CustExperienceResultDto record);

    int insertSelective(CustExperienceResultDto record);

    List<CustExperienceResultDto> selectByExample(CustExperienceResultExample example);

    CustExperienceResultDto selectByPrimaryKey(Integer id);

    List<CustExperienceResultDto> selectByConditions(
            CustExperienceResultDto custExperienceResultDto);

    int updateByExampleSelective(@Param("record") CustExperienceResultDto record,
            @Param("example") CustExperienceResultExample example);

    int updateByExample(@Param("record") CustExperienceResultDto record,
            @Param("example") CustExperienceResultExample example);

    int updateByPrimaryKeySelective(CustExperienceResultDto record);

    int updateByPrimaryKey(CustExperienceResultDto record);
}