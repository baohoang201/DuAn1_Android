package com.example.duan1_android.SelectAll;

import android.content.Context;

import com.example.duan1_android.Connect.ConnectionHelper;
import com.example.duan1_android.DTO.HoaDon;
import com.example.duan1_android.DTO.KhachHang;
import com.example.duan1_android.DTO.SanPhamBanhOder;
import com.example.duan1_android.DTO.SanPhamCoffeOder;
import com.example.duan1_android.DTO.SanPhamDaXayOder;
import com.example.duan1_android.DTO.SanPhamThem;
import com.example.duan1_android.DTO.SanPhamTraSuaOder;
import com.example.duan1_android.DTO.Shop;
import com.example.duan1_android.DTO.TheLoaiSanPham;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectAllOrder {
    private Context context;
    private ConnectionHelper connectionHelper;
    private Connection connection;

    public SelectAllOrder(Context context) {
        this.context = context;
        connectionHelper = new ConnectionHelper();
        connection = connectionHelper.connectionclass();
    }

    public List<SanPhamCoffeOder> getListSP(){
        List<SanPhamCoffeOder> list = new ArrayList<>();
        try {
            if (connection != null){
                String sql = "select * from sanPham";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    SanPhamCoffeOder sanPham = new SanPhamCoffeOder();
                    sanPham.setIdSP(resultSet.getInt("maSanPham"));
                    sanPham.setChiTietSanPham(resultSet.getString("thongTinChiTiet"));
                    sanPham.setTenSPOder(resultSet.getString("tenSanPham"));
                    sanPham.setGiaSPOder(resultSet.getInt("giaSanPham"));
                    sanPham.setImgSPOder(resultSet.getBytes("anhSanPham"));
                    list.add(sanPham);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public List<Shop> getListShop(){
        List<Shop> list = new ArrayList<>();
        try {
            if (connection != null){
                String sql  = "select * from cuaHang";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    Shop shop = new Shop();
                    shop.setTenShop(resultSet.getString("tenCuaHang"));
                    shop.setDiaChiShop(resultSet.getString("diaChiCuaHang"));
                    shop.setImgShop(resultSet.getBytes("anhCuaHang"));
                    list.add(shop);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public KhachHang getUserPass(String usernam, String password){
        KhachHang khachHang = new KhachHang();
        try {
            if(connection !=null){
                String sql = "select * from khachHang where userKH like '"+usernam+"' and  passKH like '"+password+"'";
                Statement st = connection.createStatement();
                ResultSet rs;
                rs = st.executeQuery(sql);
                while(rs.next()){
                    khachHang.setMaKhachHang(rs.getInt(1));
                    khachHang.setTenKhachHang(rs.getString(2));
                    khachHang.setUserKH(rs.getString(3));
                    khachHang.setPassKH(rs.getString(4));
                    khachHang.setCheckAdmin(rs.getInt(5));
                    khachHang.setSoDienThoai(rs.getString(6));
                    khachHang.setDiaChi(rs.getString(7));

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return khachHang;
    }



    public void insertKH(List<KhachHang> list ){
        for (KhachHang khachHang1: list)
        try {
            if (connection != null){

                String sql = "INSERT INTO khachHang(tenKhachHang, userKH, passKH, checkAdmin, soDienThoai, diaChi)" +
                        " VALUES('" + khachHang1.getTenKhachHang() + "','" + khachHang1.getUserKH() + "','" + khachHang1.getPassKH() + "',0,'" + khachHang1.getSoDienThoai() + "','" + khachHang1.getDiaChi()+
                        "')";
                Statement st = connection.createStatement();
                st.execute(sql);

            }

        }catch (Exception e){

        }

    }

    public List<String> getLsitTheLoai() {
        List<String> list = new ArrayList<>();
        try {
            if(connection !=null){
                Statement st = connection.createStatement();
                String sql ="select * from theLoai";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    list.add(rs.getString(2));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public int getIdTheLoai(String toString) {
        int id = 0;
        try {
            if(connection !=null){
                Statement st = connection.createStatement();
                String sql ="select * from theLoai where tenTheLoai like N'"+toString+"'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    id = rs.getInt(1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;

    }

    public List<String> getLsitSP() {
        List<String> list = new ArrayList<>();
        try {
            if(connection !=null){
                Statement st = connection.createStatement();
                String sql ="select * from sanPham";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    list.add(rs.getString(2));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public int getIdSP(String toString) {
        int id = 0;
        try {
            if(connection !=null){
                Statement st = connection.createStatement();
                String sql ="select * from sanPham where tenSanPham like N'"+toString+"'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    id = rs.getInt(1);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    public String getIdLoaiSP(String toString) {
        String idLoai = "";
        try {
            if(connection !=null){
                Statement st = connection.createStatement();
                String sql ="select * from sanPham where tenSanPham like N'"+toString+"'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    idLoai = rs.getString(5);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return idLoai;
    }

    public String getTenSP(String toString) {
        String ten = "";
        try {
            if(connection !=null){
                Statement st = connection.createStatement();
                String sql ="select * from sanPham where tenSanPham like N'"+toString+"'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    ten = rs.getString(2);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ten;
    }

    public String getGiaSP(String toString) {
        String gia = "";
        try {
            if(connection !=null){
                Statement st = connection.createStatement();
                String sql ="select * from sanPham where tenSanPham like N'"+toString+"'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    gia = rs.getString(4);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return gia;
    }


    public void insertSP( List<SanPhamThem> list ){
        for (SanPhamThem sanPham: list)
            try {
                if (connection != null){
//                    String image = Base64.encodeToString(sanPham.getAnhSanPham() , Base64.DEFAULT);
                    String sql = "" +
                            "INSERT INTO sanPham(tenSanPham, giaSanPham, maTheLoai)" +
                            " VALUES('" + sanPham.getTenSanPham() + "','" + sanPham.getGiaSanPham() + "','" + sanPham.getMaTheLoai() + "')";

                    Statement st = connection.createStatement();
                    st.execute(sql);

                }

            }catch (Exception e){
                e.printStackTrace();

            }
    }

    public void DeleteSP(int s){

        try{
            if (connection != null){
                String sql = "delete from sanPham  where maSanPham = '"+s+"'";
                Statement statement = connection.createStatement();
                statement.execute(sql);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<SanPhamCoffeOder> sreachSP(String textSearch){
        List<SanPhamCoffeOder> list = new ArrayList<>();
        try {
            if (connection != null){
                String sql = "SELECT * FROM sanPham WHERE tenSanPham like N'"+textSearch+"%'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    SanPhamCoffeOder sanPham = new SanPhamCoffeOder();
                    sanPham.setIdSP(resultSet.getInt("maSanPham"));
                    sanPham.setChiTietSanPham(resultSet.getString("thongTinChiTiet"));
                    sanPham.setTenSPOder(resultSet.getString("tenSanPham"));
                    sanPham.setGiaSPOder(resultSet.getInt("giaSanPham"));
                    sanPham.setImgSPOder(resultSet.getBytes("anhSanPham"));
                    list.add(sanPham);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<SanPhamCoffeOder> SP1(){
        List<SanPhamCoffeOder> list = new ArrayList<>();
        try {
            if (connection != null){
                String sql = "SELECT * FROM sanPham WHERE maTheLoai = 1";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    SanPhamCoffeOder sanPham = new SanPhamCoffeOder();
                    sanPham.setIdSP(resultSet.getInt("maSanPham"));
                    sanPham.setChiTietSanPham(resultSet.getString("thongTinChiTiet"));
                    sanPham.setTenSPOder(resultSet.getString("tenSanPham"));
                    sanPham.setGiaSPOder(resultSet.getInt("giaSanPham"));
                    sanPham.setImgSPOder(resultSet.getBytes("anhSanPham"));
                    list.add(sanPham);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<SanPhamCoffeOder> SP2(){
        List<SanPhamCoffeOder> list = new ArrayList<>();
        try {
            if (connection != null){
                String sql = "SELECT * FROM sanPham WHERE maTheLoai = 2";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    SanPhamCoffeOder sanPham = new SanPhamCoffeOder();
                    sanPham.setIdSP(resultSet.getInt("maSanPham"));
                    sanPham.setChiTietSanPham(resultSet.getString("thongTinChiTiet"));
                    sanPham.setTenSPOder(resultSet.getString("tenSanPham"));
                    sanPham.setGiaSPOder(resultSet.getInt("giaSanPham"));
                    sanPham.setImgSPOder(resultSet.getBytes("anhSanPham"));
                    list.add(sanPham);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<SanPhamCoffeOder> SP3(){
        List<SanPhamCoffeOder> list = new ArrayList<>();
        try {
            if (connection != null){
                String sql = "SELECT * FROM sanPham WHERE maTheLoai > 2";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    SanPhamCoffeOder sanPham = new SanPhamCoffeOder();
                    sanPham.setIdSP(resultSet.getInt("maSanPham"));
                    sanPham.setChiTietSanPham(resultSet.getString("thongTinChiTiet"));
                    sanPham.setTenSPOder(resultSet.getString("tenSanPham"));
                    sanPham.setGiaSPOder(resultSet.getInt("giaSanPham"));
                    sanPham.setImgSPOder(resultSet.getBytes("anhSanPham"));
                    list.add(sanPham);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Shop> searchShop(String textSearch){
        List<Shop> list = new ArrayList<Shop>();
        try {
            if (connection != null){
                String sql = "SELECT * FROM cuaHang WHERE tenCuaHang like N'"+textSearch+"%'";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    Shop shop = new Shop();
                    shop.setTenShop(resultSet.getString("tenCuaHang"));
                    shop.setDiaChiShop(resultSet.getString("diaChiCuaHang"));
                    shop.setImgShop(resultSet.getBytes("anhCuaHang"));
                    list.add(shop);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public KhachHang getUserKH(String username){
        KhachHang khachHang = new KhachHang();
        try {
            if(connection !=null){
                String sql = "select * from khachHang where userKH like '"+username+"'";
                Statement st = connection.createStatement();
                ResultSet rs;
                rs = st.executeQuery(sql);
                while(rs.next()){
                    khachHang.setMaKhachHang(rs.getInt(1));
                    khachHang.setTenKhachHang(rs.getString(2));
                    khachHang.setUserKH(rs.getString(3));
                    khachHang.setPassKH(rs.getString(4));
                    khachHang.setCheckAdmin(rs.getInt(5));
                    khachHang.setSoDienThoai(rs.getString(6));
                    khachHang.setDiaChi(rs.getString(7));

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return khachHang;
    }

    public void inserHoaDon( List<HoaDon> list ){
        for (HoaDon hoaDon: list)
            try {
                if (connection != null){

                    String sql = "" +
                            "INSERT INTO phieuMua(gia, ngayMua)" +
                            " VALUES('" + hoaDon.getTongTien() + "','" + hoaDon.getNgayMua() + "')";

                    Statement st = connection.createStatement();
                    st.execute(sql);

                }

            }catch (Exception e){
                e.printStackTrace();

            }
    }

    public ArrayList<HoaDon> getListHoaDon(){
        ArrayList<HoaDon> list = new ArrayList<>();
        try{
            if (connection !=null){
                String sql = "Select * from phieuMua";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setIdHoaDon(resultSet.getInt("maPhieu"));
                    hoaDon.setNgayMua(resultSet.getString("ngayMua"));
                    hoaDon.setTongTien(resultSet.getString("gia"));
                    list.add(hoaDon);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }



}
