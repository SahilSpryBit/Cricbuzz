package com.example.cricbuzz.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class storyList {

    story story;
    adDetail adDetail;
    @SerializedName("storyList")
    storyList[] storyList;

    public com.example.cricbuzz.Model.story getStory() {
        return story;
    }

    public void setStory(com.example.cricbuzz.Model.story story) {
        this.story = story;
    }

    public com.example.cricbuzz.Model.adDetail getAdDetail() {
        return adDetail;
    }

    public void setAdDetail(com.example.cricbuzz.Model.adDetail adDetail) {
        this.adDetail = adDetail;
    }

    public com.example.cricbuzz.Model.storyList[] getStoryList() {
        return storyList;
    }

    public void setStoryList(com.example.cricbuzz.Model.storyList[] storyList) {
        this.storyList = storyList;
    }
}
