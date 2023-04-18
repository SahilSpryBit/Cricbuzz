package com.example.cricbuzz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.cricbuzz.Adapter.LiveMatch_Adapter;
import com.example.cricbuzz.Model.matches;
import com.example.cricbuzz.Model.seriesMatches;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {

    Context context;
    List<com.example.cricbuzz.Model.seriesMatches> seriesMatches ;

    public DemoAdapter(Context context, List<com.example.cricbuzz.Model.seriesMatches> seriesMatches) {
        this.context = context;
        this.seriesMatches = seriesMatches;
    }

    @NonNull
    @Override
    public DemoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.live_match_layout, parent, false);
        return new DemoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        /*typeMatches mydata = typeMatches[0];*/

        /*matches mydata = matches.get(position);*/

        seriesMatches mydata = seriesMatches.get(position);

        if (mydata.getAdDetail() != null) {

            Log.d("Testinggg", "AD DETAILL1");
            holder.main_view.setVisibility(View.GONE);
            if (mydata.getAdDetail().getPosition() == 1) {
                Log.d("Testinggg", "Ad Detailll");
                holder.main_view.setVisibility(View.GONE);
            }
            else {

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.parseLong(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getStartDate()));
                SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM h:mm a");
                String formattedDate = formatter.format(calendar.getTime());

                holder.txtMatchAndSeriesName.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getMatchDesc() + "-" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getSeriesName());
                holder.txtTeam1Name.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getTeam1().getTeamSName());
                holder.txtTeam2Name.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getTeam2().getTeamSName());

                Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getTeam1().getImageId() + "/i.jpg",
                        new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam1);

                Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getTeam2().getImageId() + "/i.jpg",
                        new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam2);

                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore() != null) {

                    //team1 score
                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score() != null) {
                        if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1() != null) {
                            if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2() != null) {

                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().isDeclared() == true) {
                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {

                                        holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets() + " d");

                                        holder.txtTeam1Score.setTextColor(Color.GRAY);
                                        holder.txtTeam1Name.setTextColor(Color.GRAY);

                                    }
                                    else {
                                        holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets() + " d");

                                        holder.txtTeam1Score.setTextColor(Color.GRAY);
                                        holder.txtTeam1Name.setTextColor(Color.GRAY);
                                    }
                                } else {

                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets() == 10) {
                                        if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {
                                            holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " & " +
                                                    mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns());

                                            holder.txtTeam1Score.setTextColor(Color.GRAY);
                                            holder.txtTeam1Name.setTextColor(Color.GRAY);
                                        } else {
                                            holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " & " +
                                                    mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns());

                                            holder.txtTeam1Score.setTextColor(Color.GRAY);
                                            holder.txtTeam1Name.setTextColor(Color.GRAY);
                                        }
                                    } else {
                                        if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {
                                            holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " & " +
                                                    mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets());

                                        } else {
                                            holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " & " +
                                                    mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets());
                                        }
                                    }
                                }
                            }else {

                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().isDeclared() == true) {
                                    holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " d");

                                    holder.txtTeam1Score.setTextColor(Color.GRAY);
                                    holder.txtTeam1Name.setTextColor(Color.GRAY);
                                } else {
                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {
                                        holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " (" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getOvers() + ")");

                                        holder.txtTeam1Score.setTextColor(Color.GRAY);
                                        holder.txtTeam1Name.setTextColor(Color.GRAY);
                                    } else {
                                        holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " (" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getOvers() + ")");
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

                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score() != null) {
                        if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1() != null) {
                            if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2() != null) {

                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().isDeclared() == true) {
                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {

                                        holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets() + " d");

                                        holder.txtTeam2Score.setTextColor(Color.GRAY);
                                        holder.txtTeam2Name.setTextColor(Color.GRAY);
                                    } else {
                                        holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets() + " d");
                                        holder.txtTeam2Score.setTextColor(Color.GRAY);
                                        holder.txtTeam2Name.setTextColor(Color.GRAY);
                                    }
                                } else {

                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets() == 10) {
                                        if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {
                                            holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " & " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns());

                                            holder.txtTeam2Score.setTextColor(Color.GRAY);
                                            holder.txtTeam2Name.setTextColor(Color.GRAY);
                                        } else {
                                            holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " & " +
                                                    mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns());

                                            holder.txtTeam2Score.setTextColor(Color.GRAY);
                                            holder.txtTeam2Name.setTextColor(Color.GRAY);
                                        }
                                    } else {
                                        if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {
                                            holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " & " +
                                                    mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets());

                                        } else {
                                            holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " & " +
                                                    mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets());
                                        }
                                    }
                                }
                            } else {

                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().isDeclared() == true) {
                                    holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " d");

                                    holder.txtTeam2Score.setTextColor(Color.GRAY);
                                    holder.txtTeam2Name.setTextColor(Color.GRAY);
                                } else {
                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {
                                        holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " (" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getOvers() + ")");

                                        holder.txtTeam2Score.setTextColor(Color.GRAY);
                                        holder.txtTeam2Name.setTextColor(Color.GRAY);
                                    } else {
                                        holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " (" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getOvers() + ")");
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
                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getState().equalsIgnoreCase("Upcoming")
                            || mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getState().equalsIgnoreCase("Preview")) {
                    holder.txtMatchStatus.setTextColor(Color.RED);

                }
                if(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getState().equalsIgnoreCase("Won")
                        || mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getState().equalsIgnoreCase("Complete")){
                    holder.txtMatchStatus.setTextColor(Color.BLUE);
                }
                if(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getStatus() == null){
                    holder.txtMatchStatus.setText(formattedDate);
                }else{
                    holder.txtMatchStatus.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getStatus());
                }
            }

        }

        else {

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getStartDate()));
            SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM h:mm a");
            String formattedDate = formatter.format(calendar.getTime());

            holder.txtMatchAndSeriesName.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getMatchDesc() + "-" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getSeriesName());
            holder.txtTeam1Name.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getTeam1().getTeamSName());
            holder.txtTeam2Name.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getTeam2().getTeamSName());

            Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getTeam1().getImageId() + "/i.jpg",
                    new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam1);

            Glide.with(context).load(new GlideUrl("https://cricbuzz-cricket.p.rapidapi.com/img/v1/i1/c" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getTeam2().getImageId() + "/i.jpg",
                    new LazyHeaders.Builder().addHeader("X-RapidAPI-Key", MainActivity.apiKey).build())).into(holder.imgTeam2);

            if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore() != null) {

                //team1 score
                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score() != null) {
                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1() != null) {
                        if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2() != null) {

                            if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().isDeclared() == true) {
                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {

                                    holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " & " +
                                            mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets() + " d");

                                    holder.txtTeam1Score.setTextColor(Color.GRAY);
                                    holder.txtTeam1Name.setTextColor(Color.GRAY);

                                }
                                else {
                                    holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " & " +
                                            mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets() + " d");

                                    holder.txtTeam1Score.setTextColor(Color.GRAY);
                                    holder.txtTeam1Name.setTextColor(Color.GRAY);
                                }
                            } else {

                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets() == 10) {
                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {
                                        holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns());

                                        holder.txtTeam1Score.setTextColor(Color.GRAY);
                                        holder.txtTeam1Name.setTextColor(Color.GRAY);
                                    } else {
                                        holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns());

                                        holder.txtTeam1Score.setTextColor(Color.GRAY);
                                        holder.txtTeam1Name.setTextColor(Color.GRAY);
                                    }
                                } else {
                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {
                                        holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets());

                                    } else {
                                        holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs2().getWickets());
                                    }
                                }
                            }
                        }else {

                            if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().isDeclared() == true) {
                                holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " d");

                                holder.txtTeam1Score.setTextColor(Color.GRAY);
                                holder.txtTeam1Name.setTextColor(Color.GRAY);
                            } else {
                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() == 10) {
                                    holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " (" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getOvers() + ")");

                                    holder.txtTeam1Score.setTextColor(Color.GRAY);
                                    holder.txtTeam1Name.setTextColor(Color.GRAY);
                                } else {
                                    holder.txtTeam1Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getWickets() + " (" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam1Score().getInngs1().getOvers() + ")");
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

                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score() != null) {
                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1() != null) {
                        if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2() != null) {

                            if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().isDeclared() == true) {
                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {

                                    holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " & " +
                                            mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets() + " d");

                                    holder.txtTeam2Score.setTextColor(Color.GRAY);
                                    holder.txtTeam2Name.setTextColor(Color.GRAY);
                                } else {
                                    holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " & " +
                                            mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets() + " d");
                                    holder.txtTeam2Score.setTextColor(Color.GRAY);
                                    holder.txtTeam2Name.setTextColor(Color.GRAY);
                                }
                            } else {

                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets() == 10) {
                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {
                                        holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " & " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns());

                                        holder.txtTeam2Score.setTextColor(Color.GRAY);
                                        holder.txtTeam2Name.setTextColor(Color.GRAY);
                                    } else {
                                        holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns());

                                        holder.txtTeam2Score.setTextColor(Color.GRAY);
                                        holder.txtTeam2Name.setTextColor(Color.GRAY);
                                    }
                                } else {
                                    if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {
                                        holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets());

                                    } else {
                                        holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " & " +
                                                mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs2().getWickets());
                                    }
                                }
                            }
                        } else {

                            if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().isDeclared() == true) {
                                holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " d");

                                holder.txtTeam2Score.setTextColor(Color.GRAY);
                                holder.txtTeam2Name.setTextColor(Color.GRAY);
                            } else {
                                if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() == 10) {
                                    holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " (" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getOvers() + ")");

                                    holder.txtTeam2Score.setTextColor(Color.GRAY);
                                    holder.txtTeam2Name.setTextColor(Color.GRAY);
                                } else {
                                    holder.txtTeam2Score.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getRuns() + " - " + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getWickets() + " (" + mydata.getSeriesAdWrapper().getMatches().get(0).getMatchScore().getTeam2Score().getInngs1().getOvers() + ")");
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
            if (mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getState().equalsIgnoreCase("Upcoming")
                    || mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getState().equalsIgnoreCase("Preview")) {
                holder.txtMatchStatus.setTextColor(Color.RED);
            }
            if(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getState().equalsIgnoreCase("Won")
                    || mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getState().equalsIgnoreCase("Complete")){
                holder.txtMatchStatus.setTextColor(Color.BLUE);
            }
            if(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getStatus() == null){
                holder.txtMatchStatus.setText(formattedDate);
            }else{
                holder.txtMatchStatus.setText(mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getStatus());
            }
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Clickedd :: "+ mydata.getSeriesAdWrapper().getMatches().get(0).getMatchInfo().getMatchFormat(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return seriesMatches == null ? 0 : seriesMatches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtMatchAndSeriesName, txtTeam1Name, txtTeam2Name, txtTeam1Score, txtTeam2Score, txtMatchStatus;
        ImageView imgTeam1, imgTeam2;
        CardView cardView;
        LinearLayout main_view;

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
            main_view = itemView.findViewById(R.id.main_view);
        }
    }
}
