package com.example.duan1_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.duan1_android.R;

public class AdapterGridOder extends BaseAdapter {
    Context context;
    int flag[];
    LayoutInflater layoutInflater;

    public AdapterGridOder(Context context, int[] flag, LayoutInflater layoutInflater) {
        this.context = context;
        this.flag = flag;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return flag.length;
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
        convertView = layoutInflater.inflate(R.layout.item_gird_oder,parent, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgGridOder);
        imageView.setImageResource(flag[position]);

        return null;
    }
}
