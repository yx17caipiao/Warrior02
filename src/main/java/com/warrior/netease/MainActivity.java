package com.warrior.netease;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.warrior.netease.news.fragment.EmptyFragment;
import com.warrior.netease.news.fragment.NewsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(R.id.tab_Host);

        String[] titles = getResources().getStringArray(R.array.tab_title);
        int [] icons = new int[]{R.drawable.news_selector,R.drawable.reading_selector,R.drawable.video_selector,R.drawable.topic_selector,R.drawable.mine_selector};
        Class[] classes = new Class[]{NewsFragment.class,EmptyFragment.class,EmptyFragment.class,EmptyFragment.class,EmptyFragment.class};
        tabHost.setup(this,getSupportFragmentManager(),R.id.content);
//
        for(int i=0;i<titles.length;i++){
            TabHost.TabSpec tmp =  tabHost.newTabSpec(""+i);
            tmp.setIndicator(getEveryView(this,titles,icons,i));
            tabHost.addTab(tmp,classes[i],null);
        }



        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

            }
        });
//        tabHost.setCurrentTabByTag("2");

    }


    public View getEveryView(Context context,String[] titles,int[] icons,int index){
        LayoutInflater inflater = LayoutInflater.from(context);
        View title_view = inflater.inflate(R.layout.item_title,null);
        TextView title = (TextView) title_view.findViewById(R.id.title);
        ImageView icon = (ImageView) title_view.findViewById(R.id.icon);
        title.setText(titles[index]);
        icon.setImageResource(icons[index]);
        return title_view;
    }
}
