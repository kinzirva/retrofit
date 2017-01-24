package com.kinzirva.myretrofit.service.callback;


import com.kinzirva.myretrofit.modle.ImageBean;
import com.kinzirva.myretrofit.modle.NeteaseNewBean;

import java.util.List;

/**
 * Created by kinzirva on 2017/1/23.
 */

public interface RespCallback {

    void onSuccess(List<ImageBean> beanList);

    void onFailed(String msg);

    void onSuccesses(List<NeteaseNewBean> beanList);

}
