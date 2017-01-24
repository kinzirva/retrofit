package com.kinzirva.myretrofit.activity;

import android.content.Intent;
import android.util.Log;
import android.webkit.WebView;

import com.kinzirva.myretrofit.R;
import com.kinzirva.myretrofit.base.BaseActivity;

/**
 * Created by kinzirva on 2017/1/23.
 */

public class NewDetailActivity extends BaseActivity {

    private WebView webView;
    private String webUrl;

    @Override
    public void setContentView() {
        setContentView(R.layout.new_detail_layout);
        webView = (WebView) findViewById(R.id.webview);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            webUrl = intent.getStringExtra("url");
            Log.d("NewDetailActivity", "web url : " + webUrl);
        }
    }

    @Override
    public void setListener() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (webUrl != null) {
            webView.loadUrl(webUrl);
        }
    }
}
