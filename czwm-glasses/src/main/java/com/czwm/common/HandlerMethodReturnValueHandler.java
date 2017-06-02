package com.czwm.common;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by apple on 2017/5/18.
 */
public interface HandlerMethodReturnValueHandler {
    boolean supportsReturnType(MethodParameter var1);

    void handleReturnValue(Object var1, MethodParameter var2, ModelAndViewContainer var3,
            NativeWebRequest var4) throws Exception;
}
