package com.example.cricbuzz.Fragment.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.LiveMatch_Adapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.matches;
import com.example.cricbuzz.Model.seriesMatches;
import com.example.cricbuzz.Model.typeMatches;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Featured_Fragment extends Fragment {

    RecyclerView recyclerView;
    ApiInterface apiInterface;
    LiveMatch_Adapter liveMatch_adapter;
    /*RecentMatch_Adapter recentMatch_adapter;
    UpcomingMatch_Adapter upcomingMatch_adapter;*/

    Handler handler = new Handler();
    Runnable runnable;
    /*typeMatches[] typeMatches1 = null;
    typeMatches[] typeMatches2 = null;
    typeMatches[] typeMatches3 = null;
    
    typeMatches[] typematchesall = null;*/

    List<seriesMatches> seriesMatchesAll ;
    List<matches> seriesAllMatches ;
   /*List<seriesMatches> seriesMatches1 = new ArrayList<>();
    List<seriesMatches> seriesMatches2 = new ArrayList<>();
    List<seriesMatches> seriesMatches3 = new ArrayList<>();*/

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

        seriesMatchesAll = new ArrayList<>();
        seriesAllMatches = new ArrayList<>();

        /*liveMatch_adapter = new LiveMatch_Adapter(getContext(), seriesMatchesAll);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(liveMatch_adapter);*/

        Live_ApiCall();


        return view;
    }

    private void Live_ApiCall(){
        apiInterface.getLive_Matches(MainActivity.apiKey).enqueue(new Callback<typeMatches>() {
            @Override
            public void onResponse(Call<typeMatches> call, Response<typeMatches> response) {
                if(response.isSuccessful()) {
                    if (response.body() != null) {

                        if(response.body().getTypeMatches() != null && response.body().getTypeMatches().length != 0){
                            for(int i=0;i<response.body().getTypeMatches().length;i++){
                                seriesMatchesAll.addAll(response.body().getTypeMatches()[i].getSeriesMatches());
                            }
                        }

                        Log.e("Fd" , "Sizzee 1 : " + seriesMatchesAll);

                        Recent_ApiCall();

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

                        if(response.body().getTypeMatches() != null && response.body().getTypeMatches().length != 0){
                            for(int i=0;i<response.body().getTypeMatches().length;i++){
                                seriesMatchesAll.addAll(response.body().getTypeMatches()[i].getSeriesMatches());
                            }
                        }

                        Log.e("Fd" , "Sizzee 2 : " + seriesMatchesAll);

                        Upcoming_ApiCall();

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

                        if(response.body().getTypeMatches() != null && response.body().getTypeMatches().length != 0){
                            for(int i=0;i<response.body().getTypeMatches().length;i++){
                                seriesMatchesAll.addAll(response.body().getTypeMatches()[i].getSeriesMatches());
                            }
                        }

                        Log.e("Fd" , "Sizzee 3 : " + seriesMatchesAll);

                        load_data();

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

    private void load_data(){

        seriesAllMatches.addAll(seriesMatchesAll.get(0).getSeriesAdWrapper().getMatches());

        if(seriesMatchesAll != null && !seriesMatchesAll.isEmpty()){

            liveMatch_adapter = new LiveMatch_Adapter(getContext(), seriesMatchesAll);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(liveMatch_adapter);

            /*liveMatch_adapter.Live_Score(seriesMatchesAll);*/
        }
        else{
            Log.e("Testinggg", "Else No Live Matches");
        }

    }
    /*@Override
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
    }*/
}