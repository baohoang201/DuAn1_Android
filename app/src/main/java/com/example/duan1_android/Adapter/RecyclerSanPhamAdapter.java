package com.example.duan1_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.DTO.SanPham;
import com.example.duan1_android.R;

import java.util.List;

public class RecyclerSanPhamAdapter extends RecyclerView.Adapter<RecyclerSanPhamAdapter.MyViewHolder> {
    Context context;
    List<SanPham> list;

    public RecyclerSanPhamAdapter(Context context, List<SanPham> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_recyler_sanpham,parent,false);

        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerSanPhamAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getTenSp());
        holder.tvGia.setText(list.get(position).getGiaSP());
        holder.img.setImageResource(list.get(position).getImgSP());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvGia;

        private ImageView img;
        public MyViewHolder( View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.txtTenSP);
            tvGia = (TextView) itemView.findViewById(R.id.tvGia);
            img = (ImageView) itemView.findViewById(R.id.imgSP);

        }
    }
}
