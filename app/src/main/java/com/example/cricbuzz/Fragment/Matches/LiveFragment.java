package com.example.cricbuzz.Fragment.Matches;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
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
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.typeMatches;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveFragment extends Fragment {

    ApiInterface apiInterface;
    Live_International_Matches_Adapter live_international_matches_adapter;
    Live_League_Matches_Adapter live_league_matches_adapter;
    Live_Domestic_Matches_Adapter live_domestic_matches_adapter;
    Live_Women_Matches_Adapter live_women_matches_adapter;
    RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4;
    TextView txtMatchType1, txtMatchType2, txtMatchType3, txtMatchType4;
    LinearLayout linearInternational, linearLeague, linearDomestic, linearWomen;

    typeMatches[] typeMatches = null;

    Handler handler = new Handler();
    Runnable runnable;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live, container, false);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView1 = view.findViewById(R.id.recyclerView1);
        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView3 = view.findViewById(R.id.recyclerView3);
        recyclerView4 = view.findViewById(R.id.recyclerView4);

        txtMatchType1 = view.findViewById(R.id.txtMatchType1);
        txtMatchType2 = view.findViewById(R.id.txtMatchType2);
        txtMatchType3 = view.findViewById(R.id.txtMatchType3);
        txtMatchType4 = view.findViewById(R.id.txtMatchType4);

        linearInternational = view.findViewById(R.id.linearInternational);
        linearLeague = view.findViewById(R.id.linearLeague);
        linearDomestic = view.findViewById(R.id.linearDomestic);
        linearWomen = view.findViewById(R.id.linearWomen);

        live_international_matches_adapter = new Live_International_Matches_Adapter(getContext(), typeMatches);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView1.setAdapter(live_international_matches_adapter);

        live_league_matches_adapter = new Live_League_Matches_Adapter(getContext(), typeMatches);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.setAdapter(live_league_matches_adapter);

        live_domestic_matches_adapter = new Live_Domestic_Matches_Adapter(getContext(), typeMatches);
        recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView3.setAdapter(live_domestic_matches_adapter);

        live_women_matches_adapter = new Live_Women_Matches_Adapter(getContext(), typeMatches);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView4.setAdapter(live_women_matches_adapter);


        //ApiCall();

        return view;
    }

    /*@Override
    public void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, 5000);
                ApiCall();
            }
        }, 5000);
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }*/

    private void ApiCall() {


        apiInterface.getLive_Matches(MainActivity.apiKey).enqueue(new Callback<typeMatches>() {
            @Override
            public void onResponse(Call<typeMatches> call, Response<typeMatches> response) {

                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        typeMatches = response.body().getTypeMatches();

                        /*for(int i=0; i<typeMatches.length; i++) {*/
                        if (typeMatches[0].getMatchType().equals("International")) {
                            for (int j = 0; j < typeMatches[0].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(); j++) {
                                linearInternational.setVisibility(View.VISIBLE);
                                txtMatchType1.setText(typeMatches[0].getMatchType().toUpperCase());

                                live_international_matches_adapter.Live_International_Matches_Adapter_Notify(typeMatches);
                            }
                        }

                        if (typeMatches[1].getMatchType().equals("League")) {
                            for (int j = 0; j < typeMatches[1].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(); j++) {
                                linearLeague.setVisibility(View.VISIBLE);
                                txtMatchType2.setText(typeMatches[1].getMatchType().toUpperCase());

                                live_league_matches_adapter.Live_League_Matches_Adapter_Notify(typeMatches);
                            }
                        }

                        if (typeMatches[2].getMatchType().equals("Domestic")) {
                            for (int j = 0; j < typeMatches[2].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(); j++) {
                                linearDomestic.setVisibility(View.VISIBLE);
                                txtMatchType3.setText(typeMatches[2].getMatchType().toUpperCase());

                                live_domestic_matches_adapter.Live_Domestic_Matches_Adapter_Notify(typeMatches);
                            }
                        }

                        if (typeMatches[3].getMatchType().equals("Women")) {
                            for (int j = 0; j < typeMatches[3].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size(); j++) {
                                linearWomen.setVisibility(View.VISIBLE);
                                txtMatchType4.setText(typeMatches[3].getMatchType().toUpperCase());

                                live_women_matches_adapter.Live_Women_Matches_Adapter_Notify(typeMatches);
                            }
                        }
                        /*}*/
                    } else {

                        Toast.makeText(getContext(), "Faill Response Nulll", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getContext(), "Faill Response not successs", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<typeMatches> call, Throwable t) {
                Toast.makeText(getContext(), "Faill :: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}