package com.example.cricbuzz.Model;

public class story {

    public int id;
    public String hline;
    public String intro;
    public String pubTime;
    public String source;
    public String storyType;
    public int imageId;
    public String seoHeadline;
    public String context;
    coverImage coverImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHline() {
        return hline;
    }

    public void setHline(String hline) {
        this.hline = hline;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStoryType() {
        return storyType;
    }

    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getSeoHeadline() {
        return seoHeadline;
    }

    public void setSeoHeadline(String seoHeadline) {
        this.seoHeadline = seoHeadline;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public com.example.cricbuzz.Model.coverImage getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(com.example.cricbuzz.Model.coverImage coverImage) {
        this.coverImage = coverImage;
    }
}
