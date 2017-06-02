package com.czwm.dao.user;

import com.czwm.dto.user.UserDto;
import com.czwm.dto.user.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDto record);

    int insertSelective(UserDto record);

    List<UserDto> selectByExample(UserExample example);

    UserDto selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDto record, @Param("example") UserExample example);

    int updateByExample(@Param("record") UserDto record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(UserDto record);

    int updateByPrimaryKey(UserDto record);
}