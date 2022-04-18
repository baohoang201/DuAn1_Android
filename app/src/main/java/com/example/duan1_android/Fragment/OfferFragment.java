package com.example.duan1_android.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.duan1_android.Adapter.ViewPagerUuDaiAdapter;
import com.example.duan1_android.R;
import com.google.android.material.tabs.TabLayout;

public class OfferFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FragmentContainerView containerViewOffer;

    private TichDiemFragment tichDiemFragment;
    private UuDaiFragment uuDaiFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.offer_fragment,container,false);
        containerViewOffer = (FragmentContainerView) view.findViewById(R.id.containerViewOffer);
        tichDiemFragment = new TichDiemFragment();
        uuDaiFragment = new UuDaiFragment();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.beginTransaction();

//        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.tablayout);
        ViewPagerUuDaiAdapter viewPagerUuDaiAdapter = new ViewPagerUuDaiAdapter(getActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabLayout.addTab(tabLayout.newTab().setText("Tích Điểm"));
        tabLayout.addTab(tabLayout.newTab().setText("Ưu Đãi"));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if(position == 0){
                    fm.beginTransaction().replace(R.id.containerViewOffer, tichDiemFragment).commit();
                    return;
                }else {
                    fm.beginTransaction().replace(R.id.containerViewOffer, uuDaiFragment).commit();
                    return;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        chonTab();

        return view;
    }
    private void chonTab(){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.beginTransaction();
        if(tabLayout.getTabAt(0).isSelected()) {
            fm.beginTransaction().replace(R.id.containerViewOffer, tichDiemFragment).commit();
            return;
        }
    }


}
