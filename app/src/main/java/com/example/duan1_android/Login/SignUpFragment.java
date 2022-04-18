package com.example.duan1_android.Login;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.duan1_android.Connect.ConnectionHelper;
import com.example.duan1_android.DTO.KhachHang;
import com.example.duan1_android.R;
import com.example.duan1_android.SelectAll.SelectAllOrder;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SignUpFragment extends Fragment {
    EditText  edHoTen,edTenDangNhap, edMatKhau,edNhapLaiMK, edSDT, edDiaChi;
    Button btnSU;
    float v =0;
    ConnectionHelper con;
    Statement stmt;
    List<KhachHang> list;
    SelectAllOrder selectAllOrder;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_sign_up,container,false);
        edHoTen = root.findViewById(R.id.edHoTen);
        edTenDangNhap = root.findViewById(R.id.edTenDangNhap);
        edMatKhau = root.findViewById(R.id.edMatKhau);
        edNhapLaiMK = root.findViewById(R.id.edNhapLaiMK);
        edDiaChi = root.findViewById(R.id.edDiaChi);
        edSDT = root.findViewById(R.id.edSoDienThoai);

        btnSU = root.findViewById(R.id.btnSignUp);
        edHoTen.setTranslationX(800);
        edTenDangNhap.setTranslationX(800);
        edMatKhau.setTranslationX(800);
        edNhapLaiMK.setTranslationX(800);
        btnSU.setTranslationX(800);
        edDiaChi.setTranslationX(800);
        edSDT.setTranslationX(800);


        edHoTen.setAlpha(v);
        edTenDangNhap.setAlpha(v);
        edMatKhau.setAlpha(v);
        edNhapLaiMK.setAlpha(v);
        btnSU.setAlpha(v);
        edDiaChi.setAlpha(v);
        edSDT.setAlpha(v);


        edHoTen.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        edTenDangNhap.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        edMatKhau.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();
        edNhapLaiMK.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(900).start();
        btnSU.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1100).start();
        edSDT.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1100).start();
        edDiaChi.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(1100).start();
        selectAllOrder = new SelectAllOrder(getContext());

        btnSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = new ArrayList<>();

                if (checkSignUp()>0){
                    KhachHang khachHang = new KhachHang();
                    khachHang.setTenKhachHang(edHoTen.getText().toString());
                    khachHang.setUserKH(edTenDangNhap.getText().toString());
                    khachHang.setDiaChi(edDiaChi.getText().toString());
                    khachHang.setPassKH(edMatKhau.getText().toString());
                    khachHang.setSoDienThoai(edSDT.getText().toString());
                    list.add(khachHang);

                    selectAllOrder.insertKH(list);
                    Toast.makeText(getActivity(),"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                    edSDT.setText("");
                    edHoTen.setText("");
                    edMatKhau.setText("");
                    edNhapLaiMK.setText("");
                    edTenDangNhap.setText("");
                    edDiaChi.setText("");


                }



            }
        });

        return root;
    }


    public int checkSignUp(){
        int check = 1;
        if (edHoTen.getText().toString().isEmpty() || edTenDangNhap.getText().toString().isEmpty() ||  edMatKhau.getText().toString().isEmpty() ||
                edNhapLaiMK.getText().toString().isEmpty() ||  edSDT.getText().toString().isEmpty() || edDiaChi.getText().toString().isEmpty())
        {

            Toast.makeText(getActivity(),"Bạn phải điền đầy đủ thông tin",Toast.LENGTH_SHORT).show();
            check = -1;

        }else if (edTenDangNhap.getText().toString().length()<5){

            Toast.makeText(getActivity(),"Username ngắn hơn 5 kí tự, mời nhập lại",Toast.LENGTH_SHORT).show();
            check = -1;
        }else if (edTenDangNhap.getText().toString().length()>20){
            Toast.makeText(getActivity(),"Username không được quá 20 kí tự",Toast.LENGTH_SHORT).show();
            check= -1;
        }else if (!edMatKhau.getText().toString().equals(edMatKhau.getText().toString())){

            Toast.makeText(getActivity(),"Mật khẩu không trùng khớp",Toast.LENGTH_SHORT).show();
            check= -1;
        }else if (edMatKhau.getText().toString().length()<10){

            Toast.makeText(getActivity(),"Mật khẩu ngắn hơn 10 kí tự, mời nhập lại",Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }


}
