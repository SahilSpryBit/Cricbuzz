package com.example.cricbuzz.Model;

public class matchInfo {

    private int matchId;
    private int seriesId;
    private String seriesName;
    private String matchDesc;
    private String matchFormat;
    private String startDate;
    private String endDate;
    private String state;
    private String status;
    team1 team1;
    team2 team2;
    venueInfo venueInfo;
    private int currBatTeamId;
    private String seriesStartDt;
    private String seriesEndDt;
    private boolean isTimeAnnounced;
    private String stateTitle;
    private boolean isFantasyEnabled;

    private String matchDescription;
    private long matchStartTimestamp;
    private long matchCompleteTimestamp;

    tossResults tossResults;
    series series;
    venue venue;
    umpire1 umpire1;
    umpire2 umpire2;
    umpire3 umpire3;

    referee referee;

    public com.example.cricbuzz.Model.referee getReferee() {
        return referee;
    }

    public void setReferee(com.example.cricbuzz.Model.referee referee) {
        this.referee = referee;
    }

    public com.example.cricbuzz.Model.umpire1 getUmpire1() {
        return umpire1;
    }

    public void setUmpire1(com.example.cricbuzz.Model.umpire1 umpire1) {
        this.umpire1 = umpire1;
    }

    public com.example.cricbuzz.Model.umpire2 getUmpire2() {
        return umpire2;
    }

    public void setUmpire2(com.example.cricbuzz.Model.umpire2 umpire2) {
        this.umpire2 = umpire2;
    }

    public com.example.cricbuzz.Model.umpire3 getUmpire3() {
        return umpire3;
    }

    public void setUmpire3(com.example.cricbuzz.Model.umpire3 umpire3) {
        this.umpire3 = umpire3;
    }

    public com.example.cricbuzz.Model.venue getVenue() {
        return venue;
    }

    public void setVenue(com.example.cricbuzz.Model.venue venue) {
        this.venue = venue;
    }

    public com.example.cricbuzz.Model.series getSeries() {
        return series;
    }

    public void setSeries(com.example.cricbuzz.Model.series series) {
        this.series = series;
    }

    public com.example.cricbuzz.Model.tossResults getTossResults() {
        return tossResults;
    }

    public void setTossResults(com.example.cricbuzz.Model.tossResults tossResults) {
        this.tossResults = tossResults;
    }

    public long getMatchStartTimestamp() {
        return matchStartTimestamp;
    }

    public void setMatchStartTimestamp(long matchStartTimestamp) {
        this.matchStartTimestamp = matchStartTimestamp;
    }

    public long getMatchCompleteTimestamp() {
        return matchCompleteTimestamp;
    }

    public void setMatchCompleteTimestamp(long matchCompleteTimestamp) {
        this.matchCompleteTimestamp = matchCompleteTimestamp;
    }

    public String getMatchDescription() {
        return matchDescription;
    }

    public void setMatchDescription(String matchDescription) {
        this.matchDescription = matchDescription;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getMatchDesc() {
        return matchDesc;
    }

    public void setMatchDesc(String matchDesc) {
        this.matchDesc = matchDesc;
    }

    public String getMatchFormat() {
        return matchFormat;
    }

    public void setMatchFormat(String matchFormat) {
        this.matchFormat = matchFormat;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public com.example.cricbuzz.Model.team1 getTeam1() {
        return team1;
    }

    public void setTeam1(com.example.cricbuzz.Model.team1 team1) {
        this.team1 = team1;
    }

    public com.example.cricbuzz.Model.team2 getTeam2() {
        return team2;
    }

    public void setTeam2(com.example.cricbuzz.Model.team2 team2) {
        this.team2 = team2;
    }

    public com.example.cricbuzz.Model.venueInfo getVenueInfo() {
        return venueInfo;
    }

    public void setVenueInfo(com.example.cricbuzz.Model.venueInfo venueInfo) {
        this.venueInfo = venueInfo;
    }

    public int getCurrBatTeamId() {
        return currBatTeamId;
    }

    public void setCurrBatTeamId(int currBatTeamId) {
        this.currBatTeamId = currBatTeamId;
    }

    public String getSeriesStartDt() {
        return seriesStartDt;
    }

    public void setSeriesStartDt(String seriesStartDt) {
        this.seriesStartDt = seriesStartDt;
    }

    public String getSeriesEndDt() {
        return seriesEndDt;
    }

    public void setSeriesEndDt(String seriesEndDt) {
        this.seriesEndDt = seriesEndDt;
    }

    public boolean isTimeAnnounced() {
        return isTimeAnnounced;
    }

    public void setTimeAnnounced(boolean timeAnnounced) {
        isTimeAnnounced = timeAnnounced;
    }

    public String getStateTitle() {
        return stateTitle;
    }

    public void setStateTitle(String stateTitle) {
        this.stateTitle = stateTitle;
    }

    public boolean isFantasyEnabled() {
        return isFantasyEnabled;
    }

    public void setFantasyEnabled(boolean fantasyEnabled) {
        isFantasyEnabled = fantasyEnabled;
    }
}
