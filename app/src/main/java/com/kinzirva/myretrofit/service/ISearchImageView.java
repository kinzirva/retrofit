package com.kinzirva.myretrofit.service;


import com.kinzirva.myretrofit.modle.ImageBean;
import com.kinzirva.myretrofit.mvp.IView;

import java.util.List;

/**
 * Created by kinzirva on 2017/1/23.
 */

public interface ISearchImageView extends IView {

    void update(List<ImageBean> imageBeanList, int page);

    void onError(String msg);
}
