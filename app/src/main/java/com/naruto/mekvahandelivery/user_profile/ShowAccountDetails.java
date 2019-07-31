package com.naruto.mekvahandelivery.user_profile;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager;
import com.naruto.mekvahandelivery.R;

import java.util.HashMap;

import static com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager.ACCOUNT_NUMBER;
import static com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager.CANCELLED_CHECK;
import static com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager.IFSC_CODE;
import static com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager.PAN_NUMBER;

public class ShowAccountDetails extends AppCompatActivity {
    private Button bt;
    private TextView panNumber,accountNumber,ifsc,cancelledCheq;
    private LoginSessionManager msessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_account_details);

        bt = findViewById(R.id.bt_ok);
        panNumber=findViewById(R.id.tv_panNumber);
        accountNumber=findViewById(R.id.tv_accountNumber);
        ifsc=findViewById(R.id.tv_ifscCode);
        cancelledCheq=findViewById(R.id.tv_canceledCheckNumber);


        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Profile</font>"));
            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
            upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }
        catch(Exception e){

        }

        msessionManager=new LoginSessionManager(getApplicationContext());
        HashMap<String,String> userInfo=msessionManager.getUserDetailsFromSP();

        panNumber.setText(userInfo.get(PAN_NUMBER));
        accountNumber.setText(userInfo.get(ACCOUNT_NUMBER));
        ifsc.setText(userInfo.get(IFSC_CODE));
        cancelledCheq.setText(userInfo.get(CANCELLED_CHECK));



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}



