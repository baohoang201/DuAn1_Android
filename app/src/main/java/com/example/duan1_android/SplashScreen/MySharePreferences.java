package com.example.duan1_android.SplashScreen;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreferences {
    private static final  String MY_SHARE_PREFERENCES = "MY_SHARE_PREFERENCES";
    private Context mContext;

    public MySharePreferences(Context mContext) {
        this.mContext = mContext;
    }

    public void putBooleanValues(String key, boolean value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }
    public boolean getBooleanValue(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, 0);
        return sharedPreferences.getBoolean(key,false);
    }
}
