package com.czwm.imp.user;

import com.czwm.dto.BaseResponse;
import com.czwm.dto.user.UserDto;
import com.czwm.dto.user.UserExample;
import com.czwm.dao.user.IUserDao;
import com.czwm.intf.user.IUserService;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by apple on 2017/5/17.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public BaseResponse<UserDto> login(UserDto userDto) {
        //默认是成功的
        BaseResponse<UserDto> baseResp = new BaseResponse<UserDto>();
        baseResp.setSuccess(false);
        baseResp.setMessage("登录失败，请检查用户名、密码或者门市是否选择正确");

        //查询是否存在会员
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userDto.getUsername()); //用户名
        criteria.andPasswordEqualTo(userDto.getPassword()); //密码
//        criteria.andStoreIdEqualTo(userDto.getStoreId()); //门市ID
        List<UserDto> userDbs = userDao.selectByExample(example);
        if (CollectionUtils.isEmpty(userDbs)) {
            return baseResp;
        }

        String storeIds = userDbs.get(0).getStoreIds();
        //如果是管理员，任何门市的数据都可以访问
        if (userDbs.get(0).getAuthorityType().equals(AuthorityTypeEnum.ADMIN.getKey())) {
            baseResp.setSuccess(true);
            baseResp.setData(userDbs.get(0));
        } else if (!StringUtils.isEmpty(storeIds)) {
            //不是管理员
            String[] storeIdArray = storeIds.split(",");
            if (!ArrayUtils.isEmpty(storeIdArray)) {
                for (String storeId : storeIdArray) {
                    //账号的门市ID符合
                    if (storeId.equals(userDto.getStoreId() + "")) {
                        baseResp.setSuccess(true);
                        baseResp.setData(userDbs.get(0));
                    }
                }
            }
        }
        return baseResp;
    }

    @Override
    public UserDto selectUserById(Integer id) {
        //查询是否存在会员
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<UserDto> userDbs = userDao.selectByExample(example);
        if (!CollectionUtils.isEmpty(userDbs)) {
            return userDbs.get(0);
        } else {
            return null;
        }
    }
}
