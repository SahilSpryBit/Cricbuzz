package com.example.cricbuzz.Fragment.Matches;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.Live_Domestic_Matches_Adapter;
import com.example.cricbuzz.Adapter.Live_International_Matches_Adapter;
import com.example.cricbuzz.Adapter.Live_League_Matches_Adapter;
import com.example.cricbuzz.Adapter.Live_Women_Matches_Adapter;
import com.example.cricbuzz.Adapter.Recent_Domestic_Matches_Adapter;
import com.example.cricbuzz.Adapter.Recent_International_Matches_Adapter;
import com.example.cricbuzz.Adapter.Recent_League_Matches_Adapter;
import com.example.cricbuzz.Adapter.Recent_Women_Matches_Adapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.typeMatches;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecentFragment extends Fragment {

    ApiInterface apiInterface;
    Recent_International_Matches_Adapter recent_international_matches_adapter;
    Recent_League_Matches_Adapter recent_league_matches_adapter;
    Recent_Domestic_Matches_Adapter recent_domestic_matches_adapter;
    Recent_Women_Matches_Adapter recent_women_matches_adapter;
    RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4;
    TextView txtMatchType1, txtMatchType2, txtMatchType3, txtMatchType4;
    LinearLayout linearInternational, linearLeague, linearDomestic, linearWomen;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recent, container, false);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView1 = view.findViewById(R.id.recyclerView11);
        recyclerView2 = view.findViewById(R.id.recyclerView22);
        recyclerView3 = view.findViewById(R.id.recyclerView33);
        recyclerView4 = view.findViewById(R.id.recyclerView44);

        txtMatchType1 = view.findViewById(R.id.txtMatchType1);
        txtMatchType2 = view.findViewById(R.id.txtMatchType2);
        txtMatchType3 = view.findViewById(R.id.txtMatchType3);
        txtMatchType4 = view.findViewById(R.id.txtMatchType4);

        linearInternational = view.findViewById(R.id.linearInternational);
        linearLeague = view.findViewById(R.id.linearLeague);
        linearDomestic = view.findViewById(R.id.linearDomestic);
        linearWomen = view.findViewById(R.id.linearWomen);

        ApiCall();

        return view;
    }

    private void ApiCall(){

        apiInterface.getMatches_recent(MainActivity.apiKey).enqueue(new Callback<typeMatches>() {
            @Override
            public void onResponse(Call<typeMatches> call, Response<typeMatches> response) {

                if(response.isSuccessful()){
                    typeMatches[] typeMatches = response.body().getTypeMatches();

                    /*for(int i=0; i<typeMatches.length; i++) {*/
                        if(typeMatches[0].getMatchType().equals("International")) {
                            Toast.makeText(getContext(), "My Data 0 : "+ typeMatches[0].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(), Toast.LENGTH_SHORT).show();
                            for(int j = 0; j < typeMatches[0].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(); j++) {
                                linearInternational.setVisibility(View.VISIBLE);
                                txtMatchType1.setText(typeMatches[0].getMatchType().toUpperCase());

                                recent_international_matches_adapter = new Recent_International_Matches_Adapter(getContext(), typeMatches);
                                recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
                                recyclerView1.setAdapter(recent_international_matches_adapter);
                            }
                        }

                        if(typeMatches[1].getMatchType().equals("League")) {
                            Toast.makeText(getContext(), "My Data 1 : "+ typeMatches[1].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(), Toast.LENGTH_SHORT).show();
                            for (int j = 0; j < typeMatches[1].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(); j++) {
                                linearLeague.setVisibility(View.VISIBLE);
                                txtMatchType2.setText(typeMatches[1].getMatchType().toUpperCase());

                                recent_league_matches_adapter = new Recent_League_Matches_Adapter(getContext(), typeMatches);
                                recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
                                recyclerView2.setAdapter(recent_league_matches_adapter);
                            }
                        }

                        if(typeMatches[2].getMatchType().equals("Domestic")) {
                            Toast.makeText(getContext(), "My Data 2 : "+ typeMatches[2].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(), Toast.LENGTH_SHORT).show();
                            for (int j = 0; j < typeMatches[2].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(); j++) {
                                linearDomestic.setVisibility(View.VISIBLE);
                                txtMatchType3.setText(typeMatches[2].getMatchType().toUpperCase());

                                recent_domestic_matches_adapter = new Recent_Domestic_Matches_Adapter(getContext(), typeMatches);
                                recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
                                recyclerView3.setAdapter(recent_domestic_matches_adapter);
                                /*live_domestic_matches_adapter.Live_Domestic_Matches_Adapter123(typeMatches);*/
                            }
                        }

                        if(typeMatches[3].getMatchType().equals("Women")) {
                            Toast.makeText(getContext(), "My Data 3 : "+ typeMatches[3].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(), Toast.LENGTH_SHORT).show();
                            for (int j = 0; j < typeMatches[3].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(); j++) {
                                linearWomen.setVisibility(View.VISIBLE);
                                txtMatchType4.setText(typeMatches[3].getMatchType().toUpperCase());

                                recent_women_matches_adapter = new Recent_Women_Matches_Adapter(getContext(), typeMatches);
                                recyclerView4.setLayoutManager(new LinearLayoutManager(getContext()));
                                recyclerView4.setAdapter(recent_women_matches_adapter);
                            }
                        }
                    /*}*/
                }else{

                    Toast.makeText(getContext(), "Faill Response not successs", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<typeMatches> call, Throwable t) {
                Toast.makeText(getContext(), "Faill :: "+ t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}