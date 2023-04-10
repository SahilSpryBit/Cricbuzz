package com.example.cricbuzz.Fragment.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.LiveMatch_Adapter;
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

        ApiCall();

        return view;
    }

    private void ApiCall(){

        apiInterface.getMatches_recent(MainActivity.apiKey).enqueue(new Callback<typeMatches>() {
            @Override
            public void onResponse(Call<typeMatches> call, Response<typeMatches> response) {
                if(response.isSuccessful()){
                    typeMatches[] typeMatches = response.body().getTypeMatches();

                    liveMatch_adapter = new LiveMatch_Adapter(getContext(), typeMatches);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    recyclerView.setAdapter(liveMatch_adapter);
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
}