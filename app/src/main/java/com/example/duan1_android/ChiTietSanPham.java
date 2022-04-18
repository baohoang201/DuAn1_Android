package com.example.duan1_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.duan1_android.DTO.GioHang;
import com.example.duan1_android.DTO.SanPhamBanhOder;
import com.example.duan1_android.DTO.SanPhamCoffeOder;
import com.example.duan1_android.Fragment.HomeFragment;
import com.example.duan1_android.Fragment.OderFragment;

import java.text.DecimalFormat;

public class ChiTietSanPham extends AppCompatActivity {
    Toolbar toolbar;
    ImageView imgchitiet;
    TextView txtten,txtgia,txtmota;
    Spinner spinner;
    Button btnmua;
    int id;
    String Tensanpham;
    int Giasanpham;
    byte[] Hinhanhsanpham;
    String Motasanpham;
    int IDSanpham;
    void Anhxa()
    {
        toolbar = findViewById(R.id.toolbarchitietsanpham);
        imgchitiet = findViewById(R.id.imageviewchitietsanpham);
        txtten = findViewById(R.id.textviewtenchitietsanpham);
        txtgia = findViewById(R.id.textviewgiachitietsanpham);
        txtmota = findViewById(R.id.textviewmotachitietsanpham);
        spinner = findViewById(R.id.spinner);
        btnmua = findViewById(R.id.buttondatmua);
    }
    void ActionToolbar()
    {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    void EventSpinner()
    {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter =
                new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,soluong);
        spinner.setAdapter(arrayAdapter);
    }

    void GetInfomation()
    {

        //lay thong tin truyen sang
       SanPhamCoffeOder sanpham = (SanPhamCoffeOder)getIntent().getSerializableExtra("thongtinsanpham");
        id = sanpham.getIdSP();
        Tensanpham = sanpham.getTenSPOder();
        Giasanpham = sanpham.getGiaSPOder();
        Hinhanhsanpham = sanpham.getImgSPOder();
        Motasanpham = sanpham.getChiTietSanPham();

        //dua thong tin vao chi tiet
        txtten.setText(Tensanpham);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgia.setText(decimalFormat.format(Giasanpham)+" VND");
        txtmota.setText(Motasanpham);
        //anhr
        imgchitiet.setImageBitmap(BitmapFactory.decodeByteArray(Hinhanhsanpham,0,sanpham.getImgSPOder().length));
    }


    void  EventButton()//xu ly su kien click button
    {
        btnmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(OderFragment.manggiohang.size()>0)//gio hang khong rong
                {
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());//lay so luong trong spinner
                    boolean tontaimahang = false;
                    for(int i=0;i<OderFragment.manggiohang.size();i++)//dem xem trong gio hang co gi
                    {
                        if(OderFragment.manggiohang.get(i).getIdSP()==id)//neu co hang ta muon mua them
                        {
                            //so luong = so luong cu + moi
                            OderFragment.manggiohang.get(i).setSoLuongSP(OderFragment.manggiohang.get(i).getSoLuongSP()+sl);
                            if(OderFragment.manggiohang.get(i).getSoLuongSP()>=10)//neu so luong sp >10, giu nguyen 10
                            {
                                OderFragment.manggiohang.get(i).setSoLuongSP(10);
                            }
                            //tinh tien = Don gia * so luong
                            OderFragment.manggiohang.get(i).setGiaSP(Giasanpham*OderFragment.manggiohang.get(i).getSoLuongSP());
                            tontaimahang  =true;
                        }
                    }
                    if(tontaimahang==false)//truong hop co hang, nhung ma hang muon mua them khong ton tai
                    {
                        int sl1 = Integer.parseInt(spinner.getSelectedItem().toString());//lay so luong trong spinner
                        //tinh tien
                        int Tien2 = sl1*Giasanpham;
                        //them vao mang gio hang
                        OderFragment.manggiohang.add(new GioHang(Tensanpham,Tien2,Hinhanhsanpham,sl1,id));
                    }
                }
                else //gio hang rong
                {
                    int sl2 = Integer.parseInt(spinner.getSelectedItem().toString());//lay so luong trong spinner
                    //tinh tien
                    int Tien2 = sl2*Giasanpham;
                    //them vao mang gio hang
                    OderFragment.manggiohang.add(new GioHang(Tensanpham,Tien2,Hinhanhsanpham,sl2,id));
                }
                Intent intent = new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        Anhxa();//findbyviewId
        ActionToolbar();//xu ly su kien khi click vao dien thoai
        GetInfomation();//lay thong tin chuyen sang
//        GetInfomationBanh();
        EventSpinner();//chon so luong
        EventButton();//them san pham
//
    }
}