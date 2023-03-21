package com.example.cricbuzz.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.Fragment.ICC_Men.Men_AllRounderFragment;
import com.example.cricbuzz.Fragment.ICC_Men.Men_BatterFragment;
import com.example.cricbuzz.Fragment.ICC_Men.Men_BowlerFragment;
import com.example.cricbuzz.Fragment.ICC_Men.Men_TeamFragment;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;
import com.google.android.material.tabs.TabLayout;

public class ICC_MenActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icc_men);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(myPagerAdapter);


    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] items = {"BATSMEN", "BOWLER", "ALL ROUNDERS", "TEAMS"};
        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Men_BatterFragment menBatterFragment = new Men_BatterFragment();
                    return menBatterFragment;
                case 1:
                    Men_BowlerFragment menBowlerFragment = new Men_BowlerFragment();
                    return menBowlerFragment;
                case 2:
                    Men_AllRounderFragment menAllRounderFragment = new Men_AllRounderFragment();
                    return menAllRounderFragment;
                case 3:
                    Men_TeamFragment menTeamFragment = new Men_TeamFragment();
                    return menTeamFragment;
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