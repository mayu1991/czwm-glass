package com.czwm.common;

/**
 * Created by apple on 2017/5/18.
 */
public enum HttpResponseCode {

    SUCCESS(1, "成功"),
    FAILURE(2, "失败");

    private Integer errorCode;
    private String message;

    HttpResponseCode(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

}
