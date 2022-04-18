package com.example.duan1_android.DTO;

import java.io.Serializable;

public class SanPhamCoffeOder implements Serializable {
    int idSP;
    private String tenSPOder;
    private int giaSPOder;
    private byte[] imgSPOder;

    public SanPhamCoffeOder(int idSP, String tenSPOder, int giaSPOder, byte[] imgSPOder, String chiTietSanPham) {
        this.idSP = idSP;
        this.tenSPOder = tenSPOder;
        this.giaSPOder = giaSPOder;
        this.imgSPOder = imgSPOder;
        this.chiTietSanPham = chiTietSanPham;
    }

    public String getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(String chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    private String chiTietSanPham;

    public SanPhamCoffeOder() {
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

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }
}
