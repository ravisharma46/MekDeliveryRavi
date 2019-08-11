package com.naruto.mekvahandelivery.help_and_support;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.naruto.mekvahandelivery.R;

public class Mek_Legel_Activity extends AppCompatActivity {

    private TextView txtdisclaimer,terms_and_conditions,terms_of_use, privacy_policy,disclaimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mek__legel_);

        txtdisclaimer = findViewById(R.id.disclaimer);
        terms_and_conditions = findViewById(R.id.terms_and_conditions);
        terms_of_use = findViewById(R.id.terms_of_use);
        privacy_policy = findViewById(R.id.privacy_policy);


        privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent privacyIntent = new Intent(Mek_Legel_Activity.this,Privacy_policy.class);
                startActivity(privacyIntent);
            }
        });

        terms_of_use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent termsOfUseIntent = new Intent(Mek_Legel_Activity.this,Terms_Of_Use.class);
                startActivity(termsOfUseIntent);
            }
        });

        terms_and_conditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent TandCIntent = new Intent(Mek_Legel_Activity.this,Terms_and_Conditions.class);
                startActivity(TandCIntent);
            }
        });

        txtdisclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent disclaimIntent = new Intent(Mek_Legel_Activity.this, Disclaimer.class);
                startActivity(disclaimIntent);
            }
        });


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        actionBar.setTitle(Html.fromHtml("<Font color='#000000'>Order #123</Font>"));

        final Drawable upArrow =  ContextCompat.getDrawable(this, R.drawable.back_arrow);
        upArrow.setColorFilter(ContextCompat.getColor(this, R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }
}
