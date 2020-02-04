package com.naruto.mekvahandelivery.vendor_pickup;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.broooapps.otpedittext2.OtpEditText;
import com.bumptech.glide.Glide;
import com.naruto.mekvahandelivery.NavActivity;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;
import com.naruto.mekvahandelivery.custom_list_data.CustomListAdapter;
import com.naruto.mekvahandelivery.customer_report.ViewCustomerReport;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.callIntent;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.dropConfirm;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.ACCESS_TOKEN;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TOKEN_TYPE;

public class OngoingBookingCustomerDrop extends AppCompatActivity {

    private ArrayList<String> arrayList;
    private ArrayList<String> arrayListsend;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private static final String myUrl = "https://mekvahan.com/api/delivery/ongoing_history";
    private Button btadd_report, bt_drop;
    private LinearLayout navigation;
    private EditText otp;
    private ImageView call,vehicle_image;
    private TextView sub_total,tvDetails, tax, additional_charge, total, nameC, addressC, dateD, timeD,vehicleBrand,vehicleName,numberPlate,serviceName;
    private OtpEditText otpEditText;
    private ProgressDialog mProgressDialog;
    private String otp_input = "0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_booking_customerdrop);


        arrayList = new ArrayList<>();
        arrayListsend = new ArrayList<>();

        tvDetails = findViewById(R.id.tvDetails_1);
        btadd_report = findViewById(R.id.bt_addReport);
        bt_drop = findViewById(R.id.bt_drop);
        navigation = findViewById(R.id.ll_navigation);
        call = findViewById(R.id.call);

        vehicleBrand = findViewById(R.id.tv_vehiclebrand);
        vehicleName = findViewById(R.id.tv_vehiclename);
        numberPlate = findViewById(R.id.tv_numberPlate);
        vehicle_image = findViewById(R.id.iv_carimage);

        sub_total = findViewById(R.id.tv_subtotal);
        tax = findViewById(R.id.tv_tax);
        additional_charge = findViewById(R.id.tv_additonalcharge);
        total = findViewById(R.id.tv_total);
        nameC = findViewById(R.id.tv_name);
        addressC = findViewById(R.id.tv_address);
        dateD = findViewById(R.id.tv_date);
        timeD = findViewById(R.id.tv_time);
        serviceName = findViewById(R.id.tv_servicename);

        //OTP text
        otpEditText = findViewById(R.id.et_otp);
        otpEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp_input = String.valueOf(((EditText) findViewById(R.id.et_otp)).getText());
            }
        });




        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String bookingid = bundle.getString("bookingid");
        String address = bundle.getString("address");
        String vehiclename = bundle.getString("vehiclename");
        String vehiclebrand = bundle.getString("vehiclebrand");
        String numberplate = bundle.getString("numberplate");
        String vehicleImageUrl = bundle.getString("imageurl");
        // double latitude= Double.parseDouble(bundle.getString("latitude"));
        // double longitude=Double.parseDouble( bundle.getString("longitude"));
        String dropdate = bundle.getString("dropDate");
        String dropTime = bundle.getString("dropTime");
        String amount = bundle.getString("amount");
        String otp_1 = bundle.getString("otp");
        String mobileNo = bundle.getString("mobile");
        String vehicle_type = bundle.getString("vehicletype");
        String servicename = bundle.getString("servicename");
        String action1 = bundle.getString("action1");
        String action2 = bundle.getString("action2");
        String action3 = bundle.getString("action3");
        String action4 = bundle.getString("action4");
        String action5 = bundle.getString("action5");
        String action6 = bundle.getString("action6");
        String action7 = bundle.getString("action7");
        String action8 = bundle.getString("action8");
        String action9 = bundle.getString("action9");
        String action10 = bundle.getString("action10");
        String action11 = bundle.getString("action11");
        String action12 = bundle.getString("action12");
        String action13 = bundle.getString("action13");
        String action14 = bundle.getString("action14");
        String action15 = bundle.getString("action15");

        arrayList.add(action1);
        arrayList.add(action2);
        arrayList.add(action3);
        arrayList.add(action4);
        arrayList.add(action5);
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

        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isEmpty()) {
                break;
            } else {
                arrayListsend.add(arrayList.get(i));
            }
        }

        recyclerView = findViewById(R.id.recyclerView_listView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        adapter = new CustomListAdapter(arrayListsend, "ongoing","customer_drop");
        recyclerView.setAdapter(adapter);



        tax.setText("\u20B9" + null);
        additional_charge.setText("\u20B9" + null);
        sub_total.setText("\u20B9 " + amount);
        total.setText("\u20B9 " + amount);
        nameC.setText(name);
        addressC.setText(address);
        dateD.setText(dropdate);
        timeD.setText(dropTime);
        vehicleName.setText(vehiclename);
        vehicleBrand.setText(vehiclebrand);
        numberPlate.setText(numberplate);
        serviceName.setText(servicename);

        try {
            Glide.with(OngoingBookingCustomerDrop.this).load(vehicleImageUrl)
                    .into(vehicle_image);

        } catch (Exception e) {
            e.printStackTrace();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("Order id: " + bookingid));
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
                callIntent(OngoingBookingCustomerDrop.this, mobileNo);
            }
        });


        btadd_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OngoingBookingCustomerDrop.this, ViewCustomerReport.class);
                i.putExtra("vehicletype", vehicle_type);
                i.putExtra("bookingId", bookingid);
                startActivity(i);
            }
        });

        bt_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendDb_pickupConfirm();
            }
        });

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //sendNavigateIntent(OngoingBookingCustomerDrop.this,latitude,longitude);
            }
        });
        mProgressDialog = new ProgressDialog(getApplicationContext());
        mProgressDialog.setMessage("Please wait...");

    }


    private void sendDb_pickupConfirm() {

//       mProgressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, myUrl, response -> {

            try {

                JSONObject object = new JSONObject(response);
                int status_1 = object.getInt("status");
                if (status_1 != 1) {
                    //   mProgressDialog.dismiss();
                    dialogpop();
                    //Toast.makeText(getApplicationContext(),"Incorrect OTP",Toast.LENGTH_SHORT).show();
                    return;
                }
                // mProgressDialog.dismiss();
                dropConfirm(OngoingBookingCustomerDrop.this);
                delay(new NavActivity());


            } catch (Exception e) {
                e.printStackTrace();
            }


        }, error -> {
            //mProgressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            Log.e("TAG", error.toString());
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("otp", otp_input);
                return headers;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Accept", "application/json");
                LoginSessionManager loginSessionManager = new LoginSessionManager(Objects.requireNonNull(getApplication()));
                HashMap<String, String> token = loginSessionManager.getUserDetailsFromSP();
                String token_type = token.get(TOKEN_TYPE);
                String acces_token = token.get(ACCESS_TOKEN);
                headers.put("Authorization", token_type + " " + acces_token);

                return headers;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS * 1000),
                NO_OF_RETRY, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

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

    public void delay(Activity activity) {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(OngoingBookingCustomerDrop.this, activity.getClass());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();


            startActivity(intent);

        }, 800);
    }

    private void dialogpop() {

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setMessage("Incorrect OTP").setCancelable(false);
        alertBuilder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.setTitle("OTP Results");
        alertDialog.show();
    }

}
