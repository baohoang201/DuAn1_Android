package com.example.duan1_android.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.Adapter.RecyclerShopAdapter;
import com.example.duan1_android.DTO.Shop;
import com.example.duan1_android.Maps.MapsActivity;
import com.example.duan1_android.R;
import com.example.duan1_android.SelectAll.SelectAllOrder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {
    private RecyclerView recyclerShop;
    private List<Shop> list;
    private Context context;
    private RecyclerShopAdapter recyclerShopAdapter;
    private SelectAllOrder selectAllOrder;
    private EditText edSearch;
    private TextView tvMap;
    private TextInputEditText edSearchShop;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.shop_fragment,container,false);
        recyclerShop = (RecyclerView)view.findViewById(R.id.recyclerShop);
        edSearchShop = (TextInputEditText) view.findViewById(R.id.edSearchShop);
        selectAllOrder = new SelectAllOrder(context);
        list = new ArrayList<>();
        recyclerShopAdapter = new RecyclerShopAdapter(context);
        list = selectAllOrder.getListShop();
        recyclerShop.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerShopAdapter.setData(list);
        recyclerShop.setAdapter(recyclerShopAdapter);

       tvMap = view.findViewById(R.id.tvMapShop);
       tvMap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent((getActivity()), MapsActivity.class);
               startActivity(intent);
           }
       });

       edSearchShop.setOnEditorActionListener(new TextView.OnEditorActionListener() {
           @Override
           public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
               if(edSearchShop.getText().toString().isEmpty()){
                   list = new ArrayList<>();
                   recyclerShopAdapter = new RecyclerShopAdapter(context);
                   list = selectAllOrder.getListShop();
                   recyclerShop.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                   recyclerShopAdapter.setData(list);
                   recyclerShop.setAdapter(recyclerShopAdapter);
               }else{
                   list.clear();
                   list = selectAllOrder.searchShop(edSearchShop.getText().toString());
                   recyclerShopAdapter = new RecyclerShopAdapter(context);
                   recyclerShop.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                   recyclerShopAdapter.setData(list);
                   recyclerShop.setAdapter(recyclerShopAdapter);
               }
               return false;
           }
       });

       return view;
    }



    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
