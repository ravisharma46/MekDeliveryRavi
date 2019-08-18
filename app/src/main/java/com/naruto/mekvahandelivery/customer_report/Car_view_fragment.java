package com.naruto.mekvahandelivery.customer_report;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.naruto.mekvahandelivery.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Car_view_fragment extends Fragment {

//    private OnFragmentInteractionListener mListener;
//    Button btvrc;

    public Car_view_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_car_view_fragment, container, false);
//        btvrc = view.findViewById(R.id.bt_vrc);
//        onClickListener(view);
        return view;
    }

//    private void onClickListener(View v) {
//        v.findViewById(R.id.bt_cvstepney).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvtoolkit).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvmudguard).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvkeychain).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvservicebook).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvmats).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvwheelcover).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvlock).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvjackhandle).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvcarpet).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvstereopanel).setOnClickListener(this::onButtonPressed);
//        v.findViewById(R.id.bt_cvspeakers).setOnClickListener(this::onButtonPressed);
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
