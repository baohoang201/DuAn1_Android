package com.example.duan1_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_android.Connect.ConnectionHelper;
import com.example.duan1_android.SelectAll.SelectAllOrder;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SuaSanPham extends AppCompatActivity {
    private Spinner spinner;
    private EditText tvTenSP;
    private EditText tvGiaSP;
    private EditText tvMaLoaiSP;
    private AppCompatButton btnDongY;
    private AppCompatButton btnHuy;
    private SelectAllOrder selectAllOrder;
    private int idSanPham;
    private String tenSP, idMaLoaiSP, giaSP;
    private ConnectionHelper connectionHelper;
    private Connection connection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sua_san_pham);
        spinner = (Spinner) findViewById(R.id.spinner);
        tvTenSP = (EditText) findViewById(R.id.tvTenSP);
        tvGiaSP = (EditText) findViewById(R.id.tvGiaSP);
        tvMaLoaiSP = (EditText) findViewById(R.id.tvMaLoaiSP);
        btnDongY = (AppCompatButton) findViewById(R.id.btnDongY);
        btnHuy = (AppCompatButton) findViewById(R.id.btnHuy);
        selectAllOrder = new SelectAllOrder(this);
        SpinnerSP();

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SuaSanPham.this, "Bạn không sửa sản phẩm", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });

        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditSP();
                Toast.makeText(SuaSanPham.this, "Bạn sửa sản phẩm thành công", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }
    public void SpinnerSP(){
        ArrayAdapter<String> adapte = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , selectAllOrder.getLsitSP());
        spinner.setAdapter(adapte);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idSanPham = selectAllOrder.getIdSP(spinner.getSelectedItem().toString());
                tenSP = selectAllOrder.getTenSP(spinner.getSelectedItem().toString());
                giaSP = selectAllOrder.getGiaSP(spinner.getSelectedItem().toString());
                idMaLoaiSP = selectAllOrder.getIdLoaiSP(spinner.getSelectedItem().toString());


                tvTenSP.setText(tenSP);
                tvGiaSP.setText(giaSP);
                tvMaLoaiSP.setText(idMaLoaiSP);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void EditSP(){
        connectionHelper = new ConnectionHelper();
        connection = connectionHelper.connectionclass();
        idSanPham = selectAllOrder.getIdSP(spinner.getSelectedItem().toString());
        if(connection != null){
            try {
                Statement statement = connection.createStatement();
                String sql = "Update sanPham set tenSanPham = '"+tvTenSP.getText().toString()+"',giaSanPham = '"+tvGiaSP.getText().toString()+"',maTheLoai = '" + tvMaLoaiSP.getText().toString()+"' where maSanPham ='"+idSanPham+ "'";
                statement.execute(sql);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}