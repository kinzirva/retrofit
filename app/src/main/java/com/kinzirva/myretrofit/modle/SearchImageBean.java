package com.kinzirva.myretrofit.modle;

import java.util.List;

/**
 * Created by kinzirva on 2017/1/23.
 */

public class SearchImageBean {

    private int gsm;

    public int getGsm() {
        return gsm;
    }

    public void setGsm(int gsm) {
        this.gsm = gsm;
    }

    private List<ImageBean> data;

    public List<ImageBean> getData() {
        return data;
    }

    public void setData(List<ImageBean> data) {
        this.data = data;
    }
}
