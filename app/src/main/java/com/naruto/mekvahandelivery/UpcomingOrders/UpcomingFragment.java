package com.naruto.mekvahandelivery.UpcomingOrders;


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
public class UpcomingFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    public UpcomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_upcoming, container, false);


        ArrayList<MyListDataUpcomingBooking> list = initData();
        
        
        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView_1);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new UpcomingAdapter(list);
        recyclerView.setAdapter(adapter);

      //getActivity().setTitle("Upcoming booking");
     // getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);



        return v;
    }



    private ArrayList<MyListDataUpcomingBooking> initData() {
        ArrayList<MyListDataUpcomingBooking> list = new ArrayList<>();

       // list.add(new MyListDataUpcomingBooking("Awaiting vendor pickup"));
        //list.add(new MyListDataUpcomingBooking("Awaiting customer pickup"));
        //list.add(new MyListDataUpcomingBooking("Awaiting vendor pickup"));
       // list.add(new MyListDataUpcomingBooking("Awaiting customer pickup"));

        return list;
    }

}
