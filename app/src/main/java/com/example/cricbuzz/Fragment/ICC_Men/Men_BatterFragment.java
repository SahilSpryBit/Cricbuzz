package com.example.cricbuzz.Fragment.ICC_Men;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cricbuzz.Adapter.IccMensRanking_Batsmen_Adapter;
import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.MyDataClass;
import com.example.cricbuzz.Model.rank;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Men_BatterFragment extends Fragment {

    ApiInterface apiInterface;
    RecyclerView recyclerView;
    TextView txtTest, txtOdi, txtT20;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_men__batter, container, false);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = view.findViewById(R.id.recyclerView_batsmen);
        txtTest = view.findViewById(R.id.txtTest_batsmen);
        txtOdi = view.findViewById(R.id.txtOdi_batsmen);
        txtT20 = view.findViewById(R.id.txtT20_batsmen);

        ApiCall("test");

        txtTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtTest.setBackgroundColor(getContext().getResources().getColor(R.color.app_color));
                txtTest.setTextColor(getContext().getResources().getColor(R.color.white));

                txtOdi.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtT20.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtOdi.setTextColor(getContext().getResources().getColor(R.color.app_color));
                txtT20.setTextColor(getContext().getResources().getColor(R.color.app_color));

                ApiCall("test");

            }
        });

        txtOdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtOdi.setBackgroundColor(getContext().getResources().getColor(R.color.app_color));
                txtOdi.setTextColor(getContext().getResources().getColor(R.color.white));

                txtTest.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtT20.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtTest.setTextColor(getContext().getResources().getColor(R.color.app_color));
                txtT20.setTextColor(getContext().getResources().getColor(R.color.app_color));


                ApiCall("odi");

            }
        });

        txtT20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtT20.setBackgroundColor(getContext().getResources().getColor(R.color.app_color));
                txtT20.setTextColor(getContext().getResources().getColor(R.color.white));

                txtOdi.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtTest.setBackground(getContext().getDrawable(R.drawable.border_button));
                txtOdi.setTextColor(getContext().getResources().getColor(R.color.app_color));
                txtTest.setTextColor(getContext().getResources().getColor(R.color.app_color));

                ApiCall("t20");

            }
        });

        return view;
    }

    private void ApiCall(String type){

        apiInterface.getIccRankingMens_Batsmen(MainActivity.apiKey, "cricbuzz-cricket.p.rapidapi.com", type).enqueue(new Callback<MyDataClass>() {
            @Override
            public void onResponse(Call<MyDataClass> call, Response<MyDataClass> response) {

                if(response.isSuccessful()){

                    List<rank> ranks = response.body().getRank();

                    IccMensRanking_Batsmen_Adapter iccMensRankingBatsmenAdapter = new IccMensRanking_Batsmen_Adapter(getContext(), ranks);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(iccMensRankingBatsmenAdapter);

                    Log.d("Testinggg", "SUccesssss");

                } else{
                    Toast.makeText(getContext(), "Fail...", Toast.LENGTH_SHORT).show();
                    Log.d("Testinggg", "Error ELSEEEE");
                }
            }

            @Override
            public void onFailure(Call<MyDataClass> call, Throwable t) {
                Log.d("Testinggg", "Error "+t.getLocalizedMessage());
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}