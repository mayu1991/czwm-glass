package com.czwm.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 2017/5/18.
 */
public class MyResponseJsonMethodProcessor implements
        HandlerMethodReturnValueHandler, InitializingBean {

    private HttpMessageConverter messageConverter;
    private List<BeanWrapper> beanWrappers;

    public boolean supportsReturnType(MethodParameter returnType) {
        return supportsReturnType(returnType)
                || returnType.getMethodAnnotation(EncodeBody.class) != null;
    }

    public void handleReturnValue(Object returnValue, MethodParameter returnType,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest) throws Exception {
        /**
         * business return value
         */
        Object result = returnValue;
        /**
         * tell container that request is handled
         */
        mavContainer.setRequestHandled(true);
        ServletServerHttpResponse outputMessage = createOutputMessage(webRequest);
        if (returnValue == null) {
            Map<String, Object> message = new HashMap<String, Object>();
            message.put("code", HttpResponseCode.SUCCESS);
            message.put("obj", new HashMap<String, String>());
            message.put("ext", new HashMap<String, String>());
            result = message;
        } else {
            ResponseJson responseJson = returnType.getMethodAnnotation(ResponseJson.class);
            if (responseJson != null) {
                if ((responseJson.location() == ResponseJson.Location.MESSAGE)
                        || ((returnValue instanceof String) && (responseJson.location()
                        == ResponseJson.Location.UNDEFINED))) {
                    Map<String, Object> message = new HashMap<String, Object>();
                    message.put("code", HttpResponseCode.SUCCESS);
                    message.put("obj", new HashMap<String, String>());
                    result = message;
                } else {
                    //EncodeResponse.class; it means just
                    //parse the return value to json
                    for (BeanWrapper beanWrapper : getBeanWrappers()) {
                        if (beanWrapper.supportsType(returnType)) {
                            result = beanWrapper.wrap(returnValue);
                            break;
                        }
                    }
                }
            }

        }
        getMessageConverter().write(result,
                new MediaType(MediaType.APPLICATION_JSON, Collections
                        .singletonMap("charset", "UTF-8")), outputMessage);
    }

    protected ServletServerHttpResponse createOutputMessage(NativeWebRequest webRequest) {
        HttpServletResponse response = (HttpServletResponse) webRequest
                .getNativeResponse(HttpServletResponse.class);
        return new ServletServerHttpResponse(response);
    }

    public void afterPropertiesSet() throws Exception {
        if (this.beanWrappers == null || this.beanWrappers.size() == 0) {
            throw new Exception("beanWrappers undefined");
        }
    }

    public void setBeanWrappers(List<BeanWrapper> beanWrappers) {
        this.beanWrappers = beanWrappers;
    }

    public HttpMessageConverter getMessageConverter() {
        return this.messageConverter;
    }

    public void setMessageConverter(HttpMessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

    public List<BeanWrapper> getBeanWrappers() {
        return this.beanWrappers;
    }

}
