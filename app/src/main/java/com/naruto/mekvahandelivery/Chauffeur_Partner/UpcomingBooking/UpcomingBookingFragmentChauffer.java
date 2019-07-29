package com.naruto.mekvahandelivery.Chauffeur_Partner.UpcomingBooking;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naruto.mekvahandelivery.Chauffeur_Partner.OngoingBooking.OngoingBookingChaufferAdapter;
import com.naruto.mekvahandelivery.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingBookingFragmentChauffer extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public UpcomingBookingFragmentChauffer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_upcoming_booking_fragment_chauffer, container, false);

        ArrayList<MyListDataUpcomingBookingchauffer> list = initData();


        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_upcoming_chauffer);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new UpcomingBookingChaufferAdapter(list);
        recyclerView.setAdapter(adapter);


        return v;
    }

    private ArrayList<MyListDataUpcomingBookingchauffer> initData() {
        ArrayList<MyListDataUpcomingBookingchauffer> list = new ArrayList<>();
        list.add(new MyListDataUpcomingBookingchauffer("Awaiting customer pickup"));
        list.add(new MyListDataUpcomingBookingchauffer("Awaiting customer pickup"));
        list.add(new MyListDataUpcomingBookingchauffer("Awaiting customer pickup"));
        list.add(new MyListDataUpcomingBookingchauffer("Awaiting customer pickup"));

        return list;

    }

}
