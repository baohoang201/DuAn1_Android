package com.example.duan1_android.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.Adapter.RecyclerAdapterBanner;
import com.example.duan1_android.Adapter.RecyclerSanPhamAdapter;
import com.example.duan1_android.CustomView.CustomViewGrid;
import com.example.duan1_android.DTO.Banner;
import com.example.duan1_android.DTO.HoaDon;
import com.example.duan1_android.DTO.ItemGrid;
import com.example.duan1_android.DTO.KhachHang;
import com.example.duan1_android.DTO.SanPham;
import com.example.duan1_android.GioHangActivity;
import com.example.duan1_android.Login.LoginFragment;
import com.example.duan1_android.MainActivity;
import com.example.duan1_android.Other.GioiThieuActivity;
import com.example.duan1_android.Other.PhieuMua;
import com.example.duan1_android.R;
import com.example.duan1_android.SelectAll.SelectAllOrder;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
   private RecyclerView mrecyclerView, bannerRecyler;
   private List<SanPham> list;
   private List<Banner> listBanner;
   private GridView gridView;
   private TextView tvTenTKHome;
   private List<ItemGrid> listItemGrid = new ArrayList<>();
   private SelectAllOrder selectAllOrder;
   private KhachHang khachHang = new KhachHang();
    CustomViewGrid customViewGrid;
    Bitmap iconGiaohang, iconDatHang, iconMangdi;
private MainActivity mainActivity;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.home_fragment,container,false);
        mrecyclerView = (RecyclerView)view.findViewById(R.id.recyclerSP);
        RecyclerSanPhamAdapter recyclerSanPhamAdapter = new RecyclerSanPhamAdapter(getContext(),list);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mrecyclerView.setAdapter(recyclerSanPhamAdapter);

        bannerRecyler = (RecyclerView)view.findViewById(R.id.recyclerBanner);
        RecyclerAdapterBanner recyclerAdapterBanner = new RecyclerAdapterBanner(getContext(), (ArrayList<Banner>) listBanner);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        bannerRecyler.setLayoutManager(linearLayoutManager);
        bannerRecyler.setAdapter(recyclerAdapterBanner);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(bannerRecyler);

        gridView = (GridView)view.findViewById(R.id.gridBanner);

        customViewGrid = new CustomViewGrid(getContext(),R.layout.row_img, (ArrayList<ItemGrid>) listItemGrid);
        gridView.setAdapter(customViewGrid);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==0){
                    Intent intent = new Intent(getActivity(), GioHangActivity.class);
                    startActivity(intent);
                }else if (position ==1){
                    Intent intent = new Intent(getActivity(), PhieuMua.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getActivity(), GioiThieuActivity.class);
                    startActivity(intent);
                }
            }
        });


        tvTenTKHome = view.findViewById(R.id.tvTenTKHome);

        mainActivity = (MainActivity) getActivity();
        initUI();

       return view;
    }

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.add(new SanPham("Trà matcha","100.000đ",R.drawable.tramatcha));
        list.add(new SanPham("Trà đào","50.000đ",R.drawable.trdao));
        list.add(new SanPham("Trà sữa","30.000đ",R.drawable.trasua));
        list.add(new SanPham("Cafe đen","100.000đ",R.drawable.cafe));


        listBanner = new ArrayList<>();
        listBanner.add(new Banner(R.drawable.banner1));
        listBanner.add(new Banner(R.drawable.banner2));
        listBanner.add(new Banner(R.drawable.banner3));


        //
        iconDatHang = BitmapFactory.decodeResource(this.getResources(),R.drawable.hoadon_icon);
        iconGiaohang = BitmapFactory.decodeResource(this.getResources(),R.drawable.giohang_icon);
        iconMangdi = BitmapFactory.decodeResource(this.getResources(),R.drawable.star3);

        listItemGrid.add(new ItemGrid(iconGiaohang,"Giỏ hàng"));
        listItemGrid.add(new ItemGrid(iconDatHang,"Hóa đơn"));
        listItemGrid.add(new ItemGrid(iconMangdi,"Giới thiệu"));



    }

    public void initUI(){
        String s = mainActivity.getMsetChao();
        System.out.println(s);
        tvTenTKHome.setText(mainActivity.getMsetChao());
    }
}
