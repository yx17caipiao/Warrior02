package com.warrior.netease.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by u on 2018/1/26.
 */

public class SharePrenceUtil {
    public static final String XML_FILE_NAME = "cache";
    public static void saveString(Context context, String title, String content){
        SharedPreferences share = context.getSharedPreferences(XML_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putString(title,content);
        edit.apply();
    }

    public static String getString(Context context,String title){
        String content;
        SharedPreferences share = context.getSharedPreferences(XML_FILE_NAME,Context.MODE_PRIVATE);
        content = share.getString(title,"");
        return content;
    }

}
