package com.example.cricbuzz.Activity;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.Browse_PlayersAdapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.player;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Browse_Player_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ApiInterface apiInterface;
    ImageView imgBack;
    TextView txtTrending;
    Browse_PlayersAdapter browsePlayersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_player);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        recyclerView = findViewById(R.id.recyclerView);
        imgBack = findViewById(R.id.imgBack);
        txtTrending = findViewById(R.id.txtTrending);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ApiCall();
    }

    private void ApiCall(){

        apiInterface.getBrowsePlayers_Trending(MainActivity.apiKey).enqueue(new Callback<player>() {
            @Override
            public void onResponse(Call<player> call, Response<player> response) {
                if(response.isSuccessful()){
                    player[] player = response.body().getPlayers();
                    txtTrending.setText(response.body().getCategory());
                    browsePlayersAdapter = new Browse_PlayersAdapter(Browse_Player_Activity.this, player);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Browse_Player_Activity.this));
                    recyclerView.setAdapter(browsePlayersAdapter);
                }
                else{
                    Toast.makeText(Browse_Player_Activity.this, "Fail...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<player> call, Throwable t) {
                Toast.makeText(Browse_Player_Activity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}