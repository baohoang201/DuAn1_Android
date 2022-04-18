package com.example.duan1_android.DTO;

public class OrderList {
    private byte[] img;
    private String ten;
    private int gia;

    public OrderList(byte[] img,String ten, int gia) {
        this.ten = ten;
        this.gia = gia;
        this.img =img;
    }

    public byte[] getImg() {
        return img;
    }

    public String getTen() {
        return ten;
    }

    public int getGia() {
        return gia;
    }

}
