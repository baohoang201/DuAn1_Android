package com.example.duan1_android.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan1_android.DTO.ScreenItem;
import com.example.duan1_android.R;
import com.example.duan1_android.SplashScreen.IntroductoryFragment;

import java.util.ArrayList;
import java.util.List;

public class IntrodutoryAdapter extends FragmentStateAdapter {

    private List<ScreenItem> list;


    public IntrodutoryAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

        this.list = this.intDatas();
    }

    private List<ScreenItem> intDatas()  {
        ScreenItem emp1 = new ScreenItem("Good Food", "Mang đến cho khách hàng trải nghiệm tuyệt vời tại The Coffee Shop", R.drawable.img4);
        ScreenItem emp2 = new ScreenItem("Fast Delivery", "Dịch vụ giao hàng nhanh chóng và tiện lợi", R.drawable.img2);
        ScreenItem emp3 = new ScreenItem("Easy Payment", "Thanh toán dễ dàng với các phương thức chuẩn hiện đại", R.drawable.img3);

        List<ScreenItem> list = new ArrayList<ScreenItem>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        return list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        ScreenItem screenItem = this.list.get(position);
        return new IntroductoryFragment(screenItem);
    }


    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
