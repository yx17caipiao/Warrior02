package com.warrior.netease.splash.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.warrior.netease.R;
import com.warrior.netease.service.DowloadImageService;
import com.warrior.netease.splash.bean.Ads;
import com.warrior.netease.util.Constant;
import com.warrior.netease.util.JsonUtil;
import com.warrior.netease.util.SharePrenceUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by u on 2018/1/24.
 */

public class SplashActivity extends Activity {

    ImageView iv_ads;
    //json 缓存
    static final String JSON_CACHE = "ads_Json";
    static final String JSON_CACHE_TIME_OUT = "ads_Json_time_out";
    static final String JSON_CACHE_LAST_SUCCESS = "ads_Json_last";
    static final String LAST_IMAGE_INDEX ="img_index";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        iv_ads = (ImageView)findViewById(R.id.ads);
        getAds();

    }


    public void showImage(){

    }

    public void getAds(){
        String cache = SharePrenceUtil.getString(this,JSON_CACHE);
        if(TextUtils.isEmpty(cache)){
            httpRequest();
        }else{
            int time_Out = SharePrenceUtil.getInt(this,JSON_CACHE_TIME_OUT);
            long now = System.currentTimeMillis();
            long last = SharePrenceUtil.getLong(this,JSON_CACHE_LAST_SUCCESS);
            if((now-last)>time_Out*60*1000){
                httpRequest();
            }
        }
    }

    public void httpRequest(){
        final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Constant.SPLASH_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful()){

                }
                String date = response.body().string();
                Ads ads = JsonUtil.parseJson(date,Ads.class);
                if(null!=ads){
                    SharePrenceUtil.saveString(SplashActivity.this,JSON_CACHE,date);
                    SharePrenceUtil.saveInt(SplashActivity.this,JSON_CACHE_TIME_OUT,ads.getNext_req());
                    SharePrenceUtil.saveLong(SplashActivity.this,JSON_CACHE_LAST_SUCCESS,System.currentTimeMillis());
                    Intent intent = new Intent();
                    intent.setClass(SplashActivity.this,DowloadImageService.class);
                    intent.putExtra(DowloadImageService.ADS_DATE ,ads);
                    startService(intent);
                }else{

                }
            }
        });
    }
}
