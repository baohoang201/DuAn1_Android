package com.example.duan1_android.DTO;

public class GioHang {
    int idSP;
    public String tenSP;
    public int giaSP;
    public byte[] anhSP;
    public int soLuongSP;


    public GioHang() {
    }

    public GioHang(String tenSP, int giaSP, byte[] anhSP, int soLuongSP, int idSp) {
        this.tenSP = tenSP;
        this.giaSP = giaSP;
        this.anhSP = anhSP;
        this.soLuongSP = soLuongSP;
        this.idSP = idSp;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(int giaSP) {
        this.giaSP = giaSP;
    }

    public byte[] getAnhSP() {
        return anhSP;
    }

    public void setAnhSP(byte[] anhSP) {
        this.anhSP = anhSP;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }
}
