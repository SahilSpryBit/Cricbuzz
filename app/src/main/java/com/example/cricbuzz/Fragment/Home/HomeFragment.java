package com.example.cricbuzz.Fragment.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cricbuzz.Activity.Browse_Team_Activity;
import com.example.cricbuzz.R;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    TabLayout tab_layout;
    ViewPager view_pager;
    /*FeaturedFragment featuredFragment;
    PlusFragment plusFragment;*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tab_layout = view.findViewById(R.id.tab_layout);
        view_pager = view.findViewById(R.id.view_pager);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getChildFragmentManager());

        tab_layout.setupWithViewPager(view_pager);
        view_pager.setAdapter(myPagerAdapter);


        return view;
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        String[] itemNames = {"FEATURED", "CRICKBUZZ PLUS"};

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Featured_Fragment featuredFragment = new Featured_Fragment();
                    return featuredFragment;
                case 1:
                    CricbuzzPlus_Fragment cricbuzzPlusFragment = new CricbuzzPlus_Fragment();
                    return cricbuzzPlusFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return itemNames.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return itemNames[position];
        }
    }
}