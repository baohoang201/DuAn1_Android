package com.example.duan1_android.Login;

import android.content.Intent;
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


import com.example.duan1_android.DTO.KhachHang;
import com.example.duan1_android.MainActivity;
import com.example.duan1_android.R;
import com.example.duan1_android.SelectAll.SelectAllOrder;

import org.jetbrains.annotations.NotNull;

public class LoginFragment extends Fragment {
    EditText edTenDangNhap, edMatKhau;
    Button btnLog;
    float v =0;
    private SelectAllOrder mSelectAllOrder;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_login,container,false);

        edTenDangNhap = root.findViewById(R.id.edTenDangNhap);
        edMatKhau = root.findViewById(R.id.edMatKhau);
        btnLog = root.findViewById(R.id.btnLog);

        edTenDangNhap.setTranslationX(800);
        edMatKhau.setTranslationX(800);
        btnLog.setTranslationX(800);

        edTenDangNhap.setAlpha(v);
        edMatKhau.setAlpha(v);
        btnLog.setAlpha(v);


        edTenDangNhap.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        edMatKhau.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        btnLog.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

        mSelectAllOrder = new SelectAllOrder(getActivity());
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhachHang khachHang = mSelectAllOrder.getUserPass(edTenDangNhap.getText().toString() , edMatKhau.getText().toString());
                if (checkLogin()>0){
                    if(edTenDangNhap.getText().toString().equals(khachHang.getUserKH()) &&edMatKhau.getText().toString().equals(khachHang.getPassKH()) ){
                        Intent intent = new Intent(getActivity() , MainActivity.class);
                        intent.putExtra("khachhang" , khachHang);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getActivity(), "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }

            }
        });

        return root;
    }

    public int checkLogin(){
        int check = 1 ;
        if (edTenDangNhap.getText().toString().isEmpty() || edTenDangNhap.getText().toString().length()>30){
            Toast.makeText(getContext(),"Chưa nhập tên đăng nhập hoặc quá 30 kí tự",Toast.LENGTH_SHORT).show();
            check = -1;
        }else if (edMatKhau.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"Chưa nhập mật khẩu",Toast.LENGTH_SHORT).show();
            check = -1;
        }else if (edTenDangNhap.getText().toString().isEmpty() && edMatKhau.getText().toString().isEmpty()){
            Toast.makeText(getContext(),"Chưa nhập tài khoản và mật khẩu",Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
}
