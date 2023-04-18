package com.example.cricbuzz.Model;

import android.app.appsearch.SearchResult;

public class MatchModel {

    public matchInfo matchInfo;
    public venueInfo venueInfo;

    public com.example.cricbuzz.Model.matchInfo getMatchInfo() {
        return matchInfo;
    }

    public void setMatchInfo(com.example.cricbuzz.Model.matchInfo matchInfo) {
        this.matchInfo = matchInfo;
    }

    public com.example.cricbuzz.Model.venueInfo getVenueInfo() {
        return venueInfo;
    }

    public void setVenueInfo(com.example.cricbuzz.Model.venueInfo venueInfo) {
        this.venueInfo = venueInfo;
    }
}
