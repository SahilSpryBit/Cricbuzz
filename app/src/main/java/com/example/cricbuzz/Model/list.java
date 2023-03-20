package com.example.cricbuzz.Model;

import com.google.gson.annotations.SerializedName;

public class list {

    private int teamId;
    private String teamName;
    private String teamSName;
    private int imageId;

    @SerializedName("list")
    list[] list;

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

    public com.example.cricbuzz.Model.list[] getList() {
        return list;
    }

    public void setList(com.example.cricbuzz.Model.list[] list) {
        this.list = list;
    }
}
