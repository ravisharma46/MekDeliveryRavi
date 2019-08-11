package com.naruto.mekvahandelivery.help_and_support;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.naruto.mekvahandelivery.R;

public class Help_and_Support extends AppCompatActivity {

    LinearLayout Reschedule_my_booking ,Change_my_pickup_address, Change_my_drop_address, Cancel_my_order, Talk_to_the_support_team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_and__support);

        Reschedule_my_booking = findViewById(R.id.Reschedule_my_booking);
        Change_my_pickup_address = findViewById(R.id.Change_my_pickup_address);
        Change_my_drop_address = findViewById(R.id.Change_my_drop_address);
        Cancel_my_order = findViewById(R.id.Cancel_my_order);
        Talk_to_the_support_team = findViewById(R.id.Talk_to_the_support_team);

        Reschedule_my_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpAndSupport();
            }
        });

        Change_my_pickup_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpAndSupport();
            }
        });

        Change_my_drop_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpAndSupport();
            }
        });

        Cancel_my_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpAndSupport();
            }
        });

        Talk_to_the_support_team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelpAndSupport();
            }
        });

        //Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        actionBar.setTitle(Html.fromHtml("<Font color='#000000'>Help & Support</Font>"));

        final Drawable upArrow =  ContextCompat.getDrawable(this, R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(ContextCompat.getColor(this, R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    public void HelpAndSupport (){

        Intent helpIntent = new Intent(Help_and_Support.this,Need_help.class);
        startActivity(helpIntent);
    }

}
