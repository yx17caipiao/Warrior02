package com.warrior.netease.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.warrior.netease.news.bean.FragmentInfo;
import com.warrior.netease.news.fragment.NewsFragment;

import java.util.ArrayList;

/**
 * Created by u on 2018/2/12.
 */

public class NewAdapter extends FragmentStatePagerAdapter {
    ArrayList<FragmentInfo> mFragments;

    public NewAdapter(FragmentManager fm, ArrayList<FragmentInfo> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position).getmFragment();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragments.get(position).getTitle();
    }
}
