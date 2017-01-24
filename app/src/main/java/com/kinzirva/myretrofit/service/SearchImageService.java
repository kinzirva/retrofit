package com.kinzirva.myretrofit.service;

import com.kinzirva.myretrofit.modle.SearchImageBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kinzirva on 2017/1/23.
 */

interface SearchImageService {

    @GET("/search/acjson")
    Observable<SearchImageBean> RxContributors(@Query("tn") String tn,
                                               @Query("ipn") String ipn,
                                               @Query("fp") String fp,
                                               @Query("queryWord") String word1,
                                               @Query("word") String word2,
                                               @Query("pn") int pn,
                                               @Query("rn") int rn);
}
