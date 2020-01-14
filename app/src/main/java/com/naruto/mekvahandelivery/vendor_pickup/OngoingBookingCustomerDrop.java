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

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.broooapps.otpedittext2.OtpEditText;
import com.naruto.mekvahandelivery.NavActivity;
import com.naruto.mekvahandelivery.R;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.dropConfirm;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.callIntent;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.pickupConfirm;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.ACCESS_TOKEN;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TOKEN_TYPE;

import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;
import com.naruto.mekvahandelivery.customer_pickup.UpcomingBookingCustomer;
import com.naruto.mekvahandelivery.customer_report.ViewCustomerReport;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OngoingBookingCustomerDrop extends AppCompatActivity {

    private Button btadd_report,bt_drop;
    private LinearLayout navigation;
    private EditText otp;
    private ImageView call;
    private TextView sub_total,tax,additional_charge,total,nameC,addressC,dateD,timeD;
    private OtpEditText otpEditText;
    private ProgressDialog mProgressDialog;
    private String otp_input="0000";
    private static final String myUrl = "https://mekvahan.com/api/delivery/ongoing_history";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_booking_customerdrop);

        btadd_report= findViewById(R.id.bt_addReport);
        bt_drop=findViewById(R.id.bt_drop);
        navigation=findViewById(R.id.ll_navigation);
        call=findViewById(R.id.call);

        sub_total=findViewById(R.id.tv_subtotal);
        tax=findViewById(R.id.tv_tax);
        additional_charge=findViewById(R.id.tv_additonalcharge);
        total=findViewById(R.id.tv_total);
        nameC=findViewById(R.id.tv_name);
        addressC=findViewById(R.id.tv_address);
        dateD=findViewById(R.id.tv_date);
        timeD=findViewById(R.id.tv_time);
        //OTP text
        otpEditText=findViewById(R.id.et_otp);
        otpEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp_input = String.valueOf(((EditText) findViewById(R.id.et_otp)).getText());
            }
        });



        Bundle bundle=getIntent().getExtras();
        String name =bundle.getString("name");
        String bookingid =bundle.getString("bookingid");
        String address =bundle.getString("address");
       // double latitude= Double.parseDouble(bundle.getString("latitude"));
      // double longitude=Double.parseDouble( bundle.getString("longitude"));
        String dropdate=bundle.getString("dropDate");
        String dropTime= bundle.getString("dropTime");
        String amount=bundle.getString("amount");
        String otp_1=bundle.getString("otp");
        String mobileNo=bundle.getString("mobile");
        String vehicle_type=bundle.getString("vehicletype");



        tax.setText("\u20B9" + null);
        additional_charge.setText("\u20B9" + null);
        sub_total.setText("\u20B9 " +amount );
        total.setText("\u20B9 " + amount);
        nameC.setText( name);
        addressC.setText( address);
        dateD.setText( dropdate);
        timeD.setText(dropTime);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml(bookingid));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);





       call.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               callIntent(OngoingBookingCustomerDrop.this,mobileNo);
           }
       });





        btadd_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i=new Intent(OngoingBookingCustomerDrop.this,ViewCustomerReport.class);
               i.putExtra("vehicletype",vehicle_type);
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


    private void sendDb_pickupConfirm(){

//       mProgressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST,myUrl, response -> {

            try{

                JSONObject object=new JSONObject(response);
                int status_1 = object.getInt("status");
                if(status_1!=1) {
                 //   mProgressDialog.dismiss();
                    dialogpop();
                    //Toast.makeText(getApplicationContext(),"Incorrect OTP",Toast.LENGTH_SHORT).show();
                    return;
                }
               // mProgressDialog.dismiss();
                dropConfirm(OngoingBookingCustomerDrop.this);
                delay(new NavActivity());


            }
            catch (Exception e){
                e.printStackTrace();
            }




        },error -> {
            //mProgressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
            Log.e("TAG", error.toString());
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> headers=new HashMap<>();
                headers.put("otp",otp_input);
                return headers;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers=new HashMap<>();
                headers.put("Accept","application/json");
                LoginSessionManager loginSessionManager=new LoginSessionManager(Objects.requireNonNull(getApplication()));
                HashMap<String,String> token=loginSessionManager.getUserDetailsFromSP();
                String token_type=token.get(TOKEN_TYPE);
                String acces_token= token.get(ACCESS_TOKEN);
                headers.put("Authorization",token_type+" "+acces_token);

                return headers;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

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

    public void delay(Activity activity){
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(OngoingBookingCustomerDrop.this, activity.getClass());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();


            startActivity(intent);

        }, 800);
    }

    private void dialogpop(){

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
