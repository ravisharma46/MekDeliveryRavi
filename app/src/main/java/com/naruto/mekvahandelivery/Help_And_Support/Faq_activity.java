package com.naruto.mekvahandelivery.help_and_support;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.BulletSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.naruto.mekvahandelivery.R;

public class Faq_activity extends AppCompatActivity {

    private TextView faqtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_activity);

        faqtext = findViewById(R.id.faqText);

        String s = "Frequently Asked Questions (FAQs)\n" +
                "\n" +
                "Why Mekvahan vehicle servicing?\n" +
                " \n" +
                "A curated set of service network partners who follow tightly defined rules and regulations to deliver superior customer experience. Few other benefits to you -\n" +
                "Book a service at any time from Mekvahan website or mobile app & get an instant confirmation.\n" +
                "Doorstep pick up and drop by Mekvahan service providers.\n" +
                "All details about the vehicle (information, pictures, insurance copy, RC if any) captured by the Mekvahan users on the website & mobile apps are used and verified instantly by the service partners and the providers.\n" +
                "All estimates, revised estimates, work detail, service engineer etc are uploaded by the service partners on the Mekvahan Service Partner web & mobile application.\n" +
                "Customers can eventually pay at his doorstep by card or cash. Mekvahan provides an advisory layer for the customer by using historical aggregated data to advise the customer about any abnormal jobs being undertaken by the service center. Mekvahan has an expert team, which then coordinates to clarify and satisfy the customer about these issues.\n" +
                "\n" +
                "1. Is Mekvahan a service center?\n" +
                "\n" +
                "We don’t own physical service centers. Mekvahan is a stack that has partnered with authorized, multi-brand and independent garages with defined specifications and expertise. They have curated their specialization and listed on the Mekvahan platform. We prefer to empower customers with the choice to select their service center depending on the job requirements and customer priorities.\n" +
                "\n" +
                " 2. How is Mekvahan better than other aggregators? \n" +
                "\n" +
                "Mekvahan doesn’t confuse customers with too many options. We keep it simple with few options with best-suited structure and coverage for your vehicle at a very competitive price available in the market. Mekvahan acts as a single point of contact to manage any repair, maintenance service or damage with specifications  in an organized structured way.\n" +
                "\n" +
                "3. Why Mekvahan roadside assistance? \n" +
                "\n" +
                "You can avail emergency assistance (onsite or roadside assistance) on click of a button for towing, breakdown, key recovery, out of fuel, door lock and etc. Most importantly you don’t need any subscription to avail this service and you can track help arriving to you when your family or you are in a distress situation. Always be assured of a Mekvahan assist partner to be around you and reach you within 45 minutes. No more calls and queues when you need quick assistance.\n" +
                "\n" +
                "4. Pickup and drop off service of my vehicle is chargeable or free?\n" +
                "\n" +
                "Absolutely free, Mekvahan gives you free pickup and drop off service (validating certain T&Cs).\n" +
                "\n" +
                "5. Which parts and inventory we use?\n" +
                "\n" +
                "Mekvahan uses only genuine parts and inventory (supplied directly from verified OEMs or OESs) for customer benefit.\n" +
                "\n" +
                "6. Are we providing any warranty period?\n" +
                "\n" +
                "Our every kinds of services comes under the particular warranty period (based upon the class of service availed).\n" +
                "\n" +
                "7. Which type of cars and bikes do we service?\n" +
                "\n" +
                "We service every kind of cars and bikes with accuracy and transparency and if you don’t find any model on our website or mobile app then contact us with our support team 24*7  (+91-7838878888) and get an instant quote.\n" +
                "\n" +
                "8. What is our service hours?\n" +
                "\n" +
                "We give 24*7 services to our esteemed customers.\n" +
                "\n" +
                "9. Which engine oil grade do we use in the car or bike service?\n" +
                "\n" +
                "We use best suitable grades of the top brands available in the market according to the need and model of the vehicle for the engine oil requirements.\n" +
                "\n" +
                "10. What if I face any issue after the service of my car or bike?\n" +
                "\n" +
                "We automatically give you an unconditional warranty period on service for your car/bike when you book your service. Apart from this, our 24x7 customer support are available to assist you.\n" +
                "\n" +
                "11. Why mekvahan is better for your car rather than authorised service centre or local vendor?\n" +
                "\n" +
                "Quality is hard to assure from the local service centres and there is no sense of transparency in the services they provide.\n" +
                "The authorised service centres are unnecessarily expensive and multi-brand workshops don’t have a standard operating procedure. Also, the quotations provided by these centres vary from one another.\n";

        SpannableString spannableString = new SpannableString(s);

        spannableString.setSpan(new StyleSpan(Typeface.BOLD),0,67,0);
        spannableString.setSpan(new RelativeSizeSpan(1.4f),0,34,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),1133 -28,1168-28,0);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            spannableString.setSpan(new BulletSpan(40, Color.BLACK,10),229,321,0);
            spannableString.setSpan(new BulletSpan(40, Color.BLACK,10),323,379,0);
            spannableString.setSpan(new BulletSpan(40, Color.BLACK,10),380,594,0);
            spannableString.setSpan(new BulletSpan(40, Color.BLACK,10),596,758,0);
            spannableString.setSpan(new BulletSpan(40, Color.BLACK,10),759,760+344,0);

        }

        spannableString.setSpan(new StyleSpan(Typeface.BOLD),1554-28,1608-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),1960-28,1999-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),2473-28,2544-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),2569-28,2572-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),2639-28,2680-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),2795-28,2838-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),2951-28,3001-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),3219-28,3252-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),3300-28,3367-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),3516-28,3585-28,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),3773-28,3870-28,0);


        faqtext.setText(spannableString);

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
