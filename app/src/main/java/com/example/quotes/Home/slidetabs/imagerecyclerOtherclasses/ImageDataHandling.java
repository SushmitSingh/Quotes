package com.example.quotes.Home.slidetabs.imagerecyclerOtherclasses;

public class ImageDataHandling {
    private String type;
    private int image;

    public ImageDataHandling(String type, int image) {
        this.type = type;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
