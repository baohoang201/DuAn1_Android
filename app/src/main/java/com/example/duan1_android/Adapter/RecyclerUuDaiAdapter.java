package com.example.duan1_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.DTO.ItemUuDai;
import com.example.duan1_android.R;

import java.util.List;

public class RecyclerUuDaiAdapter extends RecyclerView.Adapter<RecyclerUuDaiAdapter.MyViewHolderItem>  {
    private Context context;
    private List<ItemUuDai> list;

    public RecyclerUuDaiAdapter(Context context, List<ItemUuDai> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public MyViewHolderItem onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_uudai,parent,false);
            MyViewHolderItem viewHolderItem = new MyViewHolderItem(view);
        return viewHolderItem;
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolderItem holder, int position) {
        holder.img.setImageResource(list.get(position).getImgId());
        holder.tv.setText(list.get(position).getTitle());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolderItem extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv;


        public MyViewHolderItem(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_uudai);
            tv = itemView.findViewById(R.id.tv_uudai);
        }
    }
}
