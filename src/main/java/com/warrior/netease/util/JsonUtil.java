package com.warrior.netease.util;

import android.text.TextUtils;

import com.google.gson.Gson;

/**
 * Created by u on 2018/1/25.
 */

public class JsonUtil {
    static Gson mGson;
    public static <T> T parseJson(String json,Class<T> tClass){
        if(mGson==null){
            mGson = new Gson();
        }
        if(TextUtils.isEmpty(json)){
            return null;
        }
        return mGson.fromJson(json,tClass);
    }
}
