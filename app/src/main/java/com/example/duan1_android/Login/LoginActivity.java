package com.example.duan1_android.Login;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;


import com.example.duan1_android.R;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager2);
        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm,getLifecycle());
        viewPager2.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("SignUp"));

        tabLayout.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#0B0B0B")));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0B0B0B"));
        tabLayout.setTabIndicatorFullWidth(false);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}