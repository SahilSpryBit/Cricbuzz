package com.example.cricbuzz.Fragment.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cricbuzz.Adapter.LiveMatch_Adapter;
import com.example.cricbuzz.Model.typeMatches;
import com.example.cricbuzz.R;

public class CricbuzzPlus_Fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cricbuzz_plus_, container, false);

        return view;
    }
}