package com.example.sns.exAdapter.movieApi.Data;

import java.util.ArrayList;

public class MovieRes {

    String lastBuildDate; // un, 22 May 2022 10:21:18 +0900
    String total;
    String start;
    String display;

    public ArrayList<MovieData> items = new ArrayList<MovieData>();

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
