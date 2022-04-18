package com.example.duan1_android.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan1_android.DTO.GioHang;
import com.example.duan1_android.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<GioHang> gioHangList;

    public GioHangAdapter(Context context, ArrayList<GioHang> gioHangList) {
        this.context = context;
        this.gioHangList = gioHangList;
    }

    @Override
    public int getCount() {
        return gioHangList.size();
    }

    @Override
    public Object getItem(int position) {
        return gioHangList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class GHViewHolder{
        ImageView imgiohang;
        TextView txttengiohang, txtgiagiohang,tvSL;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        GHViewHolder viewHolder = null;
        if(view==null)
        {
            viewHolder = new GHViewHolder();
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_giohang,null);
            viewHolder.txttengiohang = view.findViewById(R.id.textviewgiohang);
            viewHolder.txtgiagiohang = view.findViewById(R.id.textviewgiagiohang);
            viewHolder.imgiohang = view.findViewById(R.id.imageviewgiohang);
            viewHolder.tvSL = view.findViewById(R.id.tvSL);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (GHViewHolder)view.getTag();
        }
        GioHang giohang = (GioHang)getItem(position);
        viewHolder.txttengiohang.setText(giohang.getTenSP());
        DecimalFormat decimalFormat =new DecimalFormat("###,###,###");
        viewHolder.txtgiagiohang.setText(decimalFormat.format(giohang.getGiaSP())+" VNĐ");
        viewHolder.imgiohang.setImageBitmap(BitmapFactory.decodeByteArray(giohang.getAnhSP(), 0,giohang.getAnhSP().length));
        viewHolder.tvSL.setText(Integer.toString(giohang.getSoLuongSP()));//lay gia tri
        return view;
    }

}

