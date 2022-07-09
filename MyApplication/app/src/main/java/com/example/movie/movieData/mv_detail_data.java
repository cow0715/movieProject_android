package com.example.movie.movieData;

public class mv_detail_data {
    private String title;
    private String movieImg;
    private int running_time;
    private String genre;
    private String release_date;
    private String country;
    private String story;
    private String rate;

    int type;

    public mv_detail_data(int type, String title, String movieImg, int running_time, String genre, String release_date, String country, String story, String rate) {
        this.type = type;
        this.title = title;
        this.movieImg = movieImg;
        this.running_time = running_time;
        this.genre = genre;
        this.release_date = release_date;
        this.country = country;
        this.story = story;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovie_img() {
        return movieImg;
    }

    public void setMovie_img(String movie_img) {
        this.movieImg = movie_img;
    }

    public int getRunning_time() {
        return running_time;
    }

    public void setRunning_time(int running_time) {
        this.running_time = running_time;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getType() {
        return type;
    }
}
