package com.example.duan1_android.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duan1_android.Login.LoginActivity;
import com.example.duan1_android.R;


public class SplashActivity extends AppCompatActivity {
    private LinearLayout layoutChu;

    private static final String KEY_FIRST_INSTALL = "KEY_FIRST_INSTALL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        MySharePreferences mySharePreferences = new MySharePreferences(this);
        layoutChu = (LinearLayout) findViewById(R.id.layoutChu);



        layoutChu.animate().translationY(16000).setDuration(600).setStartDelay(5600);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mySharePreferences.getBooleanValue(KEY_FIRST_INSTALL)){
                    //get được dữ liệu thì vào main
                    startActivity(LoginActivity.class);
                }else {
                    //kh get được thì vào Onbroad
                    startActivity(Intro.class);
                    mySharePreferences.putBooleanValues(KEY_FIRST_INSTALL,true);
                }
            }
        },6000);


    }
    private void startActivity(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
        finish();
    }
}