package com.example.duan1_android.DTO;

public class SanPhamTraSuaOder {
    private String tenSPOder;
    private int giaSPOder;
    private byte[] imgSPOder;

    public SanPhamTraSuaOder() {
    }

    public SanPhamTraSuaOder(String tenSPOder, int giaSPOder, byte[] imgSPOder) {
        this.tenSPOder = tenSPOder;
        this.giaSPOder = giaSPOder;
        this.imgSPOder = imgSPOder;
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

    public void setImgSPOder(byte[] imgSPOder) {
        this.imgSPOder = imgSPOder;
    }
}
