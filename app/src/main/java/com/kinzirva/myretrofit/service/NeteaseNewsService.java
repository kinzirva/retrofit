package com.kinzirva.myretrofit.service;

import com.kinzirva.myretrofit.modle.NeteaseNewBean;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by kinzirva on 2017/1/23.
 */

public interface NeteaseNewsService {

    @GET("/nc/article/headline/T1348647909107/{startPage}-20.html")
    Observable<Map<String, List<NeteaseNewBean>>> getNewsList(
            @Path("startPage") int startPage);
}
