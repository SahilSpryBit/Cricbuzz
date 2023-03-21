package com.example.cricbuzz;

import com.example.cricbuzz.Model.list;
import com.example.cricbuzz.Model.player;
import com.example.cricbuzz.Model.seriesMapProto;
import com.example.cricbuzz.Model.typeMatches;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {

    @GET("series/v1/international")
    Call<seriesMapProto> getBrowseSeries_International(@Header("X-RapidAPI-Key") String apiKey);
    @GET("series/v1/league")
    Call<seriesMapProto> getBrowseSeries_League(@Header("X-RapidAPI-Key") String apiKey);
    @GET("series/v1/domestic")
    Call<seriesMapProto> getBrowseSeries_Domestic(@Header("X-RapidAPI-Key") String apiKey);
    @GET("series/v1/women")
    Call<seriesMapProto> getBrowseSeries_Women(@Header("X-RapidAPI-Key") String apiKey);

    @GET("teams/v1/international")
    Call<list> getBrowseTeams_International(@Header("X-RapidAPI-Key") String apiKey);
    @GET("teams/v1/league")
    Call<list> getBrowseTeams_League(@Header("X-RapidAPI-Key") String apiKey);
    @GET("teams/v1/domestic")
    Call<list> getBrowseTeams_Domestic(@Header("X-RapidAPI-Key") String apiKey);
    @GET("teams/v1/women")
    Call<list> getBrowseTeams_Women(@Header("X-RapidAPI-Key") String apiKey);

    @GET("stats/v1/player/trending")
    Call<player> getBrowsePlayers_Trending(@Header("X-RapidAPI-Key") String apiKey);

    @GET("matches/v1/live")
    Call<typeMatches> getLive_Matches(@Header("X-RapidAPI-Key") String apiKey);

    @GET("matches/v1/upcoming")
    Call<typeMatches> getMatches_upcoming(@Header("X-RapidAPI-Key") String apiKey);

    @GET("matches/v1/recent")
    Call<typeMatches> getMatches_recent(@Header("X-RapidAPI-Key") String apiKey);


}
