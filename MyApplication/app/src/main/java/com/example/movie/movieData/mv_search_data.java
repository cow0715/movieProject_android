package com.example.movie.movieData;

public class mv_search_data {

    private String title;
    private String movieImg;
    private String genre;
    private String release_year;
    private String content;
    private String company;

    int type;

    public mv_search_data(int type, String title, String movieImg, String genre, String release_year, String content, String company) {
        this.type = type;
        this.title = title;
        this.movieImg = movieImg;
        this.genre = genre;
        this.release_year = release_year;
        this.content = content;
        this.company = company;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getType() {
        return type;
    }
}

