package com.example.shortassignment.Model;

import java.util.List;

public class Assignment {

    private List<Thinklies> thinklies = null;
    private List<News_feed> newsFeed = null;


    public List<Thinklies> getThinklies() {
        return thinklies;
    }

    public void setThinklies(List<Thinklies> thinklies) {
        this.thinklies = thinklies;
    }

    public List<News_feed> getNewsFeed() {
        return newsFeed;
    }

    public void setNewsFeed(List<News_feed> newsFeed) {
        this.newsFeed = newsFeed;
    }
}
