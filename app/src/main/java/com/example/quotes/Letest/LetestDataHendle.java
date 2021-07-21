package com.example.quotes.Letest;

public class LetestDataHendle {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    private String  tag;

    public LetestDataHendle(String title, String tag) {
        this.title = title;
        this.tag = tag;
    }

    public LetestDataHendle(){

    }


}
