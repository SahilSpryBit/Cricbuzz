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
import com.example.cricbuzz.Fragment.ICC_Women.Women_AllRounderFragment;
import com.example.cricbuzz.Fragment.ICC_Women.Women_BatterFragment;
import com.example.cricbuzz.Fragment.ICC_Women.Women_BowlerFragment;
import com.example.cricbuzz.Fragment.ICC_Women.Women_ICC_TeamFragment;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;
import com.google.android.material.tabs.TabLayout;

public class ICC_WomenActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icc_women);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        tabLayout = findViewById(R.id.tabLayout_women);
        viewPager = findViewById(R.id.viewPager_women);

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
                    Women_BatterFragment WomenBatterFragment = new Women_BatterFragment();
                    return WomenBatterFragment;
                case 1:
                    Women_BowlerFragment WomenBowlerFragment = new Women_BowlerFragment();
                    return WomenBowlerFragment;
                case 2:
                    Women_AllRounderFragment womenAllRounderFragment = new Women_AllRounderFragment();
                    return womenAllRounderFragment;
                case 3:
                    Women_ICC_TeamFragment womenIccTeamFragment= new Women_ICC_TeamFragment();
                    return womenIccTeamFragment;
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