package com.example.duan1_android.DTO;

import java.io.Serializable;

public class SanPhamThem implements Serializable {
    private int  maSanPham, giaSanPham, maTheLoai;
    private String tenSanPham;
    private  byte[] anhSanPham;

    public SanPhamThem(int maSanPham, int giaSanPham, int maTheLoai, String tenSanPham, byte[] anhSanPham) {
        this.maSanPham = maSanPham;
        this.giaSanPham = giaSanPham;
        this.maTheLoai = maTheLoai;
        this.tenSanPham = tenSanPham;
        this.anhSanPham = anhSanPham;
    }

    public SanPhamThem() {
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(int giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public byte[] getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(byte[] anhSanPham) {
        this.anhSanPham = anhSanPham;
    }
}
