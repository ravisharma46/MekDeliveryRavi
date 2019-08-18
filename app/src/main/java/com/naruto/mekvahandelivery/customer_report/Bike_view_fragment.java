package com.naruto.mekvahandelivery.customer_report;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.naruto.mekvahandelivery.R;

public class Bike_view_fragment extends Fragment {

//    private OnFragmentInteractionListener mListener;

    public Bike_view_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_bike_view_fragment, container, false);

//        onClickListener(view);
        return view;
    }

//    private void onClickListener(View v) {
//        v.findViewById(R.id.bt_bvtoolkit).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_bvfirstadkit).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_bvkeychain).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_bvbikecover).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_bvservicebook).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_bvmiscellenoustool).setOnClickListener(this::onButtonPressed);
//    }
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    private void onButtonPressed(View view) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(view);
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    public interface OnFragmentInteractionListener {
//        void onFragmentInteraction(View view);
//    }

}
