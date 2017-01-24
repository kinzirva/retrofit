package com.kinzirva.myretrofit.mvp;

/**
 * Created by kinzirva on 2017/1/23.
 */

public interface IPresenter<V extends IView> {
    void attachView(V var1);

    void detachView();
}
