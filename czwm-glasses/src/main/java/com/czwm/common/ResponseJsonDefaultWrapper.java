package com.czwm.common;

import org.springframework.core.MethodParameter;

/**
 * author mayu
 */
public class ResponseJsonDefaultWrapper implements BeanWrapper {

    public boolean supportsType(MethodParameter returnType) {
        return !HttpBaseResponse.class.isAssignableFrom(returnType.getParameterType());
    }

    public Object wrap(Object bean) {
        /**
         * here we get the business bean, just wrap it to HttpBaseResponse
         */
        HttpBaseResponse response = new HttpBaseResponse();
        response.setErrorCode(HttpResponseCode.SUCCESS.getErrorCode());
        response.setData(bean);
        response.setMessage(HttpResponseCode.SUCCESS.getMessage());
        response.setSuccess(true);
        return response;
    }
}
