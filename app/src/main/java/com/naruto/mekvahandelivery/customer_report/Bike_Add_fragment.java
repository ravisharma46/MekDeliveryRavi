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


public class Bike_Add_fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public Bike_Add_fragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_bike_fragment, container, false);

        onClickListener(v);

        return v;
    }

    private void onClickListener(View v) {
        v.findViewById(R.id.bt_toolkit).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_firstadkit).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_keychain).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_bikecover).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_servicebook).setOnClickListener(this::onButtonPressed);
        v.findViewById(R.id.bt_miscellenoustool).setOnClickListener(this::onButtonPressed);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Car_Add_fragment.OnFragmentInteractionListener) {
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
