package com.kinzirva.myretrofit.base.shape;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.kinzirva.myretrofit.base.ActivityShape;

/**
 * 设置标题和全屏 setNoTitle,setFullScreen的
 * Created by kinzirva on 2017/1/23.
 */

public class ScreenSettingShape extends ActivityShape {
    public ScreenSettingShape(Activity activity) {
        super(activity);
    }
    /**
     * 必须在 setContentView 之前用 否则无效！
     */
    public void setNoTitle() {
        //设置无标题
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * setContentView 之后用
     */
    public void setNoTitle_AppCompatActivity() {
        //设置无标题
        ((AppCompatActivity) activity).getSupportActionBar().hide();
    }

    /**
     * 必须在 setContentView 之前用 否则无效!
     */
    public void setFullScreen() {
        //设置全屏
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
