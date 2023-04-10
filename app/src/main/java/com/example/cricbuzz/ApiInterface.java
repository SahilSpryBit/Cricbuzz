package com.example.cricbuzz;

import com.example.cricbuzz.Model.MyDataClass;
import com.example.cricbuzz.Model.Root;
import com.example.cricbuzz.Model.list;
import com.example.cricbuzz.Model.player;
import com.example.cricbuzz.Model.seriesMapProto;
import com.example.cricbuzz.Model.storyList;
import com.example.cricbuzz.Model.typeMatches;
import com.example.cricbuzz.Model.values;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

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

    @GET("stats/v1/rankings/batsmen")
    Call<MyDataClass> getIccRankingMens_Batsmen(@Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String hostname, @Query("formatType") String formatType);

    @GET("stats/v1/rankings/bowlers")
    Call<MyDataClass> getIccRankingMens_Bowler(@Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String hostname, @Query("formatType") String formatType);

    @GET("stats/v1/rankings/allrounders")
    Call<MyDataClass> getIccRankingMens_AllRounder(@Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String hostname, @Query("formatType") String formatType);

    @GET("stats/v1/rankings/teams")
    Call<MyDataClass> getIccRankingMens_Teams(@Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String hostname, @Query("formatType") String formatType);

    @GET("stats/v1/rankings/batsmen")
    Call<MyDataClass> getIccRankingWomens_Batsmen(@Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String hostname, @Query("formatType") String formatType, @Query("isWomen") String isWomen);

    @GET("stats/v1/rankings/bowlers")
    Call<MyDataClass> getIccRankingWomens_Bowler(@Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String hostname, @Query("formatType") String formatType, @Query("isWomen") String isWomen);

    @GET("stats/v1/rankings/allrounders")
    Call<MyDataClass> getIccRankingWomens_AllRounder(@Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String hostname, @Query("formatType") String formatType, @Query("isWomen") String isWomen);

    @GET("stats/v1/rankings/teams")
    Call<MyDataClass> getIccRankingWomens_Teams(@Header("X-RapidAPI-Key") String apiKey, @Header("X-RapidAPI-Host") String hostname, @Query("formatType") String formatType, @Query("isWomen") String isWomen);

    @GET("news/v1/index")
    Call<storyList> getNews(@Header("X-RapidAPI-Key") String apiKey);

    @GET("stats/v1/iccstanding/team/matchtype/1")
    Call<values> getTestIccStanding(@Header("X-RapidAPI-Key") String apiKey);

    @GET("stats/v1/iccstanding/team/matchtype/2")
    Call<values> getOdiIccStanding(@Header("X-RapidAPI-Key") String apiKey);

}

