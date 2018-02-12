package com.warrior.netease.news.news_inner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.warrior.netease.R;

/**
 * Created by u on 2018/2/12.
 */

public class HotFragment extends Fragment {
    ListView mListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot,container,false);
        mListView = (ListView)view.findViewById(R.id.listView);
        return view;
    }

    public void end(String end){

    }
}
