package com.naruto.mekvahandelivery.history;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.mekvahandelivery.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private ArrayList<Car_Data> carData;

    public HistoryAdapter(ArrayList<Car_Data> carData) {
        this.carData = carData;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_history_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Car_Data cardata = carData.get(position);

        holder.carName.setText(cardata.getCarName());
        holder.reason.setText(cardata.getReason());
        holder.numberPlate.setText(cardata.getNumberPlate());

        if (cardata.getProgress().equals("Service Cancelled")) {
            holder.progress.setTextColor(Color.RED);
        }
        holder.progress.setText(cardata.getProgress());

        holder.carlogo.setImageResource(cardata.getCarlogo());
        holder.reasonimg.setImageResource(cardata.getReasonImg());

        if (cardata.getProgress().equals("Service Cancelled")) {
            holder.cv_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), Service_Completed.class);
                    i.putExtra("key","service cancelled");
                    view.getContext().startActivity(i);

                }
            });

        }
        else{
            holder.cv_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), Service_Completed.class);
                    view.getContext().startActivity(i);

                }
            });
        }


    }

    @Override
    public int getItemCount() {
        if (carData != null) {
            return carData.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView carName, numberPlate, reason, progress,booking;
        private ImageView carlogo, reasonimg;
        private CardView cv_details;

        private ViewHolder(View view) {
            super(view);
            this.view = view;
            carName = view.findViewById(R.id.car_name);
            booking = view.findViewById(R.id.tvBookinghistory);
            numberPlate = view.findViewById(R.id.numberPlate);
            reason = view.findViewById(R.id.service_type);
            progress = view.findViewById(R.id.progress);
            carlogo = view.findViewById(R.id.logo);
            reasonimg = view.findViewById(R.id.reasonImg);
            cv_details=view.findViewById(R.id.cv_details);
        }
    }
}
