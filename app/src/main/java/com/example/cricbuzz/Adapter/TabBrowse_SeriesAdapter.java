package com.example.cricbuzz.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cricbuzz.Fragment.BrowseSeries.Domestic_SeriesFragment;
import com.example.cricbuzz.Fragment.BrowseSeries.International_SeriesFragment;
import com.example.cricbuzz.Fragment.BrowseSeries.T20_SeriesFragment;
import com.example.cricbuzz.Fragment.BrowseSeries.Women_SeriesFragment;

public class TabBrowse_SeriesAdapter  extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public TabBrowse_SeriesAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                International_SeriesFragment internationalSeriesFragment = new International_SeriesFragment();
                return internationalSeriesFragment;
            case 1:
                T20_SeriesFragment t20SeriesFragment = new T20_SeriesFragment();
                return t20SeriesFragment;
            case 2:
                Domestic_SeriesFragment domesticSeriesFragment = new Domestic_SeriesFragment();
                return domesticSeriesFragment;
            case 3:
                Women_SeriesFragment womenSeriesFragment = new Women_SeriesFragment();
                return womenSeriesFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}