package com.example.duan1_android;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.duan1_android.Adapter.MyPagerView2Adapter;
import com.example.duan1_android.DTO.KhachHang;
import com.example.duan1_android.Fragment.HomeFragment;
import com.example.duan1_android.Fragment.OderFragment;
import com.example.duan1_android.Fragment.OfferFragment;
import com.example.duan1_android.Fragment.OtherFragment;
import com.example.duan1_android.Fragment.ShopFragment;
import com.example.duan1_android.Transformer.DepthPageTransformer;
import com.example.duan1_android.Transformer.ZoomOutPageTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
@RequiresApi(21)
public class MainActivity extends AppCompatActivity {
private ViewPager2 mViewPager2;
private BottomNavigationView btNav;
private String msetChao = "";
private HomeFragment homeFragment;
private OderFragment oderFragment;
private OfferFragment offerFragment;
private OtherFragment otherFragment;
private ShopFragment shopFragment;
private FragmentContainerView fragmentContainerViewb1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        mViewPager2 = findViewById(R.id.myViewPager2);
        btNav = findViewById(R.id.myBottomNav);
        senDataToHome();
//        MyPagerView2Adapter myPagerView2Adapter = new MyPagerView2Adapter(this);
//
//         mViewPager2.setAdapter(myPagerView2Adapter);
        fragmentContainerViewb1 = (FragmentContainerView) findViewById(R.id.fragmentContainerViewb1);
        homeFragment = new HomeFragment();
        oderFragment = new OderFragment();
        offerFragment = new OfferFragment();
        otherFragment = new OtherFragment();
        shopFragment = new ShopFragment();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction();
         btNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 int id = item.getItemId();

                 if (id == R.id.btNav_Home){
                     fm.beginTransaction().replace(R.id.fragmentContainerViewb1, homeFragment).commit();
                 }else  if (id ==R.id.btNav_Oder ){
                     fm.beginTransaction().replace(R.id.fragmentContainerViewb1, oderFragment).commit();
                 }else  if (id ==R.id.btNav_Shop ){
                     fm.beginTransaction().replace(R.id.fragmentContainerViewb1, shopFragment).commit();
                 }else  if (id ==R.id.btNav_Offer ){
                     fm.beginTransaction().replace(R.id.fragmentContainerViewb1, offerFragment).commit();
                 }else  if (id ==R.id.btNav_Other ){
                     fm.beginTransaction().replace(R.id.fragmentContainerViewb1, otherFragment).commit();
                 }

                 return true;
             }
         });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    public void senDataToHome(){
        KhachHang khachHang = (KhachHang) this.getIntent().getSerializableExtra("khachhang");
        String setChao = khachHang.getUserKH();

        HomeFragment homeFragment = new HomeFragment();

        msetChao = setChao;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerViewb1, homeFragment);
        fragmentTransaction.commit();

    }

    public String getMsetChao() {
        return msetChao;
    }



}