package com.example.quotes.Home.slidetabs;

public class ModelHeadlines {
    private String headline;
    private String textline;
    private int image;

    public ModelHeadlines(String headline, String textline, int image) {
        this.headline = headline;
        this.textline = textline;
        this.image = image;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getTextline() {
        return textline;
    }

    public void setTextline(String textline) {
        this.textline = textline;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
