package com.example.duan1_android.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.duan1_android.Fragment.TichDiemFragment;
import com.example.duan1_android.Fragment.UuDaiFragment;

public class ViewPagerUuDaiAdapter extends FragmentStatePagerAdapter {
    public ViewPagerUuDaiAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TichDiemFragment();
            case 1: return new UuDaiFragment();
            default: return new TichDiemFragment();

        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0 :
                title = "Tích điểm";
                break;
            case 1:
                title = "Ưu đãi";
                break;
        }
        return title;
    }
}
