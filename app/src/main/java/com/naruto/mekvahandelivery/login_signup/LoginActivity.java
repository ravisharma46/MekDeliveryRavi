package com.naruto.mekvahandelivery.login_signup;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.naruto.mekvahandelivery.R;

public class LoginActivity extends AppCompatActivity {


    private ImageView iv_bg;
    private TextView tvfeedback;


    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iv_bg = findViewById(R.id.bg_img);

        replaceFragment(new LoginFragment());



    }

    @Override
    protected void onResume() {
        super.onResume();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int windowWidth = size.x;
        int windowHeight = size.y;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                windowWidth, (windowHeight / 2)-40);
        iv_bg.setLayoutParams(params);
        iv_bg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }



    @Override
    public void onBackPressed() {
        finish();

    }

    public void replaceFragment(Fragment fragment) {
        Log.e(TAG, "replaceFragment");
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }




}
