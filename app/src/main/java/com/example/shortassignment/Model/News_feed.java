package com.example.shortassignment.Model;

public class News_feed {

    private String name;
    private String body;
    private String fullDesc;

    public News_feed(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public News_feed() {

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

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }
}
