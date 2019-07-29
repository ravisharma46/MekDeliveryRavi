package com.naruto.mekvahandelivery.history;


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
public class BookingHistoryFragment extends Fragment {

    private RecyclerView carRecycleView;
    private RecyclerView.Adapter carAdapter;

    public BookingHistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_booking_history, container, false);


        ArrayList<Car_Data> list = initCarData();

        carRecycleView = v.findViewById(R.id.carRecycleView);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getActivity());
        carRecycleView.setLayoutManager(mlayoutManager);


        carAdapter = new HistoryAdapter(list);
        carRecycleView.setAdapter(carAdapter);


        return v;
    }

    private ArrayList<Car_Data> initCarData() {

        ArrayList<Car_Data> list = new ArrayList<>();

        list.add(new Car_Data("Wagonar R", "DL1PB3201", "Denting Painting", "Service Completed", R.drawable.wagonr_logo, R.drawable.denting_painting));
        list.add(new Car_Data("Audi", "DL1PB3201", "Emergency Towing", "Service Completed", R.drawable.audi, R.drawable.emergency_towning_new));
        list.add(new Car_Data("Audi", "DL1PB3201", "Flat Tyre", "Service Cancelled", R.drawable.audi, R.drawable.flat_tyre));
        list.add(new Car_Data("Wagonar R", "DL1PB3201", "Battery jumpstart", "Service Completed", R.drawable.wagonr_logo, R.drawable.battery_jumpstart));
        list.add(new Car_Data("Audi", "DL1PB3201", "Key recovery", "Service Completed", R.drawable.audi, R.drawable.key_recovery));
        list.add(new Car_Data("Audi", "DL1PB3201", "Onsite assistance", "Service Cancelled", R.drawable.audi, R.drawable.onsite_assistance));

        return list;

    }

}
