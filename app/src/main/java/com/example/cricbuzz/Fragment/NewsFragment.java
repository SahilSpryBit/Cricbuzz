package com.example.cricbuzz.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;


public class NewsFragment extends Fragment {

    ApiInterface apiInterface;
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = view.findViewById(R.id.news_recycler);

        return view;
    }

    private void ApiCall(){


    }
}