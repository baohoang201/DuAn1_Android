package com.example.duan1_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1_android.R;

public class AdapterLienHe extends BaseAdapter {
    LayoutInflater layoutInflater;
    Context context;
    int anhLienHe[];
    String LienHe[];

    public AdapterLienHe(Context context, int[] anhLienHe, String[] lienHe) {
        this.context = context;
        this.anhLienHe = anhLienHe;
        LienHe = lienHe;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return anhLienHe.length;
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
        imageView.setImageResource(anhLienHe[position]);
        textView.setText(LienHe[position]);
        return convertView;
    }
}
