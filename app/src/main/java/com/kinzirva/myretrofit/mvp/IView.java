package com.kinzirva.myretrofit.mvp;

/**
 * Created by kinzirva on 2017/1/23.
 */

public interface IView {
    void onExceptionDispose(RestError var1);

    void onDismissLoadingDialog();

    void onShowLoadingDialog();
}
