package com.example.movie.movieData;

public class mv_card_data {
    private String title;
    private String movie_img;
    private String content;

    int type;

    public mv_card_data(int type, String title, String movie_img, String content) {
        this.type = type;
        this.title = title;
        this.movie_img = movie_img;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovie_img() {
        return movie_img;
    }

    public void setMovie_img(String movie_img) {
        this.movie_img = movie_img;
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
