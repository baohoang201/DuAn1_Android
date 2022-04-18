package com.example.duan1_android.CustomView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.duan1_android.DTO.ItemGrid;
import com.example.duan1_android.DTO.ItemGridOder;
import com.example.duan1_android.R;

import java.util.ArrayList;

public class CustomViewGridOder extends ArrayAdapter<ItemGridOder> {
    Context context;
    int resourceID;
    ArrayList<ItemGridOder> list;

    public CustomViewGridOder(@NonNull Context context, int resourceID, @NonNull ArrayList<ItemGridOder> list) {
        super(context, resourceID, list);
        this.context = context;
        this.resourceID = resourceID;
        this.list = list;

    }
    static class  RecordHolder{
        TextView tvTitle;
        ImageView imgItem;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        RecordHolder holder = null;
        if (view == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            view = inflater.inflate(resourceID,parent,false);

            holder = new RecordHolder();
            holder.tvTitle = (TextView)view.findViewById(R.id.itemTextOder);
            holder.imgItem = (ImageView) view.findViewById(R.id.itemImgOder);
            view.setTag(holder);



        }else {
            holder = (RecordHolder)view.getTag();
        }
        ItemGridOder itemGridOder = list.get(position);
        holder.tvTitle.setText(itemGridOder.getTitleOder());
        holder.imgItem.setImageBitmap(itemGridOder.getImgGridOder());
        return view;
    }
}
