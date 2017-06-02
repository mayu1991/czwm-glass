package com.czwm.intf.user;

import com.czwm.dto.BaseResponse;
import com.czwm.dto.user.UserDto;

/**
 * Created by apple on 2017/5/16.
 */
public interface IUserService {
    /**
     * 登录功能
     *
     * @param userDto 用户信息
     * @return 登录结果
     */
    BaseResponse<UserDto> login(UserDto userDto);

    /**
     * 查询用户信息
     *
     * @param id 查询条件 用户ID
     * @return 用户信息
     */
    UserDto selectUserById(Integer id);
}
