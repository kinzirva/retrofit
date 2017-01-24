package com.kinzirva.myretrofit.base;

import android.app.Application;

import com.bumptech.glide.Glide;

/**
 * Created by kinzirva on 2017/1/23.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initApp();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();

    }

    private void initApp() {
        AppContext.appContext = this;
    }

}
