package com.example.duan1_android.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.duan1_android.Adapter.AdapterHoTro;
import com.example.duan1_android.Adapter.AdapterTaiKhoan;
import com.example.duan1_android.Connect.ConnectionHelper;
import com.example.duan1_android.DTO.KhachHang;
import com.example.duan1_android.GioHangActivity;
import com.example.duan1_android.Login.LoginActivity;
import com.example.duan1_android.Other.DieuKhoanActivity;
import com.example.duan1_android.Other.GioiThieuActivity;
import com.example.duan1_android.Other.LienHeVaGopY;
import com.example.duan1_android.Other.PhieuMua;
import com.example.duan1_android.R;
import com.example.duan1_android.SelectAll.SelectAllOrder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OtherFragment extends Fragment {
    CardView cardView, cardDieuKhoan, cardHoaDon;
    Connection connection;
    ConnectionHelper connectionHelper;
    SelectAllOrder selectAllOrder;
    ListView listViewHoTro , listViewTaiKhoan;
    int imgHT[]= {R.drawable.star,R.drawable.feedback};
    String tenHT[] = {"Giới thiệu","Liên hệ và góp ý"};


    int imgTK[]= {R.drawable.person,R.drawable.setting,R.drawable.key2,R.drawable.logout};
    String tenTK[] = {"Thông tin tài khoản","Nâng cấp lên Admin","Đổi mật khẩu","Đăng xuất"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.other_fragment,container,false);
        listViewTaiKhoan = view.findViewById(R.id.listview_taikhoan);
        listViewHoTro =view.findViewById(R.id.listview_hotro);
        cardView = view.findViewById(R.id.cvLichSu);
        cardDieuKhoan = view.findViewById(R.id.cardDieuKhoan);
        cardHoaDon = view.findViewById(R.id.cardHoaDon);
        Adapter adapterHT = new AdapterHoTro(getActivity(),imgHT,tenHT);
        listViewHoTro.setAdapter((ListAdapter) adapterHT);
        selectAllOrder = new SelectAllOrder(getContext());

        Adapter adapterTK = new AdapterTaiKhoan(getActivity(),imgTK,tenTK);
        listViewTaiKhoan.setAdapter((ListAdapter) adapterTK);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GioHangActivity.class);
                startActivity(intent);
            }
        });
        cardDieuKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DieuKhoanActivity.class);
                startActivity(intent);

            }
        });
        cardHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PhieuMua.class);
                startActivity(intent);
            }
        });



        listViewHoTro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(getActivity(), GioiThieuActivity.class);
                    startActivity(intent);
                }else if (position ==1){
                    Intent intent = new Intent(getActivity(), LienHeVaGopY.class);
                    startActivity(intent);
                }
            }
        });


        listViewTaiKhoan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                }else if(position ==1){
                        openAdminDialog();
                }else{
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        KhachHang khachHang = (KhachHang) this.getActivity().getIntent().getSerializableExtra("khachhang");
        listViewTaiKhoan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                    openThongTinChiTiet();
                }else if(position ==1){
                    if (khachHang.isCheckAdmin() ==1){
                        Toast.makeText(getContext(),"Bạn đã là admin",Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                        openAdminDialog();
                    }

                }else if (position ==2){
                    openChangePassDialog();
                }
                else{
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;

    }
    private void openAdminDialog() {
        Dialog dialog = new Dialog(getContext(), R.style.Theme_AppCompat_Dialog_Alert);
        dialog.setContentView(R.layout.nangcap_admin_dialog);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        KhachHang khachHang = (KhachHang) this.getActivity().getIntent().getSerializableExtra("khachhang");


        ImageView imgClose;
        AppCompatButton btnAdmin;

        imgClose = (ImageView) dialog.findViewById(R.id.imgClose);
        btnAdmin = (AppCompatButton) dialog.findViewById(R.id.btnAdmin);



        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   ConnectionHelper connectionHelper = new ConnectionHelper();
                   Connection connection = connectionHelper.connectionclass();
                   try {
                       String sql = "update khachHang set checkAdmin = 1 where userKH = N'"+khachHang.getUserKH()+"'";
                       Statement statement = connection.createStatement();
                       statement.executeUpdate(sql);
                   }catch (Exception e){
                       e.printStackTrace();
                   }
                   Intent intent = new Intent(getActivity(), LoginActivity.class);
                   startActivity(intent);




            }
        });

        dialog.show();
    }

    private void openThongTinChiTiet(){
        Dialog dialog = new Dialog(getContext(), R.style.Theme_AppCompat_Dialog_Alert);
        dialog.setContentView(R.layout.thongtin_chitiet_dialog);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        ImageView imgClose = (ImageView) dialog.findViewById(R.id.imgClose);
        TextView tvTen = (TextView) dialog.findViewById(R.id.tvTen);
        TextView tvUser = (TextView) dialog.findViewById(R.id.tvUser);
        TextView tvPhone = (TextView) dialog.findViewById(R.id.tvPhone);
        TextView tvDiaChi = (TextView) dialog.findViewById(R.id.tvDiaChi);

        KhachHang khachHang = (KhachHang) this.getActivity().getIntent().getSerializableExtra("khachhang");
        tvTen.setText(khachHang.getTenKhachHang());
        tvUser.setText(khachHang.getUserKH());
        tvPhone.setText(khachHang.getSoDienThoai());
        tvDiaChi.setText(khachHang.getDiaChi());

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getActivity(), "Thank You", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();

    }

    private void openChangePassDialog(){
        Dialog dialog = new Dialog(getContext(), R.style.Theme_AppCompat_Dialog_Alert);
        dialog.setContentView(R.layout.changepass_dialog);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        ImageView imgClose = (ImageView) dialog.findViewById(R.id.imgCloseChange);
        TextView edMKCu = (TextView) dialog.findViewById(R.id.edMatKhauCu);
        TextView edMKMoi = (TextView) dialog.findViewById(R.id.edMatKhauMoi);
        TextView edNhapLaiMK = (TextView) dialog.findViewById(R.id.edNhapLaiMKChange);
        Button btnDoiMK = (Button) dialog.findViewById(R.id.btnDoiMK);
        KhachHang khachHang = (KhachHang) this.getActivity().getIntent().getSerializableExtra("khachhang");
        String userKH = khachHang.getUserKH();
        String mkMoi = edMKMoi.getText().toString();
        String nhapLaiMK = edNhapLaiMK.getText().toString();

        btnDoiMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!(edMKCu.getText().toString().equals(khachHang.getPassKH() ))){
                    Toast.makeText(getContext(),"Mật khẩu cũ không đúng",Toast.LENGTH_SHORT).show();
                    return;

                }else if ( edMKCu.getText().toString().length() ==0 || edMKMoi.getText().toString().length() == 0 || edNhapLaiMK.getText().toString().length() == 0){
                    Toast.makeText(getContext(),"Bạn phải điền đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                    return;

                }else if ( !edNhapLaiMK.getText().toString().equals(edMKMoi.getText().toString())){
                    Toast.makeText(getContext(),"Mật khẩu không trùng khớp",Toast.LENGTH_SHORT).show();
                    return;

                }else if ( edMKMoi.getText().toString().length()<10){
                    Toast.makeText(getContext(),"Mật khẩu mới phải lớn hơn 10 kí tự",Toast.LENGTH_SHORT).show();
                    return;

                }else {

                    connectionHelper = new ConnectionHelper();
                    connection = connectionHelper.connectionclass();
                    if(connection != null){
                        try {
                            Statement statement = connection.createStatement();
                            String sql = "Update khachHang set passKH = '"+edNhapLaiMK.getText().toString()+"' where userKH ='"+userKH+ "'";
                            statement.executeUpdate(sql);

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                    Toast.makeText(getContext(),"Đổi mật khẩu thành công",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();

                }

            }
        });


        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();



    }




}
