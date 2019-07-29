package com.naruto.mekvahandelivery.UpcomingOrders;


import android.content.Context;
import android.content.Intent;
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

import com.naruto.mekvahandelivery.OngoingOrders.MyListDataOngoingBooking;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.customer_pickup.UpcomingBookingCustomer;
import com.naruto.mekvahandelivery.vendor_pickup.UpcomingBookingVendor;

import java.util.ArrayList;


public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {

    private ArrayList<MyListDataUpcomingBooking> dataArrayList;

    public UpcomingAdapter(ArrayList<MyListDataUpcomingBooking> dataArrayList) {
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

        viewHolder.textstatus.setText(data.getDescription());


        String status=data.getDescription();


        if(status.contains("Awaiting customer pickup")){
            viewHolder.cv_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("TAG","click");
                    Intent i = new Intent(view.getContext(), UpcomingBookingCustomer.class);
                    view.getContext().startActivity(i);
                }
            });
        }
        if(status.contains("Awaiting vendor pickup")){
            viewHolder.cv_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.e("TAG","click");
                    Intent i = new Intent(view.getContext(), UpcomingBookingVendor.class);
                    view.getContext().startActivity(i);
                }
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
        private TextView tvorder_id, textstatus, textViewstate, textViewrent, textViewdeposite, textViewaccomd, textViewbed;
        private CardView cv_details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

              cv_details =  itemView.findViewById(R.id.cv_details);
              textstatus=(TextView) itemView.findViewById(R.id.status_U);
//            textViewcity= (TextView) itemView.findViewById(R.id.city_tv);
//            textViewrent= (TextView) itemView.findViewById(R.id.rent_tv);
//            textViewdeposite= (TextView) itemView.findViewById(R.id.deposite_tv);
//            textViewaccomd= (TextView) itemView.findViewById(R.id.accomd_tv);
//            textViewbed= (TextView)itemView.findViewById(R.id.bed_tv);
//
//            imageView =(ImageView) itemView.findViewById(R.id.image_View);
//            linearLayout=(LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}