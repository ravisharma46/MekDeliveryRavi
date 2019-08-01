package com.naruto.mekvahandelivery.customer_report;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.naruto.mekvahandelivery.R;


public class Bike_Add_fragment extends Fragment {

    private Button toolKit,firstAidKit,keyChain,bikeCover,serviceBook,miscellnousTool;

    private String tool_kit,first_aid_kit, key_chain,bike_cover,service_book,miscellneous_tools;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_bike_fragment, container, false);

        toolKit=v.findViewById(R.id.bt_toolkit);
        firstAidKit=v.findViewById(R.id.bt_firstadkit);
        keyChain=v.findViewById(R.id.bt_keychain);
        bikeCover=v.findViewById(R.id.bt_bikecover);
        serviceBook=v.findViewById(R.id.bt_servicebook);
        miscellnousTool=v.findViewById(R.id.bt_miscellenoustool);

        toolKit.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    toolKit.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    toolKit.setTextColor(Color.WHITE);
                    tool_kit="1";
                    check = 0;
                } else {
                    toolKit.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    toolKit.setTextColor(Color.BLACK);
                    tool_kit="0";
                    check = 1;
                }
            }
        });
        firstAidKit.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    firstAidKit.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    firstAidKit.setTextColor(Color.WHITE);
                    first_aid_kit="1";
                    check = 0;
                } else {
                    firstAidKit.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    firstAidKit.setTextColor(Color.BLACK);
                    first_aid_kit="0";
                    check = 1;
                }
            }
        });
        keyChain.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    keyChain.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    keyChain.setTextColor(Color.WHITE);
                    key_chain="1";
                    check = 0;
                } else {
                    keyChain.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    keyChain.setTextColor(Color.BLACK);
                    key_chain="0";
                    check = 1;
                }
            }
        });
        bikeCover.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    bikeCover.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    bikeCover.setTextColor(Color.WHITE);
                    bike_cover="1";
                    check = 0;
                } else {
                    bikeCover.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    bikeCover.setTextColor(Color.BLACK);
                    bike_cover="0";
                    check = 1;
                }
            }
        });
        serviceBook.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    serviceBook.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    serviceBook.setTextColor(Color.WHITE);
                    service_book="1";
                    check = 0;
                } else {
                    serviceBook.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    serviceBook.setTextColor(Color.BLACK);
                    service_book="0";
                    check = 1;
                }
            }
        });
        miscellnousTool.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    miscellnousTool.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    miscellnousTool.setTextColor(Color.WHITE);
                    miscellneous_tools="1";
                    check = 0;
                } else {
                    miscellnousTool.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    miscellnousTool.setTextColor(Color.BLACK);
                    miscellneous_tools="0";
                    check = 1;
                }
            }
        });



        return v;
    }

}
