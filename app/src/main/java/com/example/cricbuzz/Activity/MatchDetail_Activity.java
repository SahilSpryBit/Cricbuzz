package com.example.cricbuzz.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cricbuzz.ApiInterface;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.MatchModel;
import com.example.cricbuzz.R;
import com.example.cricbuzz.RetrofitInstance;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchDetail_Activity extends AppCompatActivity {

    ApiInterface apiInterface;
    int match_id;
    TextView info_match, info_date, info_time, info_toss, info_series, info_venue, info_umpires, info_3rdumpire, info_referee, venue_stadium, venue_city, venue_capacity, venue_ends, venue_hosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        info_match = findViewById(R.id.info_match);
        info_date = findViewById(R.id.info_date);
        info_time = findViewById(R.id.info_time);
        info_toss = findViewById(R.id.info_toss);
        info_series = findViewById(R.id.info_series);
        info_venue = findViewById(R.id.info_venue);
        info_umpires = findViewById(R.id.info_umpires);
        info_3rdumpire = findViewById(R.id.info_3rdumpire);
        info_referee = findViewById(R.id.info_referee);
        venue_stadium = findViewById(R.id.venue_stadium);
        venue_city = findViewById(R.id.venue_city);
        venue_capacity = findViewById(R.id.venue_capacity);
        venue_ends = findViewById(R.id.venue_ends);
        venue_hosts = findViewById(R.id.venue_hosts);

        Bundle extras = getIntent().getExtras();
        match_id = extras.getInt("match_id", 0);

        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

        apiInterface.getMatchDetails(MainActivity.apiKey, match_id).enqueue(new Callback<MatchModel>() {
            @Override
            public void onResponse(Call<MatchModel> call, Response<MatchModel> response) {

                if(response.isSuccessful()){

                    if(response.body() != null){

                        Calendar calendar = Calendar.getInstance();
                        Calendar calendar2 = Calendar.getInstance();
                        calendar.setTimeInMillis(response.body().getMatchInfo().getMatchStartTimestamp());
                        calendar2.setTimeInMillis(response.body().getMatchInfo().getMatchCompleteTimestamp());
                        SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM ");
                        SimpleDateFormat formattertime = new SimpleDateFormat("h:mm a ");
                        String startdate = formatter.format(calendar.getTime());
                        String completedate = formatter.format(calendar2.getTime());
                        String starttime = formattertime.format(calendar.getTime());

                        Toast.makeText(MatchDetail_Activity.this, "Response Successs", Toast.LENGTH_SHORT).show();
                        info_match.setText(response.body().matchInfo.getMatchDescription());
                        info_date.setText(startdate +" - "+ completedate);
                        info_time.setText(starttime+", Your Time");
                        info_series.setText(response.body().getMatchInfo().getSeries().getName());
                        info_venue.setText(response.body().getMatchInfo().getVenue().getName());
                        info_umpires.setText(response.body().getMatchInfo().getUmpire1().getName()+", "+ response.body().getMatchInfo().getUmpire2().getName());
                        info_3rdumpire.setText(response.body().getMatchInfo().getUmpire3().getName());
                        info_referee.setText(response.body().getMatchInfo().getReferee().name);
                        venue_stadium.setText(response.body().getVenueInfo().getGround());
                        venue_city.setText(response.body().getVenueInfo().getCity());
                        venue_capacity.setText(response.body().getVenueInfo().getCapacity());
                        venue_ends.setText(response.body().getVenueInfo().getEnds());
                        venue_hosts.setText(response.body().getVenueInfo().getHomeTeam());

                        if(response.body().getMatchInfo().getTossResults().getDecision().equalsIgnoreCase("Batting")){
                            info_toss.setText(response.body().matchInfo.getTossResults().getTossWinnerName()+" opt to bat");
                        }else{
                            info_toss.setText(response.body().matchInfo.getTossResults().getTossWinnerName()+" opt to bowl");
                        }

                    }else {
                        Toast.makeText(MatchDetail_Activity.this, "Response Null", Toast.LENGTH_SHORT);
                    }
                }
            }

            @Override
            public void onFailure(Call<MatchModel> call, Throwable t) {
                Toast.makeText(MatchDetail_Activity.this, "Faill No Responsee "+ t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}