package com.example.cricbuzz.Fragment.ICC_Women;

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

import com.example.cricbuzz.Adapter.IccMensRanking_Bowler_Adapter;
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

public class Women_BowlerFragment extends Fragment {

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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_women__bowler, container, false);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        recyclerView = view.findViewById(R.id.recyclerView_bowler_W);
        txtTest = view.findViewById(R.id.txtTest_bowler_W);
        txtOdi = view.findViewById(R.id.txtOdi_bowler_W);
        txtT20 = view.findViewById(R.id.txtT20_bowler_W);

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

        apiInterface.getIccRankingWomens_Bowler(MainActivity.apiKey, "cricbuzz-cricket.p.rapidapi.com", type, "1").enqueue(new Callback<MyDataClass>() {
            @Override
            public void onResponse(Call<MyDataClass> call, Response<MyDataClass> response) {

                if(response.isSuccessful()){
                    
                    if(response.body() != null){
                        List<rank> ranks = response.body().getRank();

                        IccMensRanking_Bowler_Adapter iccMensRankingBowlerAdapter = new IccMensRanking_Bowler_Adapter(getContext(), ranks);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(iccMensRankingBowlerAdapter);

                        Log.d("Testinggg", "SUccesssss");

                    }else{
                        Toast.makeText(getContext(), "No Data Available!!", Toast.LENGTH_SHORT).show();
                    }
                }

                    else{
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