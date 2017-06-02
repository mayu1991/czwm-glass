package com.czwm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * Json工具类
 * Created by apple on 2017/5/17.
 */
public class JsonUtils {

    /**
     * 支持object(String)转成bean
     *
     * @param object 源数据
     * @param tClass 目标bean的类型
     * @param <T>    目标bean
     * @return 目标bean
     */
    public static <T> T toBean(Object object, Class<T> tClass) {
        if (object == null) {
            return null;
        }
        return JSON.parseObject(object.toString(), tClass);
    }

    /**
     * 支持object(String)转成List
     *
     * @param object 源数据
     * @param tClass 目标bean的类型
     * @param <T>    目标bean
     * @return 目标bean
     */
    public static <T> List<T> toList(Object object, Class<T> tClass) {
        if (object == null) {
            return null;
        }
        return JSONArray.parseArray(object.toString(), tClass);
    }

    /**
     * 支持Object转String
     *
     * @param obj 源数据
     * @return String
     */
    public static String toString(Object obj) {
        return JSON.toJSONString(obj);
    }
}
