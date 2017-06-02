package com.czwm.controller.user;

import com.czwm.common.HttpBaseResponse;
import com.czwm.dto.BaseResponse;
import com.czwm.dto.user.UserDto;
import com.czwm.intf.user.IUserService;
import com.czwm.util.DateUtils;
import com.czwm.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户管理模块的控制器
 * Created by apple on 2017/5/16.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    IUserService userService;

    /**
     * 登录
     * 返回登录结果
     *
     * @param userDto 用户名、密码、门市
     */
    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public BaseResponse<UserDto> login(UserDto userDto) {
        LOGGER.info("用户登录：" + JsonUtils.toString(userDto) + "，登录时间：" + DateUtils
                .formatDate2YYYY_MM_DD_HH_MM_SS_SSS(new Date()));
        return userService.login(userDto);
    }

    /**
     * 查询用户详情
     * 返回用户详情
     *
     * @param id 用户ID
     */
    @RequestMapping(value = "/detail/query/{id}", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse getDetail(@PathVariable Integer id) {
        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);

        try {
            UserDto userDto = userService.selectUserById(id);
            response.setData(userDto);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("系统异常");
        }
        return response;
    }
}
