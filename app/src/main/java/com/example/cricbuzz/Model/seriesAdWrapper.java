package com.example.cricbuzz.Model;

import java.util.List;

public class seriesAdWrapper {

    private String seriesName;
    List<matches> matches;

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public List<matches> getMatches() {
        return matches;
    }

    public void setMatches(List<matches> matches) {
        this.matches = matches;
    }
}
