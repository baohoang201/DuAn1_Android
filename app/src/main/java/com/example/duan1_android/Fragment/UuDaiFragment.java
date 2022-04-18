package com.example.duan1_android.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.duan1_android.Adapter.RecyclerUuDaiAdapter;
import com.example.duan1_android.DTO.ItemUuDai;
import com.example.duan1_android.R;

import java.util.ArrayList;
import java.util.List;

public class UuDaiFragment extends Fragment {
    private RecyclerView recyclerViewUuDai;
    private List<ItemUuDai> uuDaiList;
    RecyclerView.LayoutManager layoutManager;


    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.uu_dai_fragment,container,false);
       recyclerViewUuDai = view.findViewById(R.id.recyclerUuDai);
       RecyclerUuDaiAdapter recyclerUuDaiAdapter = new RecyclerUuDaiAdapter(getContext(),(ArrayList<ItemUuDai>)uuDaiList);
//       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
//       recyclerViewUuDai.setLayoutManager(linearLayoutManager);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() ,2,GridLayoutManager.VERTICAL);
        recyclerViewUuDai.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
       recyclerViewUuDai.setAdapter(recyclerUuDaiAdapter);



        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        uuDaiList = new ArrayList<>();
        uuDaiList.add(new ItemUuDai(R.drawable.upsize,"Giảm 15% tiền khi upsize lớn"));
        uuDaiList.add(new ItemUuDai(R.drawable.together,"Discount 20k khi đi cùng nhóm"));
        uuDaiList.add(new ItemUuDai(R.drawable.banhngot,"Mua bánh handmade chỉ 10k"));
        uuDaiList.add(new ItemUuDai(R.drawable.gift,"Cà phê từ Tây Nguyên tinh khiết nhất"));
        uuDaiList.add(new ItemUuDai(R.drawable.coffeemay,"Coffee máy chuẩn phong cách hiện đại"));
        uuDaiList.add(new ItemUuDai(R.drawable.buy1getfree,"Mua 1 đồ uống được tặng 1 đồ uống bất kì"));

    }
}
