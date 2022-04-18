package com.example.duan1_android.DTO;

public class ItemUuDai {
    private int imgId;
    private String  title;

    public ItemUuDai(int imgId, String title) {
        this.imgId = imgId;
        this.title = title;
    }

    public ItemUuDai() {

    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
