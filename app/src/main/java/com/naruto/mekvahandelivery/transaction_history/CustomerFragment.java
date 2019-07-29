package com.naruto.mekvahandelivery.transaction_history;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naruto.mekvahandelivery.R;


public class CustomerFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_customer, container, false);


        recyclerView = v.findViewById(R.id.recyclerView_1);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        loadRecyclerViewData();

        return v;
    }
    private void loadRecyclerViewData() {
        adapter = new OrderHistoryAdapter(getActivity());
        recyclerView.setAdapter(adapter);
    }



}
