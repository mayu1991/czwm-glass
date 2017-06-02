package com.czwm.dao.cust;

import com.czwm.common.page.Pagination;
import com.czwm.dto.cust.detail.CustDetailDto;
import com.czwm.dto.cust.detail.CustDetailExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by apple on 2017/5/16.
 */
@Repository
public interface ICustDetailDao {
    int countByExample(CustDetailExample example);

    int deleteByExample(CustDetailExample example);

    int deleteByPrimaryKey(String custName);

    int deleteByCustId(Integer custId);

    int insert(CustDetailDto record);

    int insertSelective(CustDetailDto record);

    List<CustDetailDto> selectByExample(CustDetailExample example);

    /**
     * 按输入条件查询客户信息，支持分页查询
     *
     * @param example    输入条件
     * @param pagination 分页属性
     * @return 客户列表
     */
    List<CustDetailDto> selectByConditionPaging(CustDetailDto example, Pagination pagination);

    /**
     * 按输入条件查询客户信息，支持分页查询
     *
     * @param example 输入条件
     * @return 客户列表
     */
    List<CustDetailDto> selectByCondition(CustDetailDto example);

    CustDetailDto selectByPrimaryKey(String custName);

    int updateByExampleSelective(@Param("record") CustDetailDto record,
            @Param("example") CustDetailExample example);

    int updateByExample(@Param("record") CustDetailDto record,
            @Param("example") CustDetailExample example);

    int updateByPrimaryKeySelective(CustDetailDto record);

    int updateByPrimaryKey(CustDetailDto record);
}
