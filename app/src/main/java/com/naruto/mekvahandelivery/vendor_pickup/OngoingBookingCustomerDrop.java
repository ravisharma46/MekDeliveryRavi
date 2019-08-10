package com.naruto.mekvahandelivery.vendor_pickup;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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

import com.naruto.mekvahandelivery.R;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.dropConfirm;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.callIntent;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.sendNavigateIntent;
import com.naruto.mekvahandelivery.customer_report.AddCustomerReport;
import com.naruto.mekvahandelivery.customer_report.ViewCustomerReport;

public class OngoingBookingCustomerDrop extends AppCompatActivity {

    private Button btadd_report,bt_drop;
    private LinearLayout navigation;
    private EditText otp;
    private ImageView call;
    private TextView sub_total,tax,additional_charge,total,nameC,addressC,dateD,timeD;

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


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>#123</font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);



        Bundle bundle=getIntent().getExtras();
        String name =bundle.getString("name");
        String address =bundle.getString("address");
       // double latitude= Double.parseDouble(bundle.getString("latitude"));
      //  double longitude=Double.parseDouble( bundle.getString("longitude"));
        String dropdate=bundle.getString("dropDate");
        String dropTime= bundle.getString("dropTime");
        String amount=bundle.getString("amount");
        String otp_1=bundle.getString("otp");
        String mobileNo=bundle.getString("mobile");


        //OTP text
        otp=findViewById(R.id.et_otp);
        String input = String.valueOf(otp.getText());

        tax.setText("\u20B9" + " 00");
        additional_charge.setText("\u20B9" + " 00");
        sub_total.setText("\u20B9 " +amount );
        total.setText("\u20B9 " + amount);
        nameC.setText( name);
        addressC.setText( address);
        dateD.setText( dropdate);
        timeD.setText(dropTime);






       call.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               callIntent(OngoingBookingCustomerDrop.this,mobileNo);
           }
       });





        btadd_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OngoingBookingCustomerDrop.this, ViewCustomerReport.class));
            }
        });

        bt_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG",input);
                dropConfirm(OngoingBookingCustomerDrop.this);
            }
        });

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //sendNavigateIntent(OngoingBookingCustomerDrop.this,latitude,longitude);
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
