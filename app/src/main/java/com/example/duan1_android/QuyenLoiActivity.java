package com.example.duan1_android;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1_android.Adapter.RankAdapter;
import com.example.duan1_android.DTO.Rank;
import com.example.duan1_android.Fragment.OfferFragment;

import java.util.ArrayList;

public class QuyenLoiActivity extends AppCompatActivity  {
    ImageView imgback;
    ListView listView;
    ArrayList<Rank> arrayList;
    RankAdapter rankAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quyen_loi);
        listView = findViewById(R.id.listview_rank);
        imgback = findViewById(R.id.icBack);
        arrayList = new ArrayList<>();
        arrayList.add(new Rank("Miễn phí upsize", R.drawable.iconb));
        arrayList.add(new Rank("Giảm 5% giá trị hóa đơn", R.drawable.iconv));
        arrayList.add(new Rank("Giảm 10% giá trị hóa đơn", R.drawable.iconbk));
        arrayList.add(new Rank("Tặng một đồ uống bất kì", R.drawable.iconkc));
        arrayList.add(new Rank("Tặng 1 phần bánh và đồ uống bất kì", R.drawable.icontd));
        rankAdapter = new RankAdapter(QuyenLoiActivity.this, R.layout.item_lv_uudai,arrayList);
        listView.setAdapter(rankAdapter);


        imgback.setOnClickListener(v->{
            this.onBackPressed();
        });

    }


    @Override
    public boolean onSupportNavigateUp() {
        this.onBackPressed();
        return super.onSupportNavigateUp();
    }
}