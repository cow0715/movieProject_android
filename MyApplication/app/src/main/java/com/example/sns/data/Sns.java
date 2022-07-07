package com.example.sns.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sns implements Serializable {
    @SerializedName("sid")
    int sid;

    @SerializedName("title")
    String title;

    @SerializedName("content")
    String content;

    @SerializedName("img")
    String img;

    @SerializedName("date")
    String date;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}