package com.naruto.mekvahandelivery.OngoingOrders;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.customer_pickup.OnGoingBookingVendorDrop;
import com.naruto.mekvahandelivery.vendor_pickup.OngoingBookingCustomerDrop;
import com.squareup.picasso.Picasso;

import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.getFormattedDate;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.getFormattedTime;


import java.util.ArrayList;


public class OngoingAdapter_1 extends RecyclerView.Adapter<OngoingAdapter_1.ViewHolder> {

    private Context context;
    private ArrayList<MyListDataOngoingBooking> dataArrayList;



    public OngoingAdapter_1(Context context,ArrayList<MyListDataOngoingBooking> dataArrayList) {
        this.context=context;
        this.dataArrayList = dataArrayList;

    }

    @NonNull
    @Override
    public OngoingAdapter_1.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_item, viewGroup, false);
        return new OngoingAdapter_1.ViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

       final MyListDataOngoingBooking data = dataArrayList.get(i);

       viewHolder.textViewstatus.setText(data.getstatus());


        viewHolder.tv_date.setText(data.getDate());
        viewHolder.tv_time.setText(data.getTime());

        viewHolder.tv_modelName.setText(data.getModelName());
        viewHolder.tv_numberPlate.setText(data.getNumberPlate());
        viewHolder.tv_bookingid.setText(data.getOrderId());
        viewHolder.tv_serviceType.setText(data.getService_name());

        String payment_status=data.getPayment_status();
        if(payment_status.contains("Payment awaiting")){
            viewHolder.tv_paymentStatus.setText(payment_status);
            viewHolder.tv_paymentStatus.setTextColor(Color.RED);
        }




        Glide.with(context).load(data.getLogo())
                .into(viewHolder.iv_logo);





        //viewHolder.textViewRupee.setText("\u20B9" + " 99");

        String status=data.getstatus();


        if (status.contains("Awaiting customer drop off")) {
            viewHolder.cv_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), OngoingBookingCustomerDrop.class);
                    view.getContext().startActivity(i);

                }
            });

        }

        if (status.contains("Awaiting partner dropoff")) {
            viewHolder.cv_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent i = new Intent(view.getContext(), OnGoingBookingVendorDrop.class);
                    Intent i = new Intent(view.getContext(), OngoingBookingCustomerDrop.class);
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
        private TextView tv_bookingid, textViewstatus, tv_numberPlate,tv_serviceType,tv_paymentStatus,tv_date,tv_time,tv_modelName;
        private ImageView iv_logo;
        private CardView cv_details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cv_details= itemView.findViewById(R.id.cv_details);
            textViewstatus= itemView.findViewById(R.id.status);
            tv_bookingid= itemView.findViewById(R.id.booking_id);
            tv_numberPlate= itemView.findViewById(R.id.numberPlate);
            tv_serviceType= itemView.findViewById(R.id.service_type);
            tv_paymentStatus= itemView.findViewById(R.id.payment_status);
            tv_date= itemView.findViewById(R.id.date);
            tv_time= itemView.findViewById(R.id.time);
            tv_modelName= itemView.findViewById(R.id.mode_name);
            iv_logo= itemView.findViewById(R.id.logo);




        }
    }
}