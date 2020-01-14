package com.naruto.mekvahandelivery.transaction_history;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.naruto.mekvahandelivery.R;

public class Transaction extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private FrameLayout car, bike;
    private ImageView car_image, bike_image,iv_brandLogo;
    private TextView tvbike, tvcar,tv_date,tv_time,tv_bookingId,tv_brandName,tv_licencePlate,tv_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Details</font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        car = findViewById(R.id.frame_2);
        bike = findViewById(R.id.frame_1);
        car_image = findViewById(R.id.car_image);
        bike_image = findViewById(R.id.bike_image);
        tvbike = findViewById(R.id.tvbike);
        tvcar = findViewById(R.id.tvcar);
        tv_date = findViewById(R.id.tv_date);
        tv_time = findViewById(R.id.tv_time);
        tv_bookingId = findViewById(R.id.tv_bookingId);
        tv_brandName = findViewById(R.id.tv_brandName);
        tv_licencePlate = findViewById(R.id.tv_licencePlate);
        tv_amount = findViewById(R.id.tv_amount);
        iv_brandLogo = findViewById(R.id.iv_brandLogo);


        Bundle bundle=getIntent().getExtras();
        assert bundle != null;


        String vehicle_type = bundle.getString("vehicletype");
        String date = bundle.getString("date");
        String time = bundle.getString("time");
        String booking_id = bundle.getString("booking_id");
        String logo = bundle.getString("logo");
        String brand_name = bundle.getString("brand_name");
        String licence_plate = bundle.getString("licence_plate");
        String amount = bundle.getString("amount");

        if(vehicle_type.contains("car")){
           load_car();
        }
        else{
            load_car();
        }
        tv_amount.setText("\u20B9 " + amount);
        tv_date.setText(date);
        tv_time.setText(time);
        tv_bookingId.setText("Order id: "+booking_id);
        tv_brandName.setText(brand_name);
        tv_licencePlate.setText(licence_plate);

        try{
            Glide.with(getApplicationContext()).load(logo)
                    .into(iv_brandLogo);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private void load_bike() {
        bike.setBackgroundResource(R.color.chart_deep_red);
        tvbike.setTextColor(Color.WHITE);
        bike_image.setImageResource(R.drawable.bike_white);

        car.setBackgroundResource(R.color.white);
        tvcar.setTextColor(Color.BLACK);
        car_image.setImageResource(R.drawable.carblack);

    }

    private void load_car() {
        bike.setBackgroundResource(R.color.white);
        tvbike.setTextColor(Color.BLACK);
        bike_image.setImageResource(R.drawable.bike_black);

        car.setBackgroundResource(R.color.chart_deep_red);
        tvcar.setTextColor(Color.WHITE);
        car_image.setImageResource(R.drawable.car_white);

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



