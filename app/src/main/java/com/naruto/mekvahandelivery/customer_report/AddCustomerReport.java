package com.naruto.mekvahandelivery.customer_report;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.signature.SignatureActivity;

public class AddCustomerReport extends AppCompatActivity {
    private FrameLayout car, bike;
    private ImageView car_image, bike_image,img_sign,img_cancel;
    private TextView tvbike, tvcar, document;
    private Button take_sign,rc,puc,insurance,road_tax,passengerTax,pollutionPaper;
    private FrameLayout frame1;

    private String head_reset,floor_mats,wheel_cap,mud_flap,rc_btn,puc_btn,insurance_btn,road_tax_btn,passanger_btn,pollution_papaer_btn,signature,meter_percentage,image,odometer,battery_info,description;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer_report);


        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Customer report</font>"));
            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
            upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);

        }
        catch(Exception e){

        }



        car = findViewById(R.id.frame_2);
        bike = findViewById(R.id.frame_1);
        car_image = findViewById(R.id.car_image);
        bike_image = findViewById(R.id.bike_image);
        tvbike = findViewById(R.id.tvbike);
        tvcar = findViewById(R.id.tvcar);
        document = findViewById(R.id.tvDocument);
        take_sign=findViewById(R.id.bt_sign);
        img_sign=findViewById(R.id.image_sign);
        img_cancel=findViewById(R.id.image_cross);

        rc=findViewById(R.id.bt_rc);
        puc=findViewById(R.id.bt_puc);
        insurance=findViewById(R.id.bt_insurance);
        road_tax=findViewById(R.id.bt_roadtax);
        passengerTax=findViewById(R.id.bt_passengertax);
        pollutionPaper=findViewById(R.id.bt_pollutionpaper);





        loadCarFragment();
        load_car();

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadCarFragment();
                load_car();


            }
        });
        bike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadBikeFragment();
                load_bike();


            }
        });
        take_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent i=new Intent(AddCustomerReport.this, SignatureActivity.class);
                  startActivityForResult(i,2);


            }
        });
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_sign.setImageResource(R.drawable.image_svg);
            }
        });


        rc.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    rc.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    rc.setTextColor(Color.WHITE);
                    rc_btn="1";
                    check = 0;
                } else {
                    rc.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    rc.setTextColor(Color.BLACK);
                    rc_btn="0";
                    check = 1;
                }
            }
        });
        puc.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    puc.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    puc.setTextColor(Color.WHITE);
                    puc_btn="1";
                    check = 0;
                } else {
                    puc.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    puc.setTextColor(Color.BLACK);
                    puc_btn="0";
                    check = 1;
                }
            }
        });
        passengerTax.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    passengerTax.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    passengerTax.setTextColor(Color.WHITE);
                    passanger_btn="1";
                    check = 0;
                } else {
                    passengerTax.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    passengerTax.setTextColor(Color.BLACK);
                    passanger_btn="0";
                    check = 1;
                }
            }
        });
        insurance.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    insurance.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    insurance.setTextColor(Color.WHITE);
                    insurance_btn="1";
                    check = 0;
                } else {
                    insurance.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    insurance.setTextColor(Color.BLACK);
                    insurance_btn="0";
                    check = 1;
                }
            }
        });
        road_tax.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    road_tax.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    road_tax.setTextColor(Color.WHITE);
                    road_tax_btn="1";
                    check = 0;
                } else {
                    road_tax.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    road_tax.setTextColor(Color.BLACK);
                    road_tax_btn="0";
                    check = 1;
                }
            }
        });
        pollutionPaper.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    pollutionPaper.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    pollutionPaper.setTextColor(Color.WHITE);
                    pollution_papaer_btn="1";
                    check = 0;
                } else {
                    pollutionPaper.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    pollutionPaper.setTextColor(Color.BLACK);
                    pollution_papaer_btn="0";
                    check = 1;
                }
            }
        });







    }


    private void load_bike() {
        bike.setBackgroundResource(R.color.chart_deep_red);
        tvbike.setTextColor(Color.WHITE);
        bike_image.setImageResource(R.drawable.bike_white);

        car.setBackgroundResource(R.color.white);
        tvcar.setTextColor(Color.BLACK);
        car_image.setImageResource(R.drawable.carblack);
        document.setText("Bike document");
    }

    private void load_car() {
        bike.setBackgroundResource(R.color.white);
        tvbike.setTextColor(Color.BLACK);
        bike_image.setImageResource(R.drawable.bike_black);

        car.setBackgroundResource(R.color.chart_deep_red);
        tvcar.setTextColor(Color.WHITE);
        car_image.setImageResource(R.drawable.car_white);
        document.setText("Car document");
    }


    private void loadCarFragment() {
        Car_Add_fragment c_Fragment = new Car_Add_fragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout,
                c_Fragment,
                c_Fragment.getTag()).commit();
    }

    private void loadBikeFragment() {
        Bike_Add_fragment b_Fragment = new Bike_Add_fragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout,
                b_Fragment,
                b_Fragment.getTag()).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==2){
            byte[] bytes = data.getByteArrayExtra("image");
            Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            img_sign.setImageBitmap(bmp);


        }


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


