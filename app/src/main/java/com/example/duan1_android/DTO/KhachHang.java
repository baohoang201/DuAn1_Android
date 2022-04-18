package com.example.duan1_android.DTO;

import java.io.Serializable;

public class KhachHang implements Serializable {
   private int  maKhachHang ;
   private String  tenKhachHang ,userKH , passKH,soDienThoai,diaChi;


    private int checkAdmin;

    public KhachHang() {
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(int maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getUserKH() {
        return userKH;
    }

    public void setUserKH(String userKH) {
        this.userKH = userKH;
    }

    public String getPassKH() {
        return passKH;
    }

    public void setPassKH(String passKH) {
        this.passKH = passKH;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int isCheckAdmin() {
        return checkAdmin;
    }

    public void setCheckAdmin(int checkAdmin) {
        this.checkAdmin = checkAdmin;
    }
}
