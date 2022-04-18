package com.example.duan1_android.DTO;

public class SanPham {
    private String tenSp;
    private String giaSP;
    private int imgSP;

    public SanPham() {
    }

    public SanPham(String tenSp, String giaSP, int imgSP) {
        this.tenSp = tenSp;
        this.giaSP = giaSP;
        this.imgSP = imgSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    public int getImgSP() {
        return imgSP;
    }

    public void setImgSP(int imgSP) {
        this.imgSP = imgSP;
    }
}
