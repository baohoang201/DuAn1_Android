package com.example.duan1_android.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan1_android.Fragment.HomeFragment;
import com.example.duan1_android.Fragment.OderFragment;
import com.example.duan1_android.Fragment.OfferFragment;
import com.example.duan1_android.Fragment.OtherFragment;
import com.example.duan1_android.Fragment.ShopFragment;

public class MyPagerView2Adapter extends FragmentStateAdapter {
    public MyPagerView2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new OderFragment();
            case 2:
                return new ShopFragment();
            case 3:
                return new OfferFragment();
            case 4:
                return new OtherFragment();
            default:
                return new HomeFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
