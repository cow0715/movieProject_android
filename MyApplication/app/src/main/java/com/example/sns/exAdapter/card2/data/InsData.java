package com.example.sns.exAdapter.card2.data;

public class InsData {
    int type; // 0

    String name;
    String like;
    String tag;

    public InsData(int type, String name, String like, String tag) {
        this.type = type;
        this.name = name;
        this.like = like;
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
