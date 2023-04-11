package com.example.cricbuzz.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.cricbuzz.MainActivity;
import com.example.cricbuzz.Model.typeMatches;
import com.example.cricbuzz.R;

public class LiveMatch_Adapter extends RecyclerView.Adapter<LiveMatch_Adapter.ViewHolder> {

    Context context;
    com.example.cricbuzz.Model.typeMatches[] typeMatches;

    public LiveMatch_Adapter(Context context, com.example.cricbuzz.Model.typeMatches[] typeMatches) {
        this.context = context;
        this.typeMatches = typeMatches;
    }

    @NonNull
    @Override
    public LiveMatch_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.live_match_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LiveMatch_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        typeMatches mydata = typeMatches[position];

        holder.txtMatchAndSeriesName.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getMatchDesc() + "-" + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getSeriesName());
        holder.txtTeam1Name.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam1().getTeamSName());
        holder.txtTeam2Name.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam2().getTeamSName());

        Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam1().getImageId() + "/i.jpg",
                new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam1);

        Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getTeam2().getImageId() + "/i.jpg",
                new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam2);

        if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore() != null) {

            //team1 score
            if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score() != null) {
                if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1() != null) {
                    if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2() != null) {

                        if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().isDeclared() == true) {
                            if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {

                                holder.txtTeam1Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getRuns() + " & " +
                                        mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getWickets() + " d");

                                holder.txtTeam1Score.setTextColor(Color.GRAY);
                                holder.txtTeam1Name.setTextColor(Color.GRAY);

                            }
                            else {
                                holder.txtTeam1Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getWickets() + " & " +
                                        mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getWickets() + " d");

                                holder.txtTeam1Score.setTextColor(Color.GRAY);
                                holder.txtTeam1Name.setTextColor(Color.GRAY);
                            }
                        } else {

                            if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getWickets() == 10) {
                                if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {
                                    holder.txtTeam1Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getRuns() + " & " +
                                            mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getRuns());

                                    holder.txtTeam1Score.setTextColor(Color.GRAY);
                                    holder.txtTeam1Name.setTextColor(Color.GRAY);
                                } else {
                                    holder.txtTeam1Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getWickets() + " & " +
                                            mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getRuns());

                                    holder.txtTeam1Score.setTextColor(Color.GRAY);
                                    holder.txtTeam1Name.setTextColor(Color.GRAY);
                                }
                            } else {
                                if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {
                                    holder.txtTeam1Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getRuns() + " & " +
                                            mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getWickets());

                                } else {
                                    holder.txtTeam1Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getWickets() + " & " +
                                            mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs2().getWickets());
                                }
                            }
                        }
                    }else {

                        if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().isDeclared() == true) {
                            holder.txtTeam1Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getWickets() + " d");

                            holder.txtTeam1Score.setTextColor(Color.GRAY);
                            holder.txtTeam1Name.setTextColor(Color.GRAY);
                        } else {
                            if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {
                                holder.txtTeam1Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getRuns() + " (" + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getOvers() + ")");

                                holder.txtTeam1Score.setTextColor(Color.GRAY);
                                holder.txtTeam1Name.setTextColor(Color.GRAY);
                            } else {
                                holder.txtTeam1Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getWickets() + " (" + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam1Score().getInngs1().getOvers() + ")");
                            }
                        }
                    }
                } else {
                    holder.txtTeam1Score.setText("");
                    holder.txtTeam1Name.setTextColor(Color.GRAY);

                }
            } else {
                holder.txtTeam1Score.setText("");
                holder.txtTeam1Name.setTextColor(Color.GRAY);

            }

            //team 2 scorecard

            if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score() != null) {
                if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1() != null) {
                    if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2() != null) {

                        if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().isDeclared() == true) {
                            if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {

                                holder.txtTeam2Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getRuns() + " & " +
                                        mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getWickets() + " d");

                                holder.txtTeam2Score.setTextColor(Color.GRAY);
                                holder.txtTeam2Name.setTextColor(Color.GRAY);
                            } else {
                                holder.txtTeam2Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getWickets() + " & " +
                                        mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getWickets() + " d");

                                holder.txtTeam2Score.setTextColor(Color.GRAY);
                                holder.txtTeam2Name.setTextColor(Color.GRAY);
                            }
                        } else {

                            if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getWickets() == 10) {
                                if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {
                                    holder.txtTeam2Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getRuns() + " & " +
                                            mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getRuns());

                                    holder.txtTeam2Score.setTextColor(Color.GRAY);
                                    holder.txtTeam2Name.setTextColor(Color.GRAY);
                                } else {
                                    holder.txtTeam2Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getWickets() + " & " +
                                            mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getRuns());

                                    holder.txtTeam2Score.setTextColor(Color.GRAY);
                                    holder.txtTeam2Name.setTextColor(Color.GRAY);
                                }
                            } else {
                                if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {
                                    holder.txtTeam2Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getRuns() + " & " +
                                            mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getWickets());

                                } else {
                                    holder.txtTeam2Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getWickets() + " & " +
                                            mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs2().getWickets());
                                }
                            }
                        }
                    } else {

                        if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().isDeclared() == true) {
                            holder.txtTeam2Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getWickets() + " d");

                            holder.txtTeam2Score.setTextColor(Color.GRAY);
                            holder.txtTeam2Name.setTextColor(Color.GRAY);
                        } else {
                            if (mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {
                                holder.txtTeam2Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getRuns() + " (" + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getOvers() + ")");

                                holder.txtTeam2Score.setTextColor(Color.GRAY);
                                holder.txtTeam2Name.setTextColor(Color.GRAY);
                            } else {
                                holder.txtTeam2Score.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getWickets() + " (" + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchScore().getTeam2Score().getInngs1().getOvers() + ")");
                            }
                        }
                    }
                } else {
                    holder.txtTeam2Score.setText("");
                    holder.txtTeam2Name.setTextColor(Color.GRAY);

                }
            } else {
                holder.txtTeam2Score.setText("");
                holder.txtTeam2Name.setTextColor(Color.GRAY);

            }
        }

        else{
            holder.txtTeam1Score.setText("");
            holder.txtTeam2Score.setText("");
        }

        //match status
        if(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getState().equalsIgnoreCase("Won")
                || mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getState().equalsIgnoreCase("Complete")){
            holder.txtMatchStatus.setTextColor(Color.BLUE);
        }
        holder.txtMatchStatus.setText(mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getStatus());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "POSITION :: " + position + "\nMYDATA ::: " + mydata.getSeriesMatches().get(0).getSeriesAdWrapper().getMatches().get(position).getMatchInfo().getSeriesName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return typeMatches.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMatchAndSeriesName, txtTeam1Name, txtTeam2Name, txtTeam1Score, txtTeam2Score, txtMatchStatus;
        ImageView imgTeam1, imgTeam2;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMatchAndSeriesName = itemView.findViewById(R.id.txtMatchAndSeriesName);
            txtTeam1Name = itemView.findViewById(R.id.txtTeam1Name);
            txtTeam2Name = itemView.findViewById(R.id.txtTeam2Name);
            txtTeam1Score = itemView.findViewById(R.id.txtTeam1Score);
            txtTeam2Score = itemView.findViewById(R.id.txtTeam2Score);
            txtMatchStatus = itemView.findViewById(R.id.txtMatchStatus);
            imgTeam1 = itemView.findViewById(R.id.imgTeam1);
            imgTeam2 = itemView.findViewById(R.id.imgTeam2);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
