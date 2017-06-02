package com.czwm.common;

import org.springframework.core.MethodParameter;

/**
 * Created by apple on 2017/5/18.
 */
public interface BeanWrapper {

    boolean supportsType(MethodParameter var1);

    Object wrap(Object var1);
}
