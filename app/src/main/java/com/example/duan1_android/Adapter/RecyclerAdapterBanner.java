package com.example.duan1_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.DTO.Banner;
import com.example.duan1_android.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterBanner extends RecyclerView.Adapter<RecyclerAdapterBanner.MyViewHolderBanner>{
    private Context context;
    private List<Banner> list;

    public RecyclerAdapterBanner(Context context, ArrayList<Banner> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolderBanner onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_recycler,parent,false);
         MyViewHolderBanner v = new MyViewHolderBanner(view);
        return v;
    }

    @Override
    public void onBindViewHolder( RecyclerAdapterBanner.MyViewHolderBanner holder, int position) {
        holder.img.setImageResource(list.get(position).getImgBanner());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolderBanner extends RecyclerView.ViewHolder{
    ImageFilterView img;


        public MyViewHolderBanner(View itemView) {
            super(itemView);
            img = (ImageFilterView)itemView.findViewById(R.id.imgBanner);
        }
    }
}
