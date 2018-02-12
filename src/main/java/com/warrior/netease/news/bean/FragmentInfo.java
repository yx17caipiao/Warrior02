package com.warrior.netease.news.bean;

import android.support.v4.app.Fragment;

/**
 * Created by u on 2018/2/12.
 */

public class FragmentInfo {
    Fragment mFragment;
    String title;

    public FragmentInfo(Fragment fragment,String title){
        mFragment = fragment;
        this.title = title;
    }
    public void setmFragment(Fragment mFragment) {
        this.mFragment = mFragment;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getmFragment() {

        return mFragment;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "FragmentInfo{" +
                "mFragment=" + mFragment +
                ", title='" + title + '\'' +
                '}';
    }
}
