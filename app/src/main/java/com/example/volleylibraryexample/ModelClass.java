package com.example.volleylibraryexample;

public class ModelClass {
    String imageUrl;
    String userName;
    int likes;

    public ModelClass(String imageUrl, String userName, int likes) {
        this.imageUrl = imageUrl;
        this.userName = userName;
        this.likes = likes;
    }

    public String getImageUrl() {
        return imageUrl;
    }



    public String getUserName() {
        return userName;
    }



    public int getLikes() {
        return likes;
    }


}
