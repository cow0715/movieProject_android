package com.example.movie.movieData;

public class mv_card_data {
    private String title;
    private String movieImg;
    private String content;

    int type;

    public mv_card_data(int type, String title, String movieImg, String content) {
        this.type = type;
        this.title = title;
        this.movieImg = movieImg;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }
}
