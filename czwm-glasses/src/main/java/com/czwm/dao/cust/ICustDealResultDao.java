package com.czwm.dao.cust;

import com.czwm.dto.cust.deal.CustDealResultDto;
import com.czwm.dto.cust.deal.CustDealResultExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustDealResultDao {
    int countByExample(CustDealResultExample example);

    int deleteByExample(CustDealResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustDealResultDto record);

    int insertSelective(CustDealResultDto record);

    List<CustDealResultDto> selectByExample(CustDealResultExample example);

    CustDealResultDto selectByPrimaryKey(Integer id);

    CustDealResultDto selectByCustId(Integer custId);

    List<CustDealResultDto> selectByConditions(CustDealResultDto custDealResultDto);

    int deleteByCustId(Integer custId);

    int updateByExampleSelective(@Param("record") CustDealResultDto record,
            @Param("example") CustDealResultExample example);

    int updateByExample(@Param("record") CustDealResultDto record,
            @Param("example") CustDealResultExample example);

    int updateByPrimaryKeySelective(CustDealResultDto record);

    int updateByPrimaryKey(CustDealResultDto record);
}