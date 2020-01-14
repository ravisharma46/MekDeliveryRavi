package com.naruto.mekvahandelivery.transaction_history;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naruto.mekvahandelivery.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public ServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_service, container, false);
       // recyclerView = v.findViewById(R.id.recyclerView_1);
       // recyclerView.hasFixedSize();
       // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        //loadRecyclerViewData();

        return v;
    }
    private void loadRecyclerViewData() {
        //adapter = new OrderHistoryAdapter(getContext());
        //recyclerView.setAdapter(adapter);
    }

}
