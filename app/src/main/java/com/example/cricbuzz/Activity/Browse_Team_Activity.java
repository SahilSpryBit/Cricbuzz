package com.example.cricbuzz.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cricbuzz.Fragment.BrowseSeries.T20_SeriesFragment;
import com.example.cricbuzz.Fragment.BrowseTeams.Domestic_TeamFragment;
import com.example.cricbuzz.Fragment.BrowseTeams.Internatinal_TeamFragment;
import com.example.cricbuzz.Fragment.BrowseTeams.T20League_TeamFragment;
import com.example.cricbuzz.Fragment.BrowseTeams.Women_TeamFragment;
import com.example.cricbuzz.R;
import com.google.android.material.tabs.TabLayout;

public class Browse_Team_Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_team);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(myPagerAdapter);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] items = {"INTERNATIONAL", "T20 LEAGUES", "DOMESTIC", "WOMEN"};

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Internatinal_TeamFragment internatinal_teamFragment = new Internatinal_TeamFragment();
                    return internatinal_teamFragment;
                case 1:
                    T20League_TeamFragment t20League_teamFragment = new T20League_TeamFragment();
                    return t20League_teamFragment;
                case 2:
                    Domestic_TeamFragment domestic_teamFragment = new Domestic_TeamFragment();
                    return domestic_teamFragment;
                case 3:
                    Women_TeamFragment women_teamFragment = new Women_TeamFragment();
                    return women_teamFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return items[position];
        }
    }
}