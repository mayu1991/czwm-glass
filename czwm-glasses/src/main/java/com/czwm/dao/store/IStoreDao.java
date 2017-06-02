package com.czwm.dao.store;

import com.czwm.dto.store.StoreDto;
import com.czwm.dto.store.StoreExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStoreDao {
    int countByExample(StoreExample example);

    int deleteByExample(StoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreDto record);

    int insertSelective(StoreDto record);

    List<StoreDto> selectByExample(StoreExample example);

    StoreDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreDto record,
            @Param("example") StoreExample example);

    int updateByExample(@Param("record") StoreDto record, @Param("example") StoreExample example);

    int updateByPrimaryKeySelective(StoreDto record);

    int updateByPrimaryKey(StoreDto record);
}