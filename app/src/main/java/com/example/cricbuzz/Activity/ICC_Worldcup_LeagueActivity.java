package com.example.cricbuzz.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.Icc_Standing_Adapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.values;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ICC_Worldcup_LeagueActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    Icc_Standing_Adapter icc_standing_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icc_worldcup_league);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        recyclerView = findViewById(R.id.recyclerView);

        ApiCall();
    }

    public void ApiCall(){
        apiInterface.getOdiIccStanding(MainActivity.apiKey).enqueue(new Callback<values>() {
            @Override
            public void onResponse(Call<values> call, Response<values> response) {
                if(response.isSuccessful()){
                    values[] data = response.body().getValues();
                    icc_standing_adapter = new Icc_Standing_Adapter(ICC_Worldcup_LeagueActivity.this, data);
                    recyclerView.setLayoutManager(new LinearLayoutManager(ICC_Worldcup_LeagueActivity.this));
                    recyclerView.setAdapter(icc_standing_adapter);
                }
                else{
                    Toast.makeText(ICC_Worldcup_LeagueActivity.this, "Fail...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<values> call, Throwable t) {
                Toast.makeText(ICC_Worldcup_LeagueActivity.this, t.getLocalizedMessage() ,Toast.LENGTH_SHORT).show();
            }
        });
    }
}