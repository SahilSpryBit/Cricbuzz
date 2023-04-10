package com.example.cricbuzz.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.News_Adapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.Root;
import com.example.cricbuzz.Model.story;
import com.example.cricbuzz.Model.storyList;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsFragment extends Fragment {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    News_Adapter newsAdapter;

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

        ApiCall();

        return view;
    }

    private void ApiCall() {

        apiInterface.getNews(MainActivity.apiKey).enqueue(new Callback<storyList>() {
            @Override
            public void onResponse(Call<storyList> call, Response<storyList> response) {

                if (response.isSuccessful()) {

                    storyList[] storyList = response.body().getStoryList();

                    Toast.makeText(getContext(), "Suceessssss", Toast.LENGTH_SHORT).show();
                    Log.d("Testinggg", "Model Size : " + storyList.length + " , Model : " + storyList);
                    newsAdapter = new News_Adapter(getContext(), storyList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(newsAdapter);
                } else {
                    Toast.makeText(getContext(), "Response Not Success..", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<storyList> call, Throwable t) {
                Toast.makeText(getContext(), "Response Failll.." + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Testinggg", t.getLocalizedMessage().toString());
            }

        });

    }
}