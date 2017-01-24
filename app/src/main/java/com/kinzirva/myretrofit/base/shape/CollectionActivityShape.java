package com.kinzirva.myretrofit.base.shape;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.kinzirva.myretrofit.base.ActivityShape;

import java.util.ArrayList;
import java.util.List;

/**
 * 收集所有Activity用的
 * TODO  在功能  在界面 最后一个装置者 制定顺序的人 才能  是抽象类 别的不要 不然方法都得实现太难看了
 * Created by kinzirva on 2017/1/23.
 */

public class CollectionActivityShape extends ActivityShape implements Handler.Callback, View.OnClickListener {

    public static List<Activity> activitys = new ArrayList<Activity>();

    public CollectionActivityShape(Activity activity) {
        super(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        activitys.add(activity);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }


    @Override
    public void onDestroy() {
        /* 防止内存泄漏 */
        activitys.remove(this);
        super.onDestroy();
    }

    /**
     * 结束所有 还存在的activitys  一般在异常出现的时候
     */
    public void finishAll() {
        for (Activity item : activitys) {
            item.finish();
        }
    }
}
