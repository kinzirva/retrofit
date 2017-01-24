package com.kinzirva.myretrofit.service;

import com.kinzirva.myretrofit.modle.NeteaseNewBean;

import java.util.List;

/**
 * Created by kinzirva on 2017/1/24.
 */
public interface INewsListView {
    void update(List<NeteaseNewBean> neteaseNewBeen, int page);

    void onError(String msg);
}
