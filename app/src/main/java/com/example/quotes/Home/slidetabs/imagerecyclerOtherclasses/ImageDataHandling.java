package com.example.quotes.Home.slidetabs.imagerecyclerOtherclasses;

public class ImageDataHandling {
   private String tag;
   private String iUrl;
    ImageDataHandling(){

    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getiUrl() {
        return iUrl;
    }

    public void setiUrl(String iUrl) {
        this.iUrl = iUrl;
    }

    public ImageDataHandling(String tag, String iUrl) {
        this.tag = tag;
        this.iUrl = iUrl;
    }
}
