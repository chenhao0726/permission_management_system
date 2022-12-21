package com.chen.utils;

public class AjaxResult {
    // 是否操作成功 默认值true 成功
    private Boolean success = true;
    // 提示信息，默认提示成功
    private String message = "操作成功";
    //返回的数据
    private Object data;

    public static AjaxResult me() {
        return new AjaxResult();
    }

    public Boolean getSuccess() {
        return success;
    }

    public AjaxResult setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AjaxResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public AjaxResult setData(Object data) {
        this.data = data;
        return this;
    }
}
