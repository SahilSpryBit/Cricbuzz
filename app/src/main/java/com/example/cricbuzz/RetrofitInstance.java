package com.example.cricbuzz;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    public static final String BASEURL = "https://cricbuzz-cricket.p.rapidapi.com/";
    public static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
