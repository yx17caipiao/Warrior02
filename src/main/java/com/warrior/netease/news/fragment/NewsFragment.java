package com.warrior.netease.news.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.warrior.netease.R;
import com.warrior.netease.news.adapter.NewAdapter;
import com.warrior.netease.news.bean.FragmentInfo;
import com.warrior.netease.news.news_inner.HotFragment;

import java.util.ArrayList;

/**
 * Created by SaRo on 2018/2/6.
 */

public class NewsFragment extends Fragment {
    ArrayList<FragmentInfo> pages;
    NewAdapter mNewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pages = new ArrayList<>();
        FrameLayout layout = (FrameLayout)getActivity().findViewById(R.id.tabs);
        layout.addView(View.inflate(getActivity(),R.layout.include_tab,null));
        SmartTabLayout smartTabLayout = (SmartTabLayout)getActivity().findViewById(R.id.smart_tab);
        ViewPager viewPager = (ViewPager)getActivity().findViewById(R.id.viewpager);

        String[] titles = getResources().getStringArray(R.array.news_titles);
        for (int i = 0; i < titles.length; i++) {
            FragmentInfo info;
            if(i==0){
                info = new FragmentInfo(new HotFragment(),titles[i]);
            }else{
                info = new FragmentInfo(new EmptyFragment(),titles[i]);
            }
            pages.add(info);
        }
        mNewAdapter = new NewAdapter(getFragmentManager(),pages);
        viewPager.setAdapter(mNewAdapter);

        smartTabLayout.setViewPager(viewPager);
    }
}
