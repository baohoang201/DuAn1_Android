package com.example.duan1_android.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.duan1_android.Adapter.IntrodutoryAdapter;
import com.example.duan1_android.DTO.ScreenItem;
import com.example.duan1_android.Login.LoginActivity;
import com.example.duan1_android.R;
import com.example.duan1_android.Transformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class Intro extends AppCompatActivity {
    private ViewPager2 viewPager2;


int position =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        viewPager2 = (ViewPager2) findViewById(R.id.viewPager2);


        IntrodutoryAdapter adapter = new IntrodutoryAdapter(this);
        this.viewPager2.setAdapter(adapter);

        this.viewPager2.setPageTransformer(new ZoomOutTranform());

    }

}