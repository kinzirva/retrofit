package com.kinzirva.myretrofit.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * ${DESC}
 * Created by kinzirva on 2017/1/23.
 */

public class ActivityShape {
    public Activity activity;

    public ActivityShape(Activity activity) {
        this.activity = activity;
    }

    /*
         * @param bundle
         * @param activity 唯一有差别的地方
         */
    public void onCreate(Bundle bundle) {
    }

    public void onPostCreate(@Nullable Bundle savedInstanceState) {
    }

    public void onResume() {

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

    }

    public void onPause() {

    }

    public void onDestroy() {

    }
}
