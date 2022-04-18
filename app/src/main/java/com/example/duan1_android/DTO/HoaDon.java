package com.example.duan1_android.DTO;

import java.util.Date;

public class HoaDon {
    private int idHoaDon;
    private String tongTien;
    private String ngayMua;

    public HoaDon(int idHoaDon, String tongTien, String ngayMua) {
        this.idHoaDon = idHoaDon;
        this.tongTien = tongTien;
        this.ngayMua = ngayMua;
    }

    public HoaDon() {
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }
}
