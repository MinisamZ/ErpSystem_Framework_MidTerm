package com.example.ERP.System.model.rest;

public class ResponseStatus {

    private Object success;
    private Boolean needChangePassword;
    private Object status;

    ResponseStatus(Object success) {
        this.success = success;
    }

    ResponseStatus(Object status, boolean needChangePassword) {
        this.status = status;
        this.needChangePassword = needChangePassword;
    }

    public Object getSuccess() {
        return success;
    }

    public void setSuccess(Object success) {
        this.success = success;
    }

    public Boolean getNeedChangePassword() {
        return needChangePassword;
    }

    public void setNeedChangePassword(Boolean needChangePassword) {
        this.needChangePassword = needChangePassword;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }
}
