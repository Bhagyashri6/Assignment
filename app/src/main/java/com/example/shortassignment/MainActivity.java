package com.example.shortassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.shortassignment.Adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager view_pager;
    private TabLayout tab_layout;
    private ThinkliesFragment thinkliesFragment;
    private News_FeedFragment news_feedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        view_pager =findViewById(R.id.view_pager);
        tab_layout = findViewById(R.id.tab_layout);

        thinkliesFragment = new ThinkliesFragment();
        news_feedFragment = new News_FeedFragment();

        tab_layout.setupWithViewPager(view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(thinkliesFragment,"Thinklies");
        viewPagerAdapter.addFragment(news_feedFragment,"News Feed");
        view_pager.setAdapter(viewPagerAdapter);



    }

}