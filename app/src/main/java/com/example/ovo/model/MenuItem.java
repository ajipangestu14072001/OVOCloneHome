package com.example.ovo.model;

public class MenuItem {
    private final String title;
    private final int imageResource;

    public MenuItem(String title, int imageResource ) {
        this.title = title;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }

}
