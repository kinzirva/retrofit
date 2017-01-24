package com.kinzirva.myretrofit.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Activity基类
 * Created by kinzirva on 2017/1/23.
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, Handler.Callback{

    public Handler handler;
    protected ShapeControl mShapeControl;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        handler = new Handler(this);

        mShapeControl = new ShapeControl(this);
        mShapeControl.initKinds(this);
        updateKinds();

        mShapeControl.onCreate(arg0);

        setContentView();
        initData();
        setListener();
    }

    /**
     * 在 所有 mShapeControl.onCreate(arg0, this);之前使用
     * 在这里 移除与注册 ActivityKinds
     */
    public  void updateKinds() {

    }

    //---------------本类实现的方法-------------------
    @Override
    public void onClick(View v) {

    }
    public boolean handleMessage(Message msg) {
        return false;
    }
    // ---------------本类抽象的方法-------------------
    /**
     * 设置子类布局对象
     */
    public abstract void setContentView();

    /**
     * 子类初始化数据
     */
    public abstract void initData();

    /**
     * 子类设置事件监听
     */
    public abstract void setListener();




    //------------------Shapes的实现-------------------------------
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mShapeControl.onPostCreate(savedInstanceState);
    }

    ;

    @Override
    protected void onResume() {
        super.onResume();
        mShapeControl.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mShapeControl.onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mShapeControl.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mShapeControl.onDestroy();
    }
}
