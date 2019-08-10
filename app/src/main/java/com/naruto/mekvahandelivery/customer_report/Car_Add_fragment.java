package com.naruto.mekvahandelivery.customer_report;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.naruto.mekvahandelivery.R;

public class Car_Add_fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public Car_Add_fragment () {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_car_fragment, container, false);

        onClickListener(v);
        return v;
    }

    private void onClickListener(View v) {
        v.findViewById(R.id.bt_stepney).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_toolkit).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_mudguard).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_keychain).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_servicebook).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_mats).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_wheelcover).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_lock).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_jackhandle).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_carpet).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_stereopanel).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_speakers).setOnClickListener(this::onButtonPressed);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private void onButtonPressed(View view) {
        if (mListener != null) {
            mListener.onFragmentInteraction(view);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(View view);
    }
}
