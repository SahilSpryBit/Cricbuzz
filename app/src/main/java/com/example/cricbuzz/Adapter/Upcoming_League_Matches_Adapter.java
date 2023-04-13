package com.example.cricbuzz.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.typeMatches;
import com.example.cricbuzz.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Upcoming_League_Matches_Adapter extends RecyclerView.Adapter<Upcoming_League_Matches_Adapter.ViewHolder> {

    Context context;
    com.example.cricbuzz.Model.typeMatches[] typeMatches;
    int newData;

    public Upcoming_League_Matches_Adapter(Context context, com.example.cricbuzz.Model.typeMatches[] typeMatches) {
        this.context = context;
        this.typeMatches = typeMatches;
    }

    @NonNull
    @Override
    public Upcoming_League_Matches_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.live_all_formate_matches_layout, parent, false);
        return new Upcoming_League_Matches_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Upcoming_League_Matches_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        com.example.cricbuzz.Model.typeMatches mydata = typeMatches[1];

        if (mydata.getMatchType().equals("League")) {

            if (mydata.getSeriesMatches().get(0).getAdDetail() != null) {

                Log.d("Testinggg", "AD DETAILL1");
                holder.main_view.setVisibility(View.GONE);
                if (mydata.getSeriesMatches().get(0).getAdDetail().getPosition() == position) {
                    Log.d("Testinggg", "Ad Detailll");
                    holder.main_view.setVisibility(View.GONE);
                }
                else {

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(Long.parseLong(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getStartDate()));
                    SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM h:mm a");
                    String formattedDate = formatter.format(calendar.getTime());

                    holder.txtMatchAndVenueName.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getMatchDesc() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getVenueInfo().getCity());
                    holder.txtTeam1Name.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam1().getTeamSName());
                    holder.txtTeam2Name.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam2().getTeamSName());

                    holder.txtTeam1Score.setText("");
                    holder.txtTeam2Score.setText("");

                    Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c"+mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam1().getImageId()+"/i.jpg",
                            new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam1);

                    Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c"+mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam2().getImageId()+"/i.jpg",
                            new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam2);

                    holder.txtMatchStatus.setText(formattedDate);
                }
            }
            else {

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.parseLong(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getStartDate()));
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM h:mm a");
                String formattedDate = formatter.format(calendar.getTime());

                holder.txtMatchAndVenueName.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getMatchDesc() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getVenueInfo().getCity());
                holder.txtTeam1Name.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam1().getTeamSName());
                holder.txtTeam2Name.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam2().getTeamSName());

                holder.txtTeam1Score.setText("");
                holder.txtTeam2Score.setText("");

                Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c"+mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam1().getImageId()+"/i.jpg",
                        new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam1);

                Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c"+mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam2().getImageId()+"/i.jpg",
                        new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam2);

                holder.txtMatchStatus.setText(formattedDate);
            }
        }
    }

    @Override
    public int getItemCount() {
        return typeMatches[1].getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMatchAndVenueName, txtTeam1Name, txtTeam2Name, txtTeam1Score, txtTeam2Score, txtMatchStatus;
        ImageView imgTeam1, imgTeam2;
        LinearLayout main_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtMatchAndVenueName = itemView.findViewById(R.id.txtMatchAndVenueName);
            txtTeam1Name = itemView.findViewById(R.id.txtTeam1Name);
            txtTeam2Name = itemView.findViewById(R.id.txtTeam2Name);
            txtTeam1Score = itemView.findViewById(R.id.txtTeam1Score);
            txtTeam2Score = itemView.findViewById(R.id.txtTeam2Score);
            txtMatchStatus = itemView.findViewById(R.id.txtMatchStatus);
            imgTeam1 = itemView.findViewById(R.id.imgTeam1);
            imgTeam2 = itemView.findViewById(R.id.imgTeam2);
            main_view = itemView.findViewById(R.id.main_view);
        }
    }
}
