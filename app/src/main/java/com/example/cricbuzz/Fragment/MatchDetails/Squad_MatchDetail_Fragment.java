package com.example.cricbuzz.Fragment.MatchDetails;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.cricbuzz.Adapter.MatchDetail_SquadAdapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.Fragment.playerDetails;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.MatchModel;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Squad_MatchDetail_Fragment extends Fragment {

    RecyclerView team1recycler, team2recycler, team1_bench, team2_bench ;
    TextView team1name, team2name;
    ImageView team1flag, team2flag;
    ApiInterface apiInterface;
    int match_id, team1flagid, team2flagid;
    MatchDetail_SquadAdapter matchDetail_squadAdapter, matchDetail_squadAdapter2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_squad__match_detail_, container, false);

        team1name = view.findViewById(R.id.team1name);
        team2name = view.findViewById(R.id.team2name);
        team1flag = view.findViewById(R.id.team1flag);
        team2flag = view.findViewById(R.id.team2flag);
        team1recycler = view.findViewById(R.id.team1recycler);
        team2recycler = view.findViewById(R.id.team2recycler);
        team1_bench = view.findViewById(R.id.team1_benchrecycler);
        team2_bench = view.findViewById(R.id.team2_benchrecycler);

        Bundle extras = getActivity().getIntent().getExtras();
        match_id = extras.getInt("match_id", 0);
        team1flagid = extras.getInt("team1flag", 0);
        team2flagid = extras.getInt("team2flag", 0);

        Glide.with(this).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + team1flagid + "/i.jpg",
                new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(team1flag);

        Glide.with(this).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + team2flagid + "/i.jpg",
                new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(team2flag);


        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        ApiCall();

        return view;
    }

    private void ApiCall(){

        apiInterface.getMatchDetails(MainActivity.apiKey, match_id).enqueue(new Callback<MatchModel>() {
            @Override
            public void onResponse(Call<MatchModel> call, Response<MatchModel> response) {

                if (response.isSuccessful()){

                    if(response.body() != null){

                        List<playerDetails> datateam1 = response.body().getMatchInfo().getTeam1().getPlayerDetails();
                        List<playerDetails> datateam2 = response.body().getMatchInfo().getTeam2().getPlayerDetails();

                        team1name.setText(response.body().getMatchInfo().getTeam1().getShortName());
                        team2name.setText(response.body().getMatchInfo().getTeam2().getShortName());

                        for(int i = 0; i < datateam1.size(); i++){
                            if(!response.body().getMatchInfo().getTeam1().getPlayerDetails().get(i).isSubstitute()){

                                matchDetail_squadAdapter = new MatchDetail_SquadAdapter(getContext(), datateam1);
                                team1_bench.setLayoutManager(new LinearLayoutManager(getContext()));
                                team1_bench.setAdapter(matchDetail_squadAdapter);
                            }else{
                                matchDetail_squadAdapter = new MatchDetail_SquadAdapter(getContext(), datateam1);
                                team1recycler.setLayoutManager(new LinearLayoutManager(getContext()));
                                team1recycler.setAdapter(matchDetail_squadAdapter);
                            }
                        }

                        for(int i = 0; i < datateam2.size(); i++){
                            if(!response.body().getMatchInfo().getTeam2().getPlayerDetails().get(i).isSubstitute()){

                                matchDetail_squadAdapter = new MatchDetail_SquadAdapter(getContext(), datateam2);
                                team2_bench.setLayoutManager(new LinearLayoutManager(getContext()));
                                team2_bench.setAdapter(matchDetail_squadAdapter);
                            }
                            else{
                                matchDetail_squadAdapter2 = new MatchDetail_SquadAdapter(getContext(), datateam2);
                                team2recycler.setLayoutManager(new LinearLayoutManager(getContext()));
                                team2recycler.setAdapter(matchDetail_squadAdapter2);
                            }
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<MatchModel> call, Throwable t) {
                Toast.makeText(getContext(), "Fail no responsee..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}