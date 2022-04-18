package com.example.duan1_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_android.Adapter.GioHangAdapter;
import com.example.duan1_android.DTO.GioHang;
import com.example.duan1_android.DTO.HoaDon;
import com.example.duan1_android.DTO.SanPhamThem;
import com.example.duan1_android.Fragment.HomeFragment;
import com.example.duan1_android.Fragment.OderFragment;
import com.example.duan1_android.SelectAll.SelectAllOrder;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GioHangActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    TextView txtThongbao;
    static TextView txtTongTien;
    Button btnThanhToan,btnTiepTucMuaHang;
    GioHangAdapter giohangAdapter;
    SelectAllOrder selectAllOrder;
    List<HoaDon> hoaDonList;
    ////

    void Anhxa()
    {
        listView = findViewById(R.id.listviewgiohang);
        txtThongbao = findViewById(R.id.textviewthongbao);
        txtTongTien = findViewById(R.id.textviewtongtien);
        btnThanhToan = findViewById(R.id.buttonthanhtoangiohang);
        btnTiepTucMuaHang = findViewById(R.id.buttontieptucmuahang);
        toolbar = findViewById(R.id.toolbargiohang);
        giohangAdapter = new GioHangAdapter(GioHangActivity.this, OderFragment.manggiohang);
        listView.setAdapter(giohangAdapter);
        selectAllOrder = new SelectAllOrder(getBaseContext());
        hoaDonList = new ArrayList<>();
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

    void UpdateTongTien()
    {
        long tongtien=0;
        for(int i=0;i<OderFragment.manggiohang.size();i++)
        {
            tongtien += OderFragment.manggiohang.get(i).getGiaSP();//cong don tien
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTongTien.setText(decimalFormat.format(tongtien)+" VND");
    }

    void CLickItemListview()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(OderFragment.manggiohang.size()<1)
                {
                    txtThongbao.setVisibility(View.VISIBLE);
                }
                else
                {
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(GioHangActivity.this, R.style.Theme_Design_BottomSheetDialog);
                    View bottomSheetView = LayoutInflater.from(GioHangActivity.this).inflate(
                            R.layout.bottom_sheet2,
                            (LinearLayout) bottomSheetDialog.findViewById(R.id.bottomSheetContainer2));
                    TextView txtconfirm = (TextView) bottomSheetView.findViewById(R.id.txt_Huy2);
                    TextView txtHuy = (TextView) bottomSheetView.findViewById(R.id.txt_XoaSP2);

                    txtHuy.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            OderFragment.manggiohang.remove(i);//xoa hang trong gio hang
                            UpdateTongTien();
                            giohangAdapter.notifyDataSetChanged();
                            bottomSheetDialog.dismiss();

                        }
                    });
                    txtconfirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bottomSheetDialog.dismiss();
                        }
                    });
                    bottomSheetDialog.setContentView(bottomSheetView);
                    bottomSheetDialog.show();




                    //cap nhat lai tong tien
                    UpdateTongTien();
                    if(OderFragment.manggiohang.size()<1)
                    {
                        txtThongbao.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        txtThongbao.setVisibility(View.INVISIBLE);
                        giohangAdapter.notifyDataSetChanged();
                        UpdateTongTien();
                    }
                }

            }
        });
    }

    void ClickButton()
    {

        btnTiepTucMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(OderFragment.manggiohang.size()>0)
                {
                    Calendar calendar = Calendar.getInstance();
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setTongTien(txtTongTien.getText().toString());
                    hoaDon.setNgayMua(DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime()));
                    hoaDonList.add(hoaDon);
                    selectAllOrder.inserHoaDon(hoaDonList);
                    OderFragment.manggiohang.clear();
                    giohangAdapter.notifyDataSetChanged();

                    Toast.makeText(getBaseContext(), "Thanh toán thành công", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Khong co gi trong gio hang",Toast.LENGTH_SHORT).show();
                }

            }
        });
        UpdateTongTien();
    }

    void  CheckData()
    {
        if(OderFragment.manggiohang.size()<=0)
        {
            giohangAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.VISIBLE);
            listView.setVisibility(View.INVISIBLE);
        }
        else
        {
            giohangAdapter.notifyDataSetChanged();
            txtThongbao.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.VISIBLE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        Anhxa();
        ActionToolbar();//xu ly su kien
        CLickItemListview();//xu ly su kien
        ClickButton();//xu ly su kien khi click button
        UpdateTongTien();//cap nhat tong tien
        CheckData();//kiem tra gio hang
    }
}