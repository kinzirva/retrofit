package com.kinzirva.myretrofit.base.shape;

import android.app.Activity;
import android.content.Intent;

import com.kinzirva.myretrofit.base.ActivityShape;
import com.kinzirva.myretrofit.base.ExtraFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * 专门处理关于onActivityResult的
 * <br>故：onResume以后才能用ExtraFeature　onPause就不能用了
 * <br>注意：onResume()　【从新初始化资源 例如Camera、sensor】
 * <br>onPause()【清除资源 避免浪费  例如Camera、sensor】
 * ExtraFeature(观察者的基类):专注：init（onResume中使用）,onActivityResult,destory RequestCodeConfig(所有ExtraFeature的Code声明):
 * 其中的START_CODE(默认1000开始)可以修改,而进行整体code偏移 主要是怕碰到别的类似开源项目code重复导致不必要的问题;
 * Created by kinzirva on 2017/1/23.
 */

public class FeatureShape extends ActivityShape {
    public FeatureShape(Activity activity) {
        super(activity);
    }
    public List<ExtraFeature> featureList = new ArrayList<ExtraFeature>();
    private boolean isInit;


    @Override
    public void onResume() {
        super.onResume();
        if (!isInit) {
            initFeature();
            isInit = true;
        }
        for (ExtraFeature item : featureList) {
            item.init();
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        for (ExtraFeature item : featureList) {
            item.onActivityResult(requestCode, resultCode, intent);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        for (ExtraFeature item : featureList) {
            item.destory();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public FeatureShape addFeature(ExtraFeature feature) {
        featureList.add(feature);
        return this;
    }

    public void initFeature() {

    }

    ;
}
