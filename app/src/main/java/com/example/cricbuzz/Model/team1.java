package com.example.cricbuzz.Model;

import com.example.cricbuzz.Fragment.playerDetails;

import java.util.List;

public class team1 {

    private int teamId;
    private String teamName;
    private String teamSName;
    private int imageId;

    private String shortName;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    private List<com.example.cricbuzz.Fragment.playerDetails> playerDetails;

    public List<com.example.cricbuzz.Fragment.playerDetails> getPlayerDetails() {
        return playerDetails;
    }

    public void setPlayerDetails(List<com.example.cricbuzz.Fragment.playerDetails> playerDetails) {
        this.playerDetails = playerDetails;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamSName() {
        return teamSName;
    }

    public void setTeamSName(String teamSName) {
        this.teamSName = teamSName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
