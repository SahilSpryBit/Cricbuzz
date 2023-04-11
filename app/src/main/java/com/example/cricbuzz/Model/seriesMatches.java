package com.example.cricbuzz.Model;

import com.google.gson.annotations.SerializedName;

public class seriesMatches {

    seriesAdWrapper seriesAdWrapper;
    adDetail adDetail;

    @SerializedName("seriesMatches")
    seriesMatches[] seriesMatches;

    public com.example.cricbuzz.Model.seriesAdWrapper getSeriesAdWrapper() {
        return seriesAdWrapper;
    }

    public void setSeriesAdWrapper(com.example.cricbuzz.Model.seriesAdWrapper seriesAdWrapper) {
        this.seriesAdWrapper = seriesAdWrapper;
    }

    public com.example.cricbuzz.Model.adDetail getAdDetail() {
        return adDetail;
    }

    public void setAdDetail(com.example.cricbuzz.Model.adDetail adDetail) {
        this.adDetail = adDetail;
    }

    /*public com.example.cricbuzz.Model.seriesMatches[] getSeriesMatches() {
        return seriesMatches;
    }

    public void setSeriesMatches(com.example.cricbuzz.Model.seriesMatches[] seriesMatches) {
        this.seriesMatches = seriesMatches;
    }*/
}
