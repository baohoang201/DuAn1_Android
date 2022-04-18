package com.example.duan1_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan1_android.SelectAll.SelectAllOrder;

public class XoaSanPham extends AppCompatActivity {
    private Spinner spinner;
    private TextView tvTenSP;
    private TextView tvGiaSP;
    private AppCompatButton btnDongY;
    private AppCompatButton btnHuy;
    private SelectAllOrder selectAllOrder;
    private int idSanPham;
    private String tenSP, giaSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xoa_san_pham);
        spinner = (Spinner) findViewById(R.id.spinner);
        tvTenSP = (TextView) findViewById(R.id.tvTenSP);
        tvGiaSP = (TextView) findViewById(R.id.tvGiaSP);
        btnDongY = (AppCompatButton) findViewById(R.id.btnDongY);
        btnHuy = (AppCompatButton) findViewById(R.id.btnHuy);
        selectAllOrder = new SelectAllOrder(this);
        SpinnerSP();

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(XoaSanPham.this, "Bạn không xóa sản phẩm", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });

        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idSanPham = selectAllOrder.getIdSP(spinner.getSelectedItem().toString());
                selectAllOrder.DeleteSP(idSanPham);
                Toast.makeText(XoaSanPham.this, "Bạn đã xóa sản phẩm", Toast.LENGTH_SHORT).show();
                onResume();
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

                tvTenSP.setText(tenSP);
                tvGiaSP.setText(giaSP + " VND");

                Toast.makeText(XoaSanPham.this, "id SP là: " +idSanPham, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}