package com.example.cricbuzz.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class seriesMapProto {

    private String date;
    List<series> series;

    @SerializedName("seriesMapProto")
    seriesMapProto[] seriesMapProto;

    public com.example.cricbuzz.Model.seriesMapProto[] getSeriesMapProto() {
        return seriesMapProto;
    }

    public void setSeriesMapProto(com.example.cricbuzz.Model.seriesMapProto[] seriesMapProto) {
        this.seriesMapProto = seriesMapProto;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<com.example.cricbuzz.Model.series> getSeries() {
        return series;
    }

    public void setSeries(List<com.example.cricbuzz.Model.series> series) {
        this.series = series;
    }
}
