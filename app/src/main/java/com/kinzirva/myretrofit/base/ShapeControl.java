package com.kinzirva.myretrofit.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kinzirva.myretrofit.base.shape.CollectionActivityShape;
import com.kinzirva.myretrofit.base.shape.FeatureShape;
import com.kinzirva.myretrofit.base.shape.ScreenSettingShape;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESC}
 * Created by kinzirva on 2017/1/23.
 */

public class ShapeControl extends ActivityShape {
    public Map<Class, ActivityShape> controlMap = new HashMap<>();

    public ShapeControl(Activity activity) {
        super(activity);
    }

    //在onCreate 之前调用不然为空;
    public void initKinds(Activity context) {
        controlMap.put(CollectionActivityShape.class, new CollectionActivityShape(context));
        //声明后 注意 把拍照的功能添加到FeaturesKind里面 mKindControl.get(FeaturesKind.class).addFeature(feature_Pic);
        controlMap.put(FeatureShape.class, new FeatureShape(context));
        controlMap.put(ScreenSettingShape.class, new ScreenSettingShape(context));
//        controlMap.put(SwipeBackKind.class, new SwipeBackKind(context));←滑动退出Activiry（暂时不需要）
    }

    public <T extends ActivityShape> T get(Class<T> key) {
        return (T) controlMap.get(key);
    }

    public void put(ActivityShape value) {
        controlMap.put(value.getClass(), value);
    }

    public void remove(Class key) {
        controlMap.remove(key);
    }

    @Override
    public void onCreate(Bundle bundle) {
        for (Map.Entry<Class, ActivityShape> item : controlMap.entrySet())
            item.getValue().onCreate(bundle);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        for (Map.Entry<Class, ActivityShape> item : controlMap.entrySet())
            item.getValue().onPostCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        for (Map.Entry<Class, ActivityShape> item : controlMap.entrySet())
            item.getValue().onResume();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        for (Map.Entry<Class, ActivityShape> item : controlMap.entrySet())
            item.getValue().onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    public void onPause() {
        for (Map.Entry<Class, ActivityShape> item : controlMap.entrySet())
            item.getValue().onPause();
    }

    @Override
    public void onDestroy() {
        for (Map.Entry<Class, ActivityShape> item : controlMap.entrySet())
            item.getValue().onDestroy();
    }
}
