package com.kinzirva.myretrofit.presenter;


import android.text.TextUtils;

import com.kinzirva.myretrofit.modle.ImageBean;
import com.kinzirva.myretrofit.modle.NeteaseNewBean;
import com.kinzirva.myretrofit.mvp.IPresenter;
import com.kinzirva.myretrofit.mvp.IView;
import com.kinzirva.myretrofit.service.BaiduSearchMapApi;
import com.kinzirva.myretrofit.service.ISearchImageView;
import com.kinzirva.myretrofit.service.callback.RespCallback;

import java.util.List;

/**
 * Created by kinzirva on 2017/1/23.
 */

public class SearchImagePresenter implements IPresenter {

    private ISearchImageView iSearchImageView;
    private int mPage = 0;

    public SearchImagePresenter(ISearchImageView iView) {
        iSearchImageView = iView;
    }

    public void getData(String word, boolean isFirstPage) {
        if (isFirstPage) {
            mPage = 0;
        } else {
            mPage++;
        }

        BaiduSearchMapApi.execute(word, mPage, respCallback);
    }

    private RespCallback respCallback = new RespCallback() {
        @Override
        public void onSuccess(List<ImageBean> beanList) {
            iSearchImageView.update(beanList, mPage);
        }

        @Override
        public void onFailed(String msg) {
            if(TextUtils.isEmpty(msg)){
                return;
            }
            iSearchImageView.onError(msg);
        }

        @Override
        public void onSuccesses(List<NeteaseNewBean> beanList) {

        }
    };

    @Override
    public void attachView(IView var1) {

    }

    @Override
    public void detachView() {
        iSearchImageView = null;

    }
}
