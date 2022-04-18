package com.example.duan1_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.DTO.Banner;
import com.example.duan1_android.DTO.HoaDon;
import com.example.duan1_android.DTO.SanPhamTraSuaOder;
import com.example.duan1_android.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterHoaDon extends RecyclerView.Adapter<RecyclerAdapterHoaDon.MyViewHolderHoaDon>{
    private Context context;
    private List<HoaDon> list;

    public RecyclerAdapterHoaDon(Context context, ArrayList<HoaDon> list) {
        this.context = context;
        this.list = list;
    }
    public void setData(List<HoaDon> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolderHoaDon onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_phieumua,parent,false);
         MyViewHolderHoaDon v = new MyViewHolderHoaDon(view);
        return v;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapterHoaDon.MyViewHolderHoaDon holder, int position) {
        HoaDon hoaDon = list.get(position);
        if (hoaDon!= null){
          holder.tvID.setText(String.valueOf(list.get(position).getIdHoaDon()));
          holder.tvTongTien.setText(list.get(position).getTongTien());
          holder.tvNgayThanhToan.setText(list.get(position).getNgayMua());

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolderHoaDon extends RecyclerView.ViewHolder{
    ImageView imgHoaDon;
    TextView tvID, tvTongTien, tvNgayThanhToan;

        public MyViewHolderHoaDon(View itemView) {
            super(itemView);
            imgHoaDon = itemView.findViewById(R.id.imgHoaDon);
            tvID = itemView.findViewById(R.id.tvIDHoaDon);
            tvTongTien = itemView.findViewById(R.id.tvTongTienHoaDon);
            tvNgayThanhToan = itemView.findViewById(R.id.tvNgayThanhToanHoaDon);




        }
    }
}
