package com.naruto.mekvahandelivery.customer_pickup;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.broooapps.otpedittext2.OtpEditText;
import com.bumptech.glide.Glide;
import com.naruto.mekvahandelivery.R;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.callIntent;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getDate;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getTime;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.pickupConfirm;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.sendNavigateIntent;

import com.naruto.mekvahandelivery.custom_list_data.CustomListAdapter;
import com.naruto.mekvahandelivery.customer_report.AddCustomerReport;

import java.util.ArrayList;

public class UpcomingBookingCustomer extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayout navigation;
    private TextView tvDetails,date, time,name,address,vehicleBrand,vehicleName,numberPlate,serviceName;
    private Button report,confirm_booking;
    private ImageView call,vehicle_image;

    public ArrayList<String>arrayList;
    public ArrayList<String>arrayListsend;

    private String otp_input="";
    private OtpEditText otpEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_booking_customer);

        tvDetails = findViewById(R.id.tvDetails);
        report = findViewById(R.id.tvcustomer_report);
        call = findViewById(R.id.call);
        confirm_booking=findViewById(R.id.bt_confirm);
        navigation=findViewById(R.id.ll_navigation);

        vehicle_image=findViewById(R.id.iv_carimage);
        date=findViewById(R.id.tv_date);
        time=findViewById(R.id.tv_time);
        name=findViewById(R.id.tv_name);
        address=findViewById(R.id.tv_address);
        vehicleBrand=findViewById(R.id.tv_vehiclebrand);
        vehicleName=findViewById(R.id.tv_vehiclename);
        numberPlate=findViewById(R.id.tv_numberPlate);
        serviceName=findViewById(R.id.tv_servicename);

        otpEditText=findViewById(R.id.et_otp);
        otpEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp_input = String.valueOf(((EditText) findViewById(R.id.et_otp)).getText());
                Log.e("TAG",otp_input);
            }
        });

        arrayList=new ArrayList<>();
        arrayListsend=new ArrayList<>();


        Bundle bundle=getIntent().getExtras();
        String name_1 =bundle.getString("name");
        String bookingid =bundle.getString("bookingid");
        String address_1 =bundle.getString("address");
//        double latitude= Double.parseDouble(bundle.getString("latitude"));
    //    double longitude=Double.parseDouble( bundle.getString("longitude"));
        String dropdate=bundle.getString("dropDate");
        String dropTime= bundle.getString("dropTime");
        String amount=bundle.getString("amount");
        String otp_1=bundle.getString("otp");
        String mobileNo=bundle.getString("mobile");
        String vehiclename=bundle.getString("vehiclename");
        String vehiclebrand=bundle.getString("vehiclebrand");
        String numberplate=bundle.getString("numberplate");
        String vehicleImageUrl=bundle.getString("imageurl");
        String servicename=bundle.getString("servicename");
        String action1=bundle.getString("action1");
        String action2=bundle.getString("action2");
        String action3=bundle.getString("action3");
        String action4=bundle.getString("action4");
        String action5=bundle.getString("action5");
        String action6=bundle.getString("action6");
        String action7=bundle.getString("action7");
        String action8=bundle.getString("action8");
        String action9=bundle.getString("action9");
        String action10=bundle.getString("action10");
        String action11=bundle.getString("action11");
        String action12=bundle.getString("action12");
        String action13=bundle.getString("action13");
        String action14=bundle.getString("action14");
        String action15=bundle.getString("action15");
        arrayList.add(action1);
        arrayList.add(action2);
        arrayList.add(action3);
        arrayList.add(action4);
        arrayList.add(action6);
        arrayList.add(action7);
        arrayList.add(action8);
        arrayList.add(action9);
        arrayList.add(action10);
        arrayList.add(action11);
        arrayList.add(action12);
        arrayList.add(action13);
        arrayList.add(action14);
        arrayList.add(action15);

        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).isEmpty()){
                break;
            }else{
                arrayListsend.add(arrayList.get(i));
            }
        }



        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_listView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        adapter = new CustomListAdapter((ArrayList<String>) arrayListsend,"upcoming");
        recyclerView.setAdapter(adapter);

        name.setText(name_1);
        address.setText(address_1);

        //  String d=getFormattedDate("TAG",dropdate);

        date.setText(dropdate);
        time.setText(dropTime);
        vehicleName.setText(vehiclename);
        vehicleBrand.setText(vehiclebrand);
        numberPlate.setText(numberplate);
        serviceName.setText(servicename);



        try{
            Glide.with(UpcomingBookingCustomer.this).load(vehicleImageUrl)
                    .into(vehicle_image);

        }
        catch (Exception e){
            e.printStackTrace();
        }



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml(bookingid));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        tvDetails.setOnClickListener(new View.OnClickListener() {
            int check = 1;

            @Override
            public void onClick(View view) {

                if (check == 1) {
                    recyclerView.setVisibility(View.VISIBLE);
                    check = 0;
                } else {
                    recyclerView.setVisibility(View.GONE);
                    check = 1;
                }


            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callIntent(UpcomingBookingCustomer.this,mobileNo);
            }
        });

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  sendNavigateIntent(UpcomingBookingCustomer.this,latitude,longitude);
            }
        });


        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpcomingBookingCustomer.this, AddCustomerReport.class);
                intent.putExtra("bookingId", bookingid);
                startActivity(intent);
            }
        });

        confirm_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               pickupConfirm(UpcomingBookingCustomer.this);
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

