package com.example.duan1_android.DTO;

import java.io.Serializable;

public class SanPhamBanhOder implements Serializable {


    private int id;
    private String tenSPOder;
    private int giaSPOder;
    private byte[] imgSPOder;

    public SanPhamBanhOder() {
    }

    public SanPhamBanhOder(String tenSPOder, int giaSPOder, byte[] imgSPOder, int id) {
        this.tenSPOder = tenSPOder;
        this.giaSPOder = giaSPOder;
        this.imgSPOder = imgSPOder;
        this.id = id;
    }

    public String getTenSPOder() {
        return tenSPOder;
    }

    public void setTenSPOder(String tenSPOder) {
        this.tenSPOder = tenSPOder;
    }

    public int getGiaSPOder() {
        return giaSPOder;
    }

    public void setGiaSPOder(int giaSPOder) {
        this.giaSPOder = giaSPOder;
    }

    public byte[] getImgSPOder() {
        return imgSPOder;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImgSPOder(byte[] imgSPOder) {
        this.imgSPOder = imgSPOder;
    }
}
