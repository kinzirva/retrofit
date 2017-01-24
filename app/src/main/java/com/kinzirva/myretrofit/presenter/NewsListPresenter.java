package com.kinzirva.myretrofit.presenter;


import com.kinzirva.myretrofit.mvp.IView;
import com.kinzirva.myretrofit.service.INewsListView;
import com.kinzirva.myretrofit.service.callback.RespCallback;
import com.kinzirva.myretrofit.modle.ImageBean;
import com.kinzirva.myretrofit.modle.NeteaseNewBean;
import com.kinzirva.myretrofit.modle.NeteaseNewsApi;
import com.kinzirva.myretrofit.mvp.IPresenter;

import java.util.List;

/**
 * Created by louzhen on 16/10/19.
 */

public class NewsListPresenter implements IPresenter {

    private INewsListView mINewsListView;
    private int mPage = 0;

    public NewsListPresenter(INewsListView iNewsListView) {
        this.mINewsListView = iNewsListView;
    }

    public void getData(boolean isFirstPage) {
        if (isFirstPage) {
            mPage = 0;
        } else {
            mPage++;
        }
        NeteaseNewsApi.excute(mPage, respCallback);
    }

    RespCallback respCallback = new RespCallback() {
        @Override
        public void onSuccess(List<ImageBean> beanList) {

        }

        @Override
        public void onFailed(String msg) {
            mINewsListView.onError(msg);
        }

        @Override
        public void onSuccesses(List<NeteaseNewBean> beanList) {
            mINewsListView.update(beanList, mPage);

        }
    };


    @Override
    public void attachView(IView var1) {

    }

    @Override
    public void detachView() {
        mINewsListView = null;

    }
}
