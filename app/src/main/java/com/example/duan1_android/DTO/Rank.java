package com.example.duan1_android.DTO;

public class Rank {
    private String gift1;
    private int img;

    public Rank(String gift1, int img) {
        this.gift1 = gift1;
        this.img = img;
    }

    public String getGift1() {
        return gift1;
    }

    public void setGift1(String gift1) {
        this.gift1 = gift1;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
