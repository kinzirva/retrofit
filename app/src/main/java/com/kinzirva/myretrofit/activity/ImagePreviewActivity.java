package com.kinzirva.myretrofit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.kinzirva.myretrofit.R;
import com.kinzirva.myretrofit.base.AppContext;
import com.kinzirva.myretrofit.base.BaseActivity;
import com.kinzirva.myretrofit.widget.ZoomImageView;

/**
 * Created by kinzirva on 2017/1/23.
 */

public class ImagePreviewActivity extends BaseActivity {

    private ZoomImageView zoomImageView;
    private String imageUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_image_layout);
        Intent intent = getIntent();
        if (intent != null) {
            imageUrl = intent.getStringExtra("url");
            Log.d("ImagePreviewActivity", "image url : " + imageUrl);
        }
        zoomImageView = (ZoomImageView) findViewById(R.id.image);
    }

    @Override
    public void setContentView() {
    }

    @Override
    public void initData() {
    }

    @Override
    public void setListener() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (imageUrl != null) {
            Glide.with(AppContext.appContext).load(imageUrl).into(zoomImageView);
        }
    }
}
