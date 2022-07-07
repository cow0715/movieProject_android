package com.example.sns.exAdapter.card2.data;

public class CfData {

    int type; // 1

    String name;
    String brand_name;
    String brand_color;
    String brand_price;


    public CfData(int type, String name, String brand_name, String brand_color, String brand_price) {
        this.type = type;
        this.name = name;
        this.brand_name = brand_name;
        this.brand_color = brand_color;
        this.brand_price = brand_price;
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

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_color() {
        return brand_color;
    }

    public void setBrand_color(String brand_color) {
        this.brand_color = brand_color;
    }

    public String getBrand_price() {
        return brand_price;
    }

    public void setBrand_price(String brand_price) {
        this.brand_price = brand_price;
    }
}
