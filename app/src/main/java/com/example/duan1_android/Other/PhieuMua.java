package com.example.duan1_android.Other;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.duan1_android.Adapter.RecyclerAdapterHoaDon;
import com.example.duan1_android.DTO.HoaDon;
import com.example.duan1_android.R;
import com.example.duan1_android.SelectAll.SelectAllOrder;

import java.util.ArrayList;
import java.util.List;

public class PhieuMua extends AppCompatActivity {
      RecyclerView recyclerHoaDon;
      SelectAllOrder selectAllOrder;
      ArrayList<HoaDon> list;
      RecyclerAdapterHoaDon recyclerAdapterHoaDon;
      Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phiue_mua);
        recyclerHoaDon = (RecyclerView)findViewById(R.id.recyclerPhieuMua);

        selectAllOrder = new SelectAllOrder(getBaseContext());
        list = new ArrayList<>();
        list = selectAllOrder.getListHoaDon();
        recyclerHoaDon.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));
        recyclerAdapterHoaDon = new RecyclerAdapterHoaDon(PhieuMua.this,list);
        recyclerAdapterHoaDon.setData(list);
        recyclerHoaDon.setAdapter(recyclerAdapterHoaDon);
        toolbar = findViewById(R.id.toolbarhoadon);
        ActionToolbar();




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
}