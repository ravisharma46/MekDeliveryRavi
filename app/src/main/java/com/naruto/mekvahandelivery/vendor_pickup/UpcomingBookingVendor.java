package com.naruto.mekvahandelivery.vendor_pickup;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.ScanQrcode;
import com.naruto.mekvahandelivery.customer_report.AddCustomerReport;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.sendNavigateIntent;

public class UpcomingBookingVendor extends AppCompatActivity {

    private LinearLayout paint_linear,navigation;
    private Button report,pickup_confirm;
    private TextView tvDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_booking_vendor);

        report= findViewById(R.id.bt_addReport);
        tvDetails=findViewById(R.id.tvDetails);
        paint_linear = findViewById(R.id.linear_paint);
        pickup_confirm=findViewById(R.id.btpickup);
        navigation=findViewById(R.id.ll_navigation);


        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>#123</font>"));
            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
            upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }

        catch(Exception e){
            e.printStackTrace();
        }


        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpcomingBookingVendor.this, AddCustomerReport.class));
            }
        });

        tvDetails.setOnClickListener(new View.OnClickListener() {
            int check = 1;

            @Override
            public void onClick(View view) {

                if (check == 1) {
                    paint_linear.setVisibility(View.VISIBLE);
                    check = 0;
                } else {
                    paint_linear.setVisibility(View.GONE);
                    check = 1;
                }


            }
        });


        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNavigateIntent(UpcomingBookingVendor.this,28.717010,77.102364);
            }
        });

        pickup_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpcomingBookingVendor.this, ScanQrcode.class));
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
