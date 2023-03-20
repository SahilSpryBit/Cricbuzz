package com.example.cricbuzz.Fragment.BrowseTeams;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.Browse_TeamAdapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.list;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Domestic_TeamFragment extends Fragment {

    RecyclerView recyclerView;
    Browse_TeamAdapter browseTeamAdapter;
    ApiInterface apiInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_domestic__team, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        ApiCall();

        return view;
    }

    private void ApiCall(){

        apiInterface.getBrowseTeams_Domestic(MainActivity.apiKey).enqueue(new Callback<list>() {
            @Override
            public void onResponse(Call<list> call, Response<list> response) {

                if(response.isSuccessful()){

                    list[] list = response.body().getList();

                    browseTeamAdapter = new Browse_TeamAdapter(getContext(), list);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(browseTeamAdapter);
                }else{
                    Toast.makeText(getContext(), "Response Not SUccess...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<list> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}