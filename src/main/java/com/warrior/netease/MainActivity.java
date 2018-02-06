package com.warrior.netease;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

import com.warrior.netease.news.fragment.EmptyFragment;
import com.warrior.netease.news.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(R.id.tab_Host);
        tabHost.setup(this,getSupportFragmentManager(),R.id.content);
//
        TabHost.TabSpec one = tabHost.newTabSpec("1");
        one.setIndicator(getEveryView(this));
        TabHost.TabSpec two = tabHost.newTabSpec("2");
        two.setIndicator(getEveryView(this));
        TabHost.TabSpec three = tabHost.newTabSpec("3");
        three.setIndicator(getEveryView(this));

        tabHost.addTab(one, NewsFragment.class,null);
        tabHost.addTab(two, EmptyFragment.class,null);
        tabHost.addTab(three, EmptyFragment.class,null);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

            }
        });

    }


    public View getEveryView(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        View title_view = inflater.inflate(R.layout.item_title,null);
        return title_view;
    }
}
