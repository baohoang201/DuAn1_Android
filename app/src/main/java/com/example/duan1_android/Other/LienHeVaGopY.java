package com.example.duan1_android.Other;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.duan1_android.Adapter.AdapterHoTro;
import com.example.duan1_android.Adapter.AdapterLienHe;
import com.example.duan1_android.R;

public class LienHeVaGopY extends AppCompatActivity {
    private ListView lvLienHe;
    Toolbar toolbar;
    int anhLienHe[] = {R.drawable.ic_baseline_phone_24,R.drawable.ic_baseline_email_24,R.drawable.ic_baseline_report_24, };
    String LienHe[] = {"012345678", "hi@theCoffeeShop.com", "Gửi ý kiến và phản hồi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lien_he_va_gop_y);
        lvLienHe = (ListView) findViewById(R.id.lvLienHe);
        Adapter adapterLV = new AdapterLienHe(this,anhLienHe,LienHe);
        lvLienHe.setAdapter((ListAdapter) adapterLV);
        toolbar = findViewById(R.id.toolbarlienhe);
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