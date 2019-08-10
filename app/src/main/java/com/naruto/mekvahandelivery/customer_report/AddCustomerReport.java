package com.naruto.mekvahandelivery.customer_report;


import android.annotation.SuppressLint;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.signature.SignatureActivity;

import java.util.HashMap;
import java.util.Map;

@SuppressLint("SetTextI18n")
public class AddCustomerReport extends AppCompatActivity implements Car_Add_fragment.OnFragmentInteractionListener,
        Bike_Add_fragment.OnFragmentInteractionListener {
    private FrameLayout car, bike;
    private ImageView car_image, bike_image, img_sign;
    private TextView tvbike, tvcar, document;
    private Button btrc, btpuc, btinsurance, btroadtax, btpassengertax, btpollutionpaper;
    private String addCarReportapiUrl = "https://mekvahan.com/api/CarRegularServiceReport";
    private Map<String, String> carButton, bikeButton, reportButton;
    private String rcStr,pucStr,insuranceStr, roadtaxStr,passangertaxStr,pollutionpapaerStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer_report);

        carButton = new HashMap<>();
        carButton = initCarData();
        bikeButton = new HashMap<>();
        bikeButton = initBikeData();
        reportButton = new HashMap<>();
        reportButton = initReportData();

        try{
            final Drawable upArrow = getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
            if (getSupportActionBar() != null && upArrow != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
                getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Customer report</font>"));
                upArrow.setColorFilter(getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
                getSupportActionBar().setHomeAsUpIndicator(upArrow);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        car = findViewById(R.id.frame_2);
        bike = findViewById(R.id.frame_1);
        car_image = findViewById(R.id.car_image);
        bike_image = findViewById(R.id.bike_image);
        tvbike = findViewById(R.id.tvbike);
        tvcar = findViewById(R.id.tvcar);
        document = findViewById(R.id.tvDocument);
        Button take_sign = findViewById(R.id.bt_sign);
        img_sign=findViewById(R.id.image_sign);
        ImageView img_cancel = findViewById(R.id.image_cross);

        btrc=findViewById(R.id.bt_rc);
        btpuc=findViewById(R.id.bt_puc);
        btinsurance=findViewById(R.id.bt_insurance);
        btroadtax=findViewById(R.id.bt_roadtax);
        btpassengertax=findViewById(R.id.bt_passengertax);
        btpollutionpaper=findViewById(R.id.bt_pollutionpaper);

        loadCarFragment();
        load_car();

        car.setOnClickListener(view -> {
            loadCarFragment();
            load_car();

        });
        bike.setOnClickListener(view -> {
            loadBikeFragment();
            load_bike();

        });
        take_sign.setOnClickListener(view -> {
              Intent i=new Intent(AddCustomerReport.this, SignatureActivity.class);
              startActivityForResult(i,2);


        });
        img_cancel.setOnClickListener(view -> img_sign.setImageResource(R.drawable.image_svg));


        btrc.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    btrc.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    btrc.setTextColor(Color.WHITE);
                    rcStr="1";
                    check = 0;
                } else {
                    btrc.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    btrc.setTextColor(Color.BLACK);
                    rcStr="0";
                    check = 1;
                }
            }
        });
        btpuc.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    btpuc.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    btpuc.setTextColor(Color.WHITE);
                    pucStr="1";
                    check = 0;
                } else {
                    btpuc.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    btpuc.setTextColor(Color.BLACK);
                    pucStr="0";
                    check = 1;
                }
            }
        });
        btpassengertax.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    btpassengertax.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    btpassengertax.setTextColor(Color.WHITE);
                    passangertaxStr="1";
                    check = 0;
                } else {
                    btpassengertax.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    btpassengertax.setTextColor(Color.BLACK);
                    passangertaxStr="0";
                    check = 1;
                }
            }
        });
        btinsurance.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    btinsurance.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    btinsurance.setTextColor(Color.WHITE);
                    insuranceStr="1";
                    check = 0;
                } else {
                    btinsurance.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    btinsurance.setTextColor(Color.BLACK);
                    insuranceStr="0";
                    check = 1;
                }
            }
        });
        btroadtax.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    btroadtax.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    btroadtax.setTextColor(Color.WHITE);
                    roadtaxStr="1";
                    check = 0;
                } else {
                    btroadtax.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    btroadtax.setTextColor(Color.BLACK);
                    roadtaxStr="0";
                    check = 1;
                }
            }
        });
        btpollutionpaper.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    btpollutionpaper.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    btpollutionpaper.setTextColor(Color.WHITE);
                    pollutionpapaerStr="1";
                    check = 0;
                } else {
                    btpollutionpaper.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    btpollutionpaper.setTextColor(Color.BLACK);
                    pollutionpapaerStr="0";
                    check = 1;
                }
            }
        });

    }

    private Map<String, String> initReportData() {
        Map<String, String> reportData = new HashMap<>();
        reportData.put("headrest", "0");
        reportData.put("floormats", "0");
        reportData.put("wheelcap", "0");
        reportData.put("mudflap", "0");
        reportData.put("btrc", "0");
        reportData.put("btpuc", "0");
        reportData.put("btinsurance", "0");
        reportData.put("btroadtax", "0");
        reportData.put("btpassengertax", "0");
        reportData.put("btpollutionpaper", "0");
        reportData.put("odometer", "0");
        reportData.put("otherreport", null);
        return reportData;
    }

    private Map<String, String> initBikeData() {
        Map<String, String> bikeButton = new HashMap<>();
        bikeButton.put("toolkit", "0");
        bikeButton.put("firstadkit", "0");
        bikeButton.put("keychain", "0");
        bikeButton.put("bikecover", "0");
        bikeButton.put("servicebook", "0");
        bikeButton.put("miscellenoustool", "0");
        return bikeButton;
    }

    private Map<String, String> initCarData() {
        Map<String, String> carButton = new HashMap<>();
        carButton.put("stepney", "0");
        carButton.put("toolkit", "0");
        carButton.put("mudguard", "0");
        carButton.put("keychain", "0");
        carButton.put("servicebook", "0");
        carButton.put("mats", "0");
        carButton.put("wheelcover", "0");
        carButton.put("lock", "0");
        carButton.put("jackhandle", "0");
        carButton.put("carpet", "0");
        carButton.put("stereopanel", "0");
        carButton.put("speakers", "0");
        return carButton;
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

        if(requestCode==2 && data != null){
            byte[] bytes = data.getByteArrayExtra("image");
            Bitmap bmp = null;
            if (bytes != null) {
                bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            }
            img_sign.setImageBitmap(bmp);

        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onFragmentInteraction(View view) {
        if (getSupportFragmentManager().findFragmentById(R.id.frameLayout) instanceof Car_Add_fragment) {
            onCarFragmentButtonClick(view);
        } else if (getSupportFragmentManager().findFragmentById(R.id.frameLayout) instanceof Bike_Add_fragment) {
            onBikeFragmentButtonClick(view);
        }
    }

    private void onBikeFragmentButtonClick(View view) {
        String buttonId = getResources().getResourceEntryName(view.getId());
        Button btn = findViewById(view.getId());
        buttonId = buttonId.substring(3);
        if (bikeButton.get(buttonId).equals("0")) {
            btn.setBackgroundResource(R.drawable.customer_reprt_bt02);
            btn.setTextColor(getColor(android.R.color.white));
            bikeButton.put(buttonId, "1");
        } else if (carButton.get(buttonId).equals("1")) {
            btn.setBackgroundResource(R.drawable.customer_rprt_bt01);
            btn.setTextColor(getColor(android.R.color.black));
            bikeButton.put(buttonId, "0");
        }
    }

    private void onCarFragmentButtonClick(View view) {
        String buttonId = getResources().getResourceEntryName(view.getId());
        Button btn = findViewById(view.getId());
        buttonId = buttonId.substring(3);
        if (carButton.get(buttonId).equals("0")) {
            btn.setBackgroundResource(R.drawable.customer_reprt_bt02);
            btn.setTextColor(getColor(android.R.color.white));
            carButton.put(buttonId, "1");
        } else if (carButton.get(buttonId).equals("1")) {
            btn.setBackgroundResource(R.drawable.customer_rprt_bt01);
            btn.setTextColor(getColor(android.R.color.black));
            carButton.put(buttonId, "0");
        }

    }

}


