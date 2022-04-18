package com.example.duan1_android.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.DTO.SanPham;
import com.example.duan1_android.DTO.Shop;
import com.example.duan1_android.R;
import com.example.duan1_android.SelectAll.SelectAllOrder;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerShopAdapter extends RecyclerView.Adapter<RecyclerShopAdapter.MyViewHolder> {
    Context context;

    SelectAllOrder selectAllOrder;
    List<Shop> list ;
    CardView cardView;


    public RecyclerShopAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Shop> list){
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyler_shop,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerShopAdapter.MyViewHolder holder, int position) {
        Shop shop = list.get(position);
        if(shop != null){
            holder.txtTenShop.setText(shop.getTenShop());
            holder.txtDiaChiShop.setText(shop.getDiaChiShop());
            holder.imgShop.setImageBitmap(BitmapFactory.decodeByteArray(shop.getImgShop(),0,shop.getImgShop().length));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imgShop;
        private TextView txtTenShop;
        private TextView txtDiaChiShop;

        public MyViewHolder( View itemView) {
            super(itemView);
            imgShop = (RoundedImageView) itemView.findViewById(R.id.imgShop);
            txtTenShop = (TextView) itemView.findViewById(R.id.txtTenShop);
            txtDiaChiShop = (TextView) itemView.findViewById(R.id.txtDiaChiShop);

        }
    }
}
