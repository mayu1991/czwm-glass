package com.czwm.common;

/**
 * Created by apple on 2017/5/18.
 */
public class HttpBaseResponse {

    private boolean success;//成功与否
    private String message; //提示信息
    private Integer errorCode;//错误码
    private Object data;//数据

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
