package com.naruto.mekvahandelivery.history;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.naruto.mekvahandelivery.R;

public class Service_Completed extends AppCompatActivity {

    private TextView rupeeAmount, rupeepaytm,tvDetails;
    private TextView btnClickme;
    private LinearLayout ll1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service__completed);

        //Action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Order #123</font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        rupeeAmount = findViewById(R.id.rupeeAmount);
        rupeepaytm = findViewById(R.id.rupeePaytm);
        ll1=findViewById(R.id.linear_paint);
        tvDetails=findViewById(R.id.tvDetails);

        rupeepaytm.setText("\u20B9" + " 3,200");
        rupeeAmount.setText("\u20B9" + " 3,200");





        tvDetails.setOnClickListener(new View.OnClickListener() {
            int check=1;
            @Override
            public void onClick(View view) {

                if(check==1){
                    ll1.setVisibility(View.VISIBLE);
                    check=0;
                }
                else{
                    ll1.setVisibility(View.GONE);
                    check=1;
                }


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
