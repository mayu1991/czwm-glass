package com.czwm.dto;

/**
 * Created by apple on 2017/5/17.
 */
public class BaseResponse<T> {
    private boolean success;//成功与否
    private String message; //提示信息
    private Integer errorCode;//错误码
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
