//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.czwm.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseJson {
    boolean translate() default false;

    ResponseJson.Location location() default ResponseJson.Location.BYREQUEST;

    ResponseJson.compressType compressType() default ResponseJson.compressType.NOCOMPRESS;

    public static enum Location {
        UNDEFINED,
        DATA,
        MESSAGE,
        BYREQUEST;

        private Location() {
        }
    }

    public static enum compressType {
        NOCOMPRESS,
        SNAPPY,
        GZIP,
        BYREQUEST;

        private compressType() {
        }
    }
}
