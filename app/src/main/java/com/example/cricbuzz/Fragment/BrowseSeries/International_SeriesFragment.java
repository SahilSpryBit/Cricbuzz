package com.example.cricbuzz.Fragment.BrowseSeries;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cricbuzz.R;

public class International_SeriesFragment extends Fragment {
    public International_SeriesFragment() {
    }

    public static International_SeriesFragment newInstance() {
        International_SeriesFragment fragment = new International_SeriesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_international__series, container, false);

        return view;
    }
}