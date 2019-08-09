package com.naruto.mekvahandelivery.UpcomingOrders;


import com.bumptech.glide.Glide;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.customer_pickup.UpcomingBookingCustomer;
import com.naruto.mekvahandelivery.vendor_pickup.UpcomingBookingVendor;

import java.util.ArrayList;


public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MyListDataUpcomingBooking> dataArrayList;

    UpcomingAdapter(Context context, ArrayList<MyListDataUpcomingBooking> dataArrayList) {
        this.context=context;
       this.dataArrayList=dataArrayList;
    }

    @NonNull
    @Override
    public UpcomingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_item1, viewGroup, false);
        return new UpcomingAdapter.ViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull UpcomingAdapter.ViewHolder viewHolder, int i) {



        final MyListDataUpcomingBooking data = dataArrayList.get(i);

        viewHolder.textstatus.setText(data.getstatus());
        viewHolder.date.setText(data.getDate());
        viewHolder.time.setText(data.getTime());

        viewHolder.carName.setText(data.getModelName());
        viewHolder.noPlate.setText(data.getNumberPlate());
        viewHolder.orderId.setText(data.getOrderId());
        viewHolder.serviceType.setText(data.getService_name());

        String payment_status=data.getPayment_status();
        if(payment_status.contains("Payment awaiting")){
            viewHolder.paymentStatus.setText(payment_status);
            viewHolder.paymentStatus.setTextColor(Color.RED);
        }

        Glide.with(context).load(data.getLogo())
                .into(viewHolder.logo);


        String status=data.getstatus();


        if(status.contains("Awaiting customer pickup")){
            viewHolder.cv_details.setOnClickListener(view -> {
                Log.e("TAG","click");
                Intent i12 = new Intent(view.getContext(), UpcomingBookingCustomer.class);
                view.getContext().startActivity(i12);
            });
        }
        if(status.contains("Awaiting vendor pickup")){
            viewHolder.cv_details.setOnClickListener(view -> {
                Log.e("TAG","click");
                Intent i1 = new Intent(view.getContext(), UpcomingBookingVendor.class);
//                i1.putExtra("name",data.getName());
//                i1.putExtra("address",data.getAddress());
//                i1.putExtra("latitude",data.getLatitude());
//                i1.putExtra("longitude",data.getLongitude());
//                i1.putExtra("dropDate",data.getDrop_date());
//                i1.putExtra("dropTime",data.getDrop_time());
//                i1.putExtra("amount",data.getAmount());
//                i1.putExtra("otp",data.getOtp());
//                i1.putExtra("mobile",data.getMobile());
                view.getContext().startActivity(i1);
            });
        }

        
    }

    @Override
    public int getItemCount() {
        if (dataArrayList != null) {
            return dataArrayList.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvorder_id, textstatus, textViewstate, carName, noPlate, paymentStatus, textViewbed,orderId,time,date,serviceType;
        private CardView cv_details;
        private LinearLayout connect;
        private ImageView logo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cv_details =  itemView.findViewById(R.id.cv_details);
            orderId = itemView.findViewById(R.id.order_id_1);
            logo= itemView.findViewById(R.id.logo);
            carName= itemView.findViewById(R.id.car_name);
            noPlate= itemView.findViewById(R.id.numberPlate);
            paymentStatus= itemView.findViewById(R.id.payment_confirm);
            textstatus= itemView.findViewById(R.id.status_U);
            time=itemView.findViewById(R.id.time);
            date=itemView.findViewById(R.id.date);
            serviceType=itemView.findViewById(R.id.service_type);


            connect=itemView.findViewById(R.id.connectButton);
//
//            imageView =(ImageView) itemView.findViewById(R.id.image_View);
//            linearLayout=(LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}