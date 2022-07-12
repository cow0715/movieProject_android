package com.example.movie.movieData;

public class mv_detail_data {
    private String title;
    private String story;
    private String movieImg;
    private int runningTime;
    private String genre;
    private String releaseDate;
    private String country;
    private String rate;
    private String movieUrl;
    private String actor_id;
    int type;

    public mv_detail_data(int type, String title, String movieImg, int runningTime, String genre, String releaseDate, String country, String story, String rate) {
        this.type = type;
        this.title = title;
        this.movieImg = movieImg;
        this.runningTime = runningTime;
        this.genre = genre;
        this.releaseDate = releaseDate;
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
        return runningTime;
    }

    public void setRunning_time(int runningTime) {
        this.runningTime = runningTime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease_date() {
        return releaseDate;
    }

    public void setRelease_date(String releaseDate) {
        this.releaseDate = releaseDate;
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

    public String getMovie_url() {
        return movieUrl;
    }

    public void setMovie_url(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public String getActor_id() {
        return actor_id;
    }

    public void setActor_id(String actor_id) {
        this.actor_id = actor_id;
    }
}
