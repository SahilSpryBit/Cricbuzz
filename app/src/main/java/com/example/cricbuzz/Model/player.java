package com.example.cricbuzz.Model;

import com.google.gson.annotations.SerializedName;

public class player {

    private String category;
    private int id;
    private String name;
    private String teamName;
    private String faceImageId;

    @SerializedName("player")
    player[] players;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getFaceImageId() {
        return faceImageId;
    }

    public void setFaceImageId(String faceImageId) {
        this.faceImageId = faceImageId;
    }

    public player[] getPlayers() {
        return players;
    }

    public void setPlayers(player[] players) {
        this.players = players;
    }
}
