package com.example.duan1_android.DTO;

import java.io.Serializable;

public class TheLoaiSanPham implements Serializable {
    private int maTheLoai;
    private String tenTheLoai;
    private byte[] anhTheLoai;

    public TheLoaiSanPham() {
    }

    public TheLoaiSanPham(int maTheLoai, String tenTheLoai, byte[] anhTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.anhTheLoai = anhTheLoai;
    }

    public int getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(int maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public byte[] getAnhTheLoai() {
        return anhTheLoai;
    }

    public void setAnhTheLoai(byte[] anhTheLoai) {
        this.anhTheLoai = anhTheLoai;
    }
}
