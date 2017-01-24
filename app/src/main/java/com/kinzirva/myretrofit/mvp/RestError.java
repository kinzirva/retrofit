package com.kinzirva.myretrofit.mvp;

import android.text.TextUtils;

/**
 * ${DESC}
 * Created by kinzirva on 2017/1/24.
 */
public class RestError {
    /** @deprecated */
    @Deprecated
    private int mCode;
    private String errCode;
    private String message;
    private int errorType;

    public int getErrorType() {
        return this.errorType;
    }

    public void setErrorType(int pErrorType) {
        this.errorType = pErrorType;
    }

    public RestError(String msg) {
        this.message = msg;
    }

    public int getCode() {
        return this.mCode;
    }

    public void setCode(int code) {
        this.mCode = code;
    }

    public String getMsg() {
        return TextUtils.isEmpty(this.message)?"":this.message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
