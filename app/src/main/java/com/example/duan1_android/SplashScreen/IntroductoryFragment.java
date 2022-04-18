package com.example.duan1_android.SplashScreen;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan1_android.DTO.ScreenItem;
import com.example.duan1_android.Login.LoginActivity;
import com.example.duan1_android.R;
import com.google.android.material.button.MaterialButton;


public class IntroductoryFragment extends Fragment {
    private static final String LOG_TAG = "AndroidExample";
    private ScreenItem screenItem;
    private ImageView imgScrenn;
    private TextView titleScreen;
    private TextView gioiThieuScreen;
    private TextView btnGetStarted;






    Animation btnAnim ;



    private static int counter = 0;

    public void IntroductoryFragment() {

    }

    public IntroductoryFragment(ScreenItem screenItem) {
        this.screenItem = screenItem;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(
                R.layout.activity_introductory, container, false);
        btnGetStarted = (TextView) view.findViewById(R.id.btn_get_started);

        counter++;
        if(counter == 1) {
            view.setBackgroundColor(Color.parseColor("#FFFAFA"));
        } else if (counter == 2){
            view.setBackgroundColor(Color.parseColor("#FFFAFA"));
        }else{
            view.setBackgroundColor(Color.parseColor("#FFFAFA"));
            loaddLastScreen();
        }

        imgScrenn = (ImageView) view.findViewById(R.id.imgScrenn);
        titleScreen = (TextView) view.findViewById(R.id.titleScreen);
        gioiThieuScreen = (TextView) view.findViewById(R.id.gioiThieuScreen);
        btnAnim = AnimationUtils.loadAnimation(getActivity(),R.anim.button_animation);
        return view;
    }


    // Called when configuration change.
    // For example: User rotate the Phone,
    //  Android will create new Fragment (EmployeePageFragment) object via default Constructor
    //  so this.employee will be null.
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i(LOG_TAG, "onSaveInstanceState: save employee data to Bundle");
        // Convert employee object to Bundle.
        Bundle dataBundle = this.employeeToBundle(this.screenItem);
        outState.putAll(dataBundle);

        super.onSaveInstanceState(outState);
    }


    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onViewStateRestored");

        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view,  @Nullable Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);

        if(this.screenItem == null)  {
            Log.i(LOG_TAG, "Get employee data from savedInstanceState");
            // The state was saved by onSaveInstanceState(Bundle outState) method.
            this.screenItem = this.bundleToEmployee(savedInstanceState);
        }
        this.showInGUI(this.screenItem);
    }

    // Call where View ready.
    private void showInGUI(ScreenItem screenItem)  {
        this.imgScrenn.setImageResource(screenItem.getScreenImg());
        this.titleScreen.setText(screenItem.getTitle());
        this.gioiThieuScreen.setText(screenItem.getDescription());
    }

    private Bundle employeeToBundle(ScreenItem screenItem)  {
        Bundle bundle = new Bundle();

        bundle.putString("title", screenItem.getTitle());
        bundle.putString("description", screenItem.getDescription());
        bundle.putInt("anh", screenItem.getScreenImg());

        return bundle;
    }

    private ScreenItem bundleToEmployee(Bundle savedInstanceState) {

        String title = savedInstanceState.getString("title");
        String description = savedInstanceState.getString("description");
        Integer anh = savedInstanceState.getInt("anh");
        return new ScreenItem(title, description, anh);
    }
    private void loaddLastScreen() {

        btnGetStarted.setVisibility(View.VISIBLE);
        btnGetStarted.setAnimation(btnAnim);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}