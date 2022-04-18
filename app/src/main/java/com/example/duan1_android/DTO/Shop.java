package com.example.duan1_android.DTO;

public class Shop {
    private String tenShop;
    private String diaChiShop;
    private byte[] imgShop;

    public Shop() {
    }

    public Shop( String tenShop, String diaChiShop, byte[] imgShop) {

        this.tenShop = tenShop;
        this.diaChiShop = diaChiShop;
        this.imgShop = imgShop;
    }

    public String getTenShop() {
        return tenShop;
    }

    public void setTenShop(String tenShop) {
        this.tenShop = tenShop;
    }

    public String getDiaChiShop() {
        return diaChiShop;
    }

    public void setDiaChiShop(String diaChiShop) {
        this.diaChiShop = diaChiShop;
    }

    public byte[] getImgShop() {
        return imgShop;
    }

    public void setImgShop(byte[] imgShop) {
        this.imgShop = imgShop;
    }
}
