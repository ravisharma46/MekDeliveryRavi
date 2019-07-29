package com.naruto.mekvahandelivery.Chauffeur_Partner.NewBooking;


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
public class NewBookingFragmentChauffer extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public NewBookingFragmentChauffer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_new_booking_chauffer, container, false);
        ArrayList<MyListDataNewBooking> list = initData();





        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView_new_chauffer);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new NewBookingAdapter(list);
        recyclerView.setAdapter(adapter);
        
        return v;
    }
    private ArrayList<MyListDataNewBooking> initData() {
        ArrayList<MyListDataNewBooking> list = new ArrayList<>();
        list.add(new MyListDataNewBooking("Awaiting confirmation"));
        list.add(new MyListDataNewBooking("Awaiting confirmation"));
        list.add(new MyListDataNewBooking("Awaiting confirmation"));
        list.add(new MyListDataNewBooking("Awaiting confirmation"));

        return list;
    }

}
