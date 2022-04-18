package com.example.duan1_android.Adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_android.DTO.SanPhamThem;
import com.example.duan1_android.R;

import java.util.List;

public class AdapterThemSanPham extends RecyclerView.Adapter<AdapterThemSanPham.ViewHolder>{
    private List<SanPhamThem> list;
    private Context context;
    private Listionner mListionner;


    public AdapterThemSanPham(Context context, Listionner mListionner) {
        this.context = context;
        this.mListionner = mListionner;
    }
    public void setData(List<SanPhamThem> list) {
        this.list = list;
    }
    public interface Listionner{
        public void onCLickdelect(View view , int position);
    }

    @NonNull
    @Override
    public AdapterThemSanPham.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_them, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterThemSanPham.ViewHolder holder, int position) {
        SanPhamThem sanPhamThem = list.get(position);
        if (sanPhamThem != null){
            holder.ivanhi.setImageBitmap(BitmapFactory.decodeByteArray(sanPhamThem.getAnhSanPham() ,0 , sanPhamThem.getAnhSanPham().length ));

        }
        holder.btnCLose.setOnClickListener( v -> {
            mListionner.onCLickdelect(v, position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivanhi;
        private ImageView btnCLose;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivanhi = (ImageView) itemView.findViewById(R.id.ivanhi);
            btnCLose = (ImageView) itemView.findViewById(R.id.btnCLose);
        }
    }
}
