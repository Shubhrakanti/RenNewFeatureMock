package com.example.giddu.rennewfeaturemock;

import android.graphics.Bitmap;

/**
 * Created by giddu on 3/2/17.
 */

public class PicturePost {

    private String username;
    private String timePosted;
    private int profPicID;
    private Bitmap picPostBitmap;
    private int num_likes;
    private int num_comments;



    private String caption;

    public PicturePost(String username, String timePosted, int profPicID, Bitmap picPostBitmap, int num_likes, int num_comments, String caption) {
        this.username = username;
        this.timePosted = timePosted;
        this.profPicID = profPicID;
        this.picPostBitmap = picPostBitmap;
        this.num_likes = num_likes;
        this.num_comments = num_comments;
        this.caption = caption;
    }

    public String getUsername() {
        return username;
    }

    public String getTimePosted() {
        return timePosted;
    }

    public int getProfPicID() {
        return profPicID;
    }

    public Bitmap getPicPostID() {
        return picPostBitmap;
    }

    public int getNum_likes() {
        return num_likes;
    }

    public int getNum_comments() {
        return num_comments;
    }

    public String getCaption() {
        return caption;
    }
}
