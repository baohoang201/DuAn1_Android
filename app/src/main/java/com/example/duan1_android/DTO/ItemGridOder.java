package com.example.duan1_android.DTO;

import android.graphics.Bitmap;

public class ItemGridOder {
    Bitmap imgGridOder;
    String titleOder;

    public ItemGridOder() {
    }


    public ItemGridOder(Bitmap imgGridOder, String titleOder) {
        this.imgGridOder = imgGridOder;
        this.titleOder = titleOder;
    }

    public Bitmap getImgGridOder() {
        return imgGridOder;
    }

    public void setImgGridOder(Bitmap imgGridOder) {
        this.imgGridOder = imgGridOder;
    }

    public String getTitleOder() {
        return titleOder;
    }

    public void setTitleOder(String titleOder) {
        this.titleOder = titleOder;
    }
}
