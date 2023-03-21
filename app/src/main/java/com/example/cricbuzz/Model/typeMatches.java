package com.example.cricbuzz.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class typeMatches {

    private String matchType;
    List<seriesMatches> seriesMatches;

    @SerializedName("typeMatches")
    typeMatches[] typeMatches;

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public List<com.example.cricbuzz.Model.seriesMatches> getSeriesMatches() {
        return seriesMatches;
    }

    public void setSeriesMatches(List<com.example.cricbuzz.Model.seriesMatches> seriesMatches) {
        this.seriesMatches = seriesMatches;
    }

    public com.example.cricbuzz.Model.typeMatches[] getTypeMatches() {
        return typeMatches;
    }

    public void setTypeMatches(com.example.cricbuzz.Model.typeMatches[] typeMatches) {
        this.typeMatches = typeMatches;
    }
}
