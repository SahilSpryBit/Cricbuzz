package com.example.cricbuzz.Model;

public class series {

    private int id;
    private String name;
    public String seriesType;
    public long startDate;
    public long endDate;
    public String seriesFolder;
    public String odiSeriesResult;
    public String t20SeriesResult;
    public String testSeriesResult;

    public String getSeriesType() {
        return seriesType;
    }

    public void setSeriesType(String seriesType) {
        this.seriesType = seriesType;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getSeriesFolder() {
        return seriesFolder;
    }

    public void setSeriesFolder(String seriesFolder) {
        this.seriesFolder = seriesFolder;
    }

    public String getOdiSeriesResult() {
        return odiSeriesResult;
    }

    public void setOdiSeriesResult(String odiSeriesResult) {
        this.odiSeriesResult = odiSeriesResult;
    }

    public String getT20SeriesResult() {
        return t20SeriesResult;
    }

    public void setT20SeriesResult(String t20SeriesResult) {
        this.t20SeriesResult = t20SeriesResult;
    }

    public String getTestSeriesResult() {
        return testSeriesResult;
    }

    public void setTestSeriesResult(String testSeriesResult) {
        this.testSeriesResult = testSeriesResult;
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
}
