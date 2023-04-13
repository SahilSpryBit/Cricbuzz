package com.example.cricbuzz.Fragment.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.LiveMatch_Adapter;
import com.example.cricbuzz.Adapter.RecentMatch_Adapter;
import com.example.cricbuzz.Adapter.Recent_League_Matches_Adapter;
import com.example.cricbuzz.Adapter.UpcomingMatch_Adapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.matches;
import com.example.cricbuzz.Model.typeMatches;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Featured_Fragment extends Fragment {

    RecyclerView recyclerView;
    ApiInterface apiInterface;
    LiveMatch_Adapter liveMatch_adapter;
    RecentMatch_Adapter recentMatch_adapter;
    UpcomingMatch_Adapter upcomingMatch_adapter;

    Handler handler = new Handler();
    Runnable runnable;
    typeMatches[] typeMatches = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_featured_, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        liveMatch_adapter = new LiveMatch_Adapter(getContext(), typeMatches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(liveMatch_adapter);

        Live_ApiCall();
        //Recent_ApiCall();
        //Upcoming_ApiCall();

        return view;
    }

    private void Live_ApiCall(){

        apiInterface.getLive_Matches(MainActivity.apiKey).enqueue(new Callback<typeMatches>() {
            @Override
            public void onResponse(Call<typeMatches> call, Response<typeMatches> response) {
                if(response.isSuccessful()) {
                    if (response.body() != null) {
                        typeMatches[] typeMatches = response.body().getTypeMatches();

                        Toast.makeText(getContext(), "Live Match : "+ typeMatches.length, Toast.LENGTH_SHORT).show();

                        liveMatch_adapter.LiveData(typeMatches);
                    }
                    else{
                        Toast.makeText(getContext(), "Response Null..", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getContext(), "Response Not Success..", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<typeMatches> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Recent_ApiCall(){

        apiInterface.getMatches_recent(MainActivity.apiKey).enqueue(new Callback<typeMatches>() {
            @Override
            public void onResponse(Call<typeMatches> call, Response<typeMatches> response) {
                if(response.isSuccessful()) {
                    if (response.body() != null) {
                        typeMatches[] typeMatches = response.body().getTypeMatches();

                        Toast.makeText(getContext(), "Recent Match : "+ typeMatches.length, Toast.LENGTH_SHORT).show();

                        recentMatch_adapter = new RecentMatch_Adapter(getContext(), typeMatches);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                        recyclerView.setAdapter(recentMatch_adapter);
                    }
                    else{
                        Toast.makeText(getContext(), "Response Null..", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getContext(), "Response Not Success..", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<typeMatches> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Upcoming_ApiCall(){

        apiInterface.getMatches_upcoming(MainActivity.apiKey).enqueue(new Callback<typeMatches>() {
            @Override
            public void onResponse(Call<typeMatches> call, Response<typeMatches> response) {
                if(response.isSuccessful()) {
                    if (response.body() != null) {
                        typeMatches[] typeMatches = response.body().getTypeMatches();

                        Toast.makeText(getContext(), " Upcoming Match : "+ typeMatches.length, Toast.LENGTH_SHORT).show();

                        upcomingMatch_adapter = new UpcomingMatch_Adapter(getContext(), typeMatches);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                        recyclerView.setAdapter(upcomingMatch_adapter);
                    }
                    else{
                        Toast.makeText(getContext(), "Response Null..", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getContext(), "Response Not Success..", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<typeMatches> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, 5000);
                Live_ApiCall();
            }
        }, 5000);
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}