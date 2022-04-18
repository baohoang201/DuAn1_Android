package com.example.duan1_android.DTO;

public class SanPhamDaXayOder {
    private String tenSanPham;
    private String giaSanPham;
    private byte[] anhSanPham;

    public SanPhamDaXayOder() {
    }

    public SanPhamDaXayOder(String tenSanPham, String giaSanPham, byte[] anhSanPham) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.anhSanPham = anhSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(String giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public byte[] getAnhSanPham() {
        return anhSanPham;
    }

    public void setAnhSanPham(byte[] anhSanPham) {
        this.anhSanPham = anhSanPham;
    }
}
