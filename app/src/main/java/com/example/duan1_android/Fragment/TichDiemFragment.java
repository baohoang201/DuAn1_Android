package com.example.duan1_android.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.duan1_android.QuyenLoiActivity;
import com.example.duan1_android.R;

public class TichDiemFragment extends Fragment {
    CardView cardViewQuyenloi;
    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.tich_diem_fragment,container,false);

        cardViewQuyenloi = view.findViewById(R.id.cvQuyenLoi);

        cardViewQuyenloi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuyenLoiActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
