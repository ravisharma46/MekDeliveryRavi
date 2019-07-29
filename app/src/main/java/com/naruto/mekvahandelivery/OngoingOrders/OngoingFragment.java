package com.naruto.mekvahandelivery.OngoingOrders;


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
public class OngoingFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public OngoingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_ongoing, container, false);

        ArrayList<MyListDataOngoingBooking> list = initData();





        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new OngoingAdapter_1(list);
        recyclerView.setAdapter(adapter);


        return v;
    }


    private ArrayList<MyListDataOngoingBooking> initData() {
        ArrayList<MyListDataOngoingBooking> list = new ArrayList<>();
        list.add(new MyListDataOngoingBooking("Awaiting vendor drop off"));
        list.add(new MyListDataOngoingBooking("Awaiting customer drop off"));
        list.add(new MyListDataOngoingBooking("Awaiting vendor drop off"));
        list.add(new MyListDataOngoingBooking("Awaiting customer drop off"));

        return list;
    }


}
