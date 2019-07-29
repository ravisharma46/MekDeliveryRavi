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

    private Button stepney,toolKit,mudguard,keyChain,serviceBook,mats,wheelCover,lock,jackHandle,carpet,stereoPanel,speakers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_car_fragment, container, false);

        stepney=v.findViewById(R.id.bt_stepney);
        toolKit=v.findViewById(R.id.bt_toolkit);
        mudguard=v.findViewById(R.id.bt_mudguard);
        keyChain=v.findViewById(R.id.bt_keychain);
        serviceBook=v.findViewById(R.id.bt_servicebook);
        mats=v.findViewById(R.id.bt_mats);
        wheelCover=v.findViewById(R.id.bt_wheelcover);
        lock=v.findViewById(R.id.bt_lock);
        jackHandle=v.findViewById(R.id.bt_jackhandle);
        carpet=v.findViewById(R.id.bt_carpet);
        stereoPanel=v.findViewById(R.id.bt_stereopanel);
        speakers=v.findViewById(R.id.bt_speakers);


        stepney.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    stepney.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    stepney.setTextColor(Color.WHITE);
                    check = 0;
                } else {
                    stepney.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    stepney.setTextColor(Color.BLACK);
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
                    check = 0;
                } else {
                    toolKit.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    toolKit.setTextColor(Color.BLACK);
                    check = 1;
                }
            }
        });
        mudguard.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    mudguard.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    mudguard.setTextColor(Color.WHITE);
                    check = 0;
                } else {
                    mudguard.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    mudguard.setTextColor(Color.BLACK);
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
                    check = 0;
                } else {
                    keyChain.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    keyChain.setTextColor(Color.BLACK);
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
                    check = 0;
                } else {
                    serviceBook.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    serviceBook.setTextColor(Color.BLACK);
                    check = 1;
                }
            }
        });
        mats.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    mats.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    mats.setTextColor(Color.WHITE);
                    check = 0;
                } else {
                    mats.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    mats.setTextColor(Color.BLACK);
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
                    check = 0;
                } else {
                    wheelCover.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    wheelCover.setTextColor(Color.BLACK);
                    check = 1;
                }
            }
        });
        lock.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    lock.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    lock.setTextColor(Color.WHITE);
                    check = 0;
                } else {
                    lock.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    lock.setTextColor(Color.BLACK);
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
                    check = 0;
                } else {
                    jackHandle.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    jackHandle.setTextColor(Color.BLACK);
                    check = 1;
                }
            }
        });
        carpet.setOnClickListener(new View.OnClickListener() {
            int check = 1;
            @Override
            public void onClick(View view) {
                if (check == 1) {
                    carpet.setBackgroundResource(R.drawable.customer_reprt_bt02);
                    carpet.setTextColor(Color.WHITE);
                    check = 0;
                } else {
                    carpet.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    carpet.setTextColor(Color.BLACK);
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
                    check = 0;
                } else {
                    stereoPanel.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    stereoPanel.setTextColor(Color.BLACK);
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
                    check = 0;
                } else {
                    speakers.setBackgroundResource(R.drawable.customer_rprt_bt01);
                    speakers.setTextColor(Color.BLACK);
                    check = 1;
                }
            }
        });





        return v;
    }


}
