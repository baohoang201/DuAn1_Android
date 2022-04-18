package com.example.duan1_android.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.ChiTietSanPham;
import com.example.duan1_android.DTO.SanPhamCoffeOder;
import com.example.duan1_android.R;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RecyclerOderAdapter extends RecyclerView.Adapter<RecyclerOderAdapter.MyViewHolder>  implements Filterable{
    Context context;
    ArrayList<SanPhamCoffeOder> list;
    ArrayList<SanPhamCoffeOder> listAll;
    byte[]  img;
    String name;
    int gia;
    int id;
    String thongTinChiTiet;

    public RecyclerOderAdapter(Context context, ArrayList<SanPhamCoffeOder> list) {
        this.context = context;
        this.list = list;
        this.listAll = list;
    }

    public  void setData(ArrayList<SanPhamCoffeOder> list){
        this.list = list;
    }
    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyler_oder_coffe,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerOderAdapter.MyViewHolder holder, int position) {
         SanPhamCoffeOder sanPhamCoffeOder = list.get(position);
         if (sanPhamCoffeOder != null){
            holder.tvName.setText(list.get(position).getTenSPOder());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            holder.tvGia.setText(decimalFormat.format(list.get(position).getGiaSPOder())+"VNĐ");
            holder.img.setImageBitmap(BitmapFactory.decodeByteArray(list.get(position).getImgSPOder(),0,sanPhamCoffeOder.getImgSPOder().length));
        }


        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sanPhamCoffeOder != null){
                    Context context = v.getContext();
                    Intent intent = new Intent(context,ChiTietSanPham.class);


                    id = sanPhamCoffeOder.getIdSP();
                    name = sanPhamCoffeOder.getTenSPOder();
                    gia = sanPhamCoffeOder.getGiaSPOder();
                    img = sanPhamCoffeOder.getImgSPOder();
                    thongTinChiTiet = sanPhamCoffeOder.getChiTietSanPham();
                    list.add(sanPhamCoffeOder);

                    intent.putExtra("thongtinsanpham",list.get(position));
                    context.startActivity(intent);
//


                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {

        return filter;
    }
    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<SanPhamCoffeOder> filteredList = new ArrayList<>();
            if (constraint.toString().isEmpty()){
                    filteredList.addAll(listAll);

            }else {
                for (SanPhamCoffeOder item: listAll){
                    if (item.getTenSPOder().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(item);

                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                listAll.clear();
                listAll.add((SanPhamCoffeOder) results.values);
                notifyDataSetChanged();
        }
    };


    public  class MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout item;
        private TextView tvName;
        private TextView tvGia;

        private ImageView img;
        public MyViewHolder( View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.itemcf);
            tvName =  itemView.findViewById(R.id.txtTenOderCoffe);
            tvGia =  itemView.findViewById(R.id.tvGiaOderCoffe);
            img =  itemView.findViewById(R.id.imgOderCoffe);
        }
    }
}
