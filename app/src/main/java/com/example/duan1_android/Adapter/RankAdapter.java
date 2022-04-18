package com.example.duan1_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1_android.DTO.Rank;
import com.example.duan1_android.R;

import java.util.List;

public class RankAdapter extends BaseAdapter {
    private Context context;
    private int item;
    private List<Rank> list;

    public RankAdapter(Context context, int item, List<Rank> list) {
        this.context = context;
        this.item = item;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        LayoutInflater inflater =     (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(item,null);
        Rank  rank = list.get(position);

        ImageView imageView = convertView.findViewById(R.id.img_rank);
        TextView tv1 = convertView.findViewById(R.id.gift1);


        imageView.setImageResource(rank.getImg());
        tv1.setText(rank.getGift1());
        return convertView;
    }
}
