package com.example.duan1_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1_android.R;

public class AdapterTaiKhoan extends BaseAdapter {
    Context context;
    int img[];
    String title[];

    public AdapterTaiKhoan(Context context, int[] img, String[] title) {
        this.context = context;
        this.img = img;
        this.title = title;
        layoutInflater = LayoutInflater.from(context);
    }
    LayoutInflater layoutInflater;


    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.item_lv_hotro,null);
        ImageView imageView = convertView.findViewById(R.id.image_item);//anh xa
        TextView textView = convertView.findViewById(R.id.title_item);
        imageView.setImageResource(img[position]);
        textView.setText(title[position]);
        return convertView;
    }
}
