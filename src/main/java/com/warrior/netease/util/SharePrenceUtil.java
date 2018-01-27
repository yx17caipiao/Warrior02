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

    public static void saveInt(Context context, String title, int content){
        SharedPreferences share = context.getSharedPreferences(XML_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putInt(title,content);
        edit.apply();
    }

    public static int getInt(Context context,String title){
        int content;
        SharedPreferences share = context.getSharedPreferences(XML_FILE_NAME,Context.MODE_PRIVATE);
        content = share.getInt(title,0);
        return content;
    }

    public static void saveLong(Context context, String title, long content){
        SharedPreferences share = context.getSharedPreferences(XML_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putLong(title,content);
        edit.apply();
    }

    public static long getLong(Context context,String title){
        long content;
        SharedPreferences share = context.getSharedPreferences(XML_FILE_NAME,Context.MODE_PRIVATE);
        content = share.getLong(title,0);
        return content;
    }

}
