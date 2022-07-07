package com.example.sns.exAdapter.card2.data;

public class PersonData {
    int type;

    String name;
    String phone;

    public PersonData(int type, String name, String phone) {
        this.type = type;
        this.name = name;
        this.phone = phone;
    }
    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
