package com.czwm.controller.store;

import com.czwm.common.HttpBaseResponse;
import com.czwm.dto.store.StoreDto;
import com.czwm.intf.store.IStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门市管理模块的控制器
 * Created by apple on 2017/5/16.
 */
@Controller
@RequestMapping(value = "/store")
public class StoreController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

    @Resource
    IStoreService storeService;

    /**
     * 查询门市列表
     * 返回登录结果
     */
    @RequestMapping(value = "/all/get", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public HttpBaseResponse getAll() {

        HttpBaseResponse response = new HttpBaseResponse();
        response.setSuccess(true);
        //查询所有门市
        List<StoreDto> storeDbs = storeService.getStoreAll();
        response.setData(storeDbs);
        return response;
    }
}
