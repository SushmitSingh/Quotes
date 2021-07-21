package com.example.quotes.Liked;

public class LikedDataHandle {
    private String quote;
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    LikedDataHandle(String string){}
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public LikedDataHandle(String quote,String tag) {
        this.quote = quote;
        this.tag = tag;
    }
}
