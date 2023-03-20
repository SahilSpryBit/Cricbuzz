package com.example.cricbuzz.Fragment.BrowseSeries;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.Browse_SeriesAdapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.seriesMapProto;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class International_SeriesFragment extends Fragment {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    Browse_SeriesAdapter browseSeriesAdapter;
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

        recyclerView = view.findViewById(R.id.recyclerView);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        ApiCall();

        return view;
    }

    private void ApiCall(){

        apiInterface.getBrowseSeries_International(MainActivity.apiKey).enqueue(new Callback<seriesMapProto>() {
            @Override
            public void onResponse(Call<seriesMapProto> call, Response<seriesMapProto> response) {

                if(response.isSuccessful()){
                    seriesMapProto[] seriesMapProtos = response.body().getSeriesMapProto();

                    browseSeriesAdapter = new Browse_SeriesAdapter(getContext(), seriesMapProtos);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(browseSeriesAdapter);

                }
                else{
                    Toast.makeText(getContext(), "Response Not Successs...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<seriesMapProto> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}