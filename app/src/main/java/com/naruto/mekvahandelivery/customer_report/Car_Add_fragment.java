package com.naruto.mekvahandelivery.customer_report;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.naruto.mekvahandelivery.R;



public class Car_Add_fragment extends Fragment {

    private Button Stepney,toolKit,Mudguard,keyChain,serviceBook,Mats,wheelCover,Lock,jackHandle,Carpet,stereoPanel,speakers;

    private  String  booking_id,tool_kit,stepney,mudguard,mats,keychain, service_book, wheel_cover,lock, jack_handle,carpet,stereo_panel,speaker,head_reset,floor_mats,wheel_cap,mud_flap;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_car_fragment, container, false);

        Stepney=v.findViewById(R.id.bt_stepney);
        toolKit=v.findViewById(R.id.bt_toolkit);
        Mudguard=v.findViewById(R.id.bt_mudguard);
        keyChain=v.findViewById(R.id.bt_keychain);
        serviceBook=v.findViewById(R.id.bt_servicebook);
        Mats=v.findViewById(R.id.bt_mats);
        wheelCover=v.findViewById(R.id.bt_wheelcover);
        Lock=v.findViewById(R.id.bt_lock);
        jackHandle=v.findViewById(R.id.bt_jackhandle);
        Carpet=v.findViewById(R.id.bt_carpet);
        stereoPanel=v.findViewById(R.id.bt_stereopanel);
        speakers=v.findViewById(R.id.bt_speakers);


        Stepney.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    Stepney.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    Stepney.setTextColor(Color.WHITE);
                    stepney="1";
                    check = 0;
                } else {
                    Stepney.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    Stepney.setTextColor(Color.BLACK);
                    stepney="0";
                    check = 1;
                }
            }
        });
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
        Mudguard.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    Mudguard.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    Mudguard.setTextColor(Color.WHITE);
                    mudguard="1";
                    check = 0;
                } else {
                    Mudguard.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    Mudguard.setTextColor(Color.BLACK);
                    mudguard="0";
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
                    keychain="1";
                    check = 0;
                } else {
                    keyChain.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    keyChain.setTextColor(Color.BLACK);
                    keychain="0";
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
        Mats.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    Mats.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    Mats.setTextColor(Color.WHITE);
                    mats="1";
                    check = 0;
                } else {
                    Mats.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    Mats.setTextColor(Color.BLACK);
                    mats="0";
                    check = 1;
                }
            }
        });
        wheelCover.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    wheelCover.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    wheelCover.setTextColor(Color.WHITE);
                    wheel_cover="1";
                    check = 0;
                } else {
                    wheelCover.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    wheelCover.setTextColor(Color.BLACK);
                    wheel_cover="0";
                    check = 1;
                }
            }
        });
        Lock.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    Lock.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    Lock.setTextColor(Color.WHITE);
                    lock="1";
                    check = 0;
                } else {
                    Lock.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    Lock.setTextColor(Color.BLACK);
                    lock="0";
                    check = 1;
                }
            }
        });
        jackHandle.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    jackHandle.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    jackHandle.setTextColor(Color.WHITE);
                    jack_handle="1";
                    check = 0;
                } else {
                    jackHandle.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    jackHandle.setTextColor(Color.BLACK);
                    jack_handle="0";
                    check = 1;
                }
            }
        });
        Carpet.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    Carpet.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    Carpet.setTextColor(Color.WHITE);
                    carpet="1";
                    check = 0;
                } else {
                    Carpet.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    Carpet.setTextColor(Color.BLACK);
                    carpet="0";
                    check = 1;
                }
            }
        });
        stereoPanel.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    stereoPanel.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    stereoPanel.setTextColor(Color.WHITE);
                    stereo_panel="1";
                    check = 0;
                } else {
                    stereoPanel.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    stereoPanel.setTextColor(Color.BLACK);
                    stereo_panel="0";
                    check = 1;
                }
            }
        });
        speakers.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    speakers.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    speakers.setTextColor(Color.WHITE);
                    speaker="1";
                    check = 0;
                } else {
                    speakers.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    speakers.setTextColor(Color.BLACK);
                    speaker="0";
                    check = 1;
                }
            }
        });





        return v;
    }


}
