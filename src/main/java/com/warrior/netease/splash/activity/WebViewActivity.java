package com.warrior.netease.splash.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.warrior.netease.splash.bean.Action;

/**
 * Created by u on 2018/1/30.
 */

public class WebViewActivity extends Activity {
    public static final String ACTION_NAME = "action";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Action action = (Action)getIntent().getSerializableExtra(ACTION_NAME);
    }
}
