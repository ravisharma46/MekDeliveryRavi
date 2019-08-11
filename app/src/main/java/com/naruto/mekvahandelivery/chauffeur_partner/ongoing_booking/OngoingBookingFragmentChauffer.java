package com.naruto.mekvahandelivery.chauffeur_partner.ongoing_booking;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naruto.mekvahandelivery.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class OngoingBookingFragmentChauffer extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    public OngoingBookingFragmentChauffer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_ongoing_booking_fragment_chauffer, container, false);

        ArrayList<MyListDataOngoingBookingchauffer> list = initData();

        




        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView_ongoing_chauffer);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new OngoingBookingChaufferAdapter(list);
        recyclerView.setAdapter(adapter);

        return v;
    }
    private ArrayList<MyListDataOngoingBookingchauffer> initData() {
        ArrayList<MyListDataOngoingBookingchauffer> list = new ArrayList<>();
        list.add(new MyListDataOngoingBookingchauffer("Awaiting customer drop off"));
        list.add(new MyListDataOngoingBookingchauffer("Awaiting customer drop off"));
        list.add(new MyListDataOngoingBookingchauffer("Awaiting customer drop off"));
        list.add(new MyListDataOngoingBookingchauffer("Awaiting customer drop off"));

        return list;
    }


}
