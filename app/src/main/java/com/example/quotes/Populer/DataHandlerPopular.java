package com.example.quotes.Populer;

public class DataHandlerPopular {
    private String quote;
    private String tagType;

    public DataHandlerPopular(String quote, String tagType) {
        this.quote = quote;
        this.tagType = tagType;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }
}
