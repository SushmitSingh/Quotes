package com.example.quotes.Home.slidetabs;

public class ModelHeadlines {
    private String title;
    private String mUrl;

    public ModelHeadlines(){}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.mUrl = mUrl;
    }

    public String getMUrl() {
        return mUrl;
    }

    public void setMUrl(String url) {
        mUrl = url;
    }

    public ModelHeadlines(String title, String mUrl,String quotes) {
        this.title = title;
        this.mUrl = mUrl;

    }
}
