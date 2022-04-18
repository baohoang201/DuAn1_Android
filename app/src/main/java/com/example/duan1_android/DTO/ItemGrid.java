package com.example.duan1_android.DTO;

import android.graphics.Bitmap;

public class ItemGrid {
    Bitmap imgGrid;
    String title;

    public ItemGrid() {
    }

    public ItemGrid(Bitmap imgGrid, String title) {
        this.imgGrid = imgGrid;
        this.title = title;
    }

    public Bitmap getImgGrid() {
        return imgGrid;
    }

    public void setImgGrid(Bitmap imgGrid) {
        this.imgGrid = imgGrid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
