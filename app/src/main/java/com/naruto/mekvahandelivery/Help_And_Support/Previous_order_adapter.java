package com.naruto.mekvahandelivery.help_and_support;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.naruto.mekvahandelivery.R;

import java.util.ArrayList;

public class Previous_order_adapter extends RecyclerView.Adapter<Previous_order_adapter.ViewHolder> {

    private ArrayList<PreviousOrdersData> previousOrdersData;

    public Previous_order_adapter(ArrayList<PreviousOrdersData> previousOrdersData) {
        this.previousOrdersData = previousOrdersData;
    }

    @NonNull
    @Override
    public Previous_order_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.previous_orders_itmes, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Previous_order_adapter.ViewHolder holder, int position) {

        PreviousOrdersData previous_ordersData = previousOrdersData.get(position);

        holder.carName.setText(previous_ordersData.getCarName());
        holder.reason.setText(previous_ordersData.getReason());
        holder.numberPlate.setText(previous_ordersData.getNumberPlate());

        if(previous_ordersData.getProgress().equals("Service Cancelled")){
            holder.progress.setTextColor(Color.RED);
        }
        holder.progress.setText(previous_ordersData.getProgress());

        holder.carlogo.setImageResource(previous_ordersData.getCarlogo());
        holder.reasonimg.setImageResource(previous_ordersData.getReasonImg());
    }

    @Override
    public int getItemCount() {
        if (previousOrdersData != null) {
            return previousOrdersData.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView carName,numberPlate,reason,progress;
        public ImageView carlogo,reasonimg;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            carName = view.findViewById(R.id.car_name);
            numberPlate = view.findViewById(R.id.numberPlate);
            reason = view.findViewById(R.id.service_type);
            progress = view.findViewById(R.id.progress);
            carlogo = view.findViewById(R.id.logo);
            reasonimg = view.findViewById(R.id.reasonImg);
        }
    }
}
