package com.example.shortassignment.Model;

public class Thinklies {

    private String name;
    private String body;
    private String bostonTeaParty;
    private String fullDesc;

    public Thinklies(String name, String body, String bostonTeaParty) {
        this.name = name;
        this.body = body;
        this.bostonTeaParty = bostonTeaParty;
    }

    public Thinklies() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBostonTeaParty() {
        return bostonTeaParty;
    }

    public void setBostonTeaParty(String bostonTeaParty) {
        this.bostonTeaParty = bostonTeaParty;
    }

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }
}
