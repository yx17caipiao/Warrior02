package com.warrior.netease.splash.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.warrior.netease.R;
import com.warrior.netease.splash.bean.Action;

/**
 * Created by u on 2018/1/30.
 */

public class WebViewActivity extends Activity {
    public static final String ACTION_NAME = "action";
    WebView wb_new;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Action action = (Action)getIntent().getSerializableExtra(ACTION_NAME);
        setContentView(R.layout.activity_webview);
        wb_new = (WebView)findViewById(R.id.wb_new);
        wb_new.getSettings().setJavaScriptEnabled(true);
        wb_new.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        wb_new.getSettings().setUseWideViewPort(true);
        wb_new.getSettings().setLoadWithOverviewMode(true);

//        wb_new.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        wb_new.getSettings().setSupportMultipleWindows(true);
        wb_new.setWebViewClient(new WebViewClient());
//        wb_new.setWebChromeClient(new WebChromeClient());


        wb_new.loadUrl(action.getLink_url());
    }

    @Override
    public void onBackPressed() {
        if(wb_new.canGoBack()){
            wb_new.goBack();
            return;
        }
        super.onBackPressed();
    }
}
