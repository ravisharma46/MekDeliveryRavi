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
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.naruto.mekvahandelivery.R;

public class Help extends AppCompatActivity {

    private TextView btn_faqs, btn_MekLegal,btn_Mek_general_queries;
    LinearLayout btn_customer_support, btn_need_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        btn_customer_support = findViewById(R.id.btn_customer_support);
        btn_need_help  = findViewById(R.id.btn_need_help);
        btn_faqs = findViewById(R.id.btn_faqs);
        btn_Mek_general_queries = findViewById(R.id.btn_Mek_general_queries);
        btn_MekLegal = findViewById(R.id.btn_MekLegal);


        btn_MekLegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent legalIntent = new Intent(Help.this,Mek_Legel_Activity.class);
                startActivity(legalIntent);
            }
        });

        btn_customer_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent customerSupport = new Intent(Help.this, Help_and_Support.class);
                startActivity(customerSupport);
            }
        });

        btn_faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent faqIntetnt = new Intent(Help.this,Faq_activity.class);
                startActivity(faqIntetnt);
            }
        });

        //Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        actionBar.setTitle(Html.fromHtml("<Font color='#000000'>Help</Font>"));

        final Drawable upArrow =  ContextCompat.getDrawable(this, R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(ContextCompat.getColor(this, R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }
}
