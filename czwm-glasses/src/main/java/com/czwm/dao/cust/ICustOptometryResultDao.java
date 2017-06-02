package com.czwm.dao.cust;

import com.czwm.dto.cust.optometry.CustOptometryResultDto;
import com.czwm.dto.cust.optometry.CustOptometryResultExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustOptometryResultDao {
    int countByExample(CustOptometryResultExample example);

    int deleteByExample(CustOptometryResultExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteByCustId(Integer custId);

    int insert(CustOptometryResultDto record);

    int insertSelective(CustOptometryResultDto record);

    List<CustOptometryResultDto> selectByExample(CustOptometryResultExample example);

    CustOptometryResultDto selectByPrimaryKey(Integer id);

    List<CustOptometryResultDto> selectByConditions(CustOptometryResultDto custOptometryResultDto);

    int updateByExampleSelective(@Param("record") CustOptometryResultDto record,
            @Param("example") CustOptometryResultExample example);

    int updateByExample(@Param("record") CustOptometryResultDto record,
            @Param("example") CustOptometryResultExample example);

    int updateByPrimaryKeySelective(CustOptometryResultDto record);

    int updateByPrimaryKey(CustOptometryResultDto record);
}