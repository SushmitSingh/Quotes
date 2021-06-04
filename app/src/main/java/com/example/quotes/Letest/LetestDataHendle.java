package com.example.quotes.Letest;

public class LetestDataHendle {
    private String quoteText;
    private String quoteGenre;
    public LetestDataHendle(String quoteText, String quoteGenre) {
        this.quoteText = quoteText;
        this.quoteGenre = quoteGenre;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteGenre() {
        return quoteGenre;
    }

    public void setQuoteGenre(String quoteGenre) {
        this.quoteGenre = quoteGenre;
    }


}
