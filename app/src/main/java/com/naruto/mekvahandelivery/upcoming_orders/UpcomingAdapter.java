package com.naruto.mekvahandelivery.upcoming_orders;

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
import com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions;

import java.util.ArrayList;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getDate;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getTime;

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

        viewHolder.date.setText(getDate(data.getDate()));
        viewHolder.time.setText(getTime(data.getTime()));

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



        String service_name=data.getService_type();
        int statusid=data.getStatus_id();



        if(service_name.contains("regular_service")){
            if(statusid==5){
                viewHolder.cv_details.setOnClickListener(view -> {
                    Intent i1 = new Intent(view.getContext(), UpcomingBookingCustomer.class);
                    i1.putExtra("name",data.getName());
                    i1.putExtra("bookingid",data.getOrderId());
                    i1.putExtra("address",data.getAddress());
                    i1.putExtra("latitude",data.getLatitude());
                    i1.putExtra("longitude",data.getLongitude());
                    i1.putExtra("dropDate",data.getDrop_date());
                    i1.putExtra("dropTime",data.getDrop_time());
                    i1.putExtra("amount",data.getAmount());
                    i1.putExtra("otp",data.getOtp());
                    i1.putExtra("mobile",data.getMobile());
                    i1.putExtra("vehiclename",data.getModelName());
                    i1.putExtra("vehiclebrand",data.getVehicleBrand());
                    i1.putExtra("numberplate",data.getNumberPlate());
                    i1.putExtra("imageurl",data.getImage_url());
                    i1.putExtra("servicename",data.getService_name());
                    i1.putExtra("action1",data.getAction1());
                    i1.putExtra("action2",data.getAction2());
                    i1.putExtra("action3",data.getAction3());
                    i1.putExtra("action4",data.getAction4());
                    i1.putExtra("action5",data.getAction5());
                    i1.putExtra("action6",data.getAction6());
                    i1.putExtra("action7",data.getAction7());
                    i1.putExtra("action8",data.getAction8());
                    i1.putExtra("action9",data.getAction9());
                    i1.putExtra("action10",data.getAction10());
                    i1.putExtra("action11",data.getAction11());
                    i1.putExtra("action12",data.getAction12());
                    i1.putExtra("action13",data.getAction13());
                    i1.putExtra("action14",data.getAction14());
                    i1.putExtra("action15",data.getAction14());
                    view.getContext().startActivity(i1);
                });
            }
            if(statusid==8){
                viewHolder.cv_details.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i1 = new Intent(view.getContext(), UpcomingBookingVendor.class);

                        view.getContext().startActivity(i1);
                    }
                });
            }

        }
        if(service_name.contains("sos_service")){
            viewHolder.cv_details.setOnClickListener(view -> {
                Intent i1 = new Intent(view.getContext(), UpcomingBookingCustomer.class);
                i1.putExtra("name",data.getName());
                i1.putExtra("bookingid",data.getOrderId());
                i1.putExtra("address",data.getAddress());
                i1.putExtra("latitude",data.getLatitude());
                i1.putExtra("longitude",data.getLongitude());
                i1.putExtra("dropDate",data.getDrop_date());
                i1.putExtra("dropTime",data.getDrop_time());
                i1.putExtra("amount",data.getAmount());
                i1.putExtra("otp",data.getOtp());
                i1.putExtra("mobile",data.getMobile());
                i1.putExtra("vehiclename",data.getModelName());
                i1.putExtra("vehiclebrand",data.getVehicleBrand());
                i1.putExtra("numberplate",data.getNumberPlate());
                i1.putExtra("imageurl",data.getImage_url());
                i1.putExtra("servicename",data.getService_name());
                i1.putExtra("action1",data.getAction1());
                i1.putExtra("action2",data.getAction2());
                i1.putExtra("action3",data.getAction3());
                i1.putExtra("action4",data.getAction4());
                i1.putExtra("action5",data.getAction5());
                i1.putExtra("action6",data.getAction6());
                i1.putExtra("action7",data.getAction7());
                i1.putExtra("action8",data.getAction8());
                i1.putExtra("action9",data.getAction9());
                i1.putExtra("action10",data.getAction10());
                i1.putExtra("action11",data.getAction11());
                i1.putExtra("action12",data.getAction12());
                i1.putExtra("action13",data.getAction13());
                i1.putExtra("action14",data.getAction14());
                i1.putExtra("action15",data.getAction14());
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
        private TextView  textstatus,carName, noPlate, paymentStatus,orderId,time,date,serviceType;
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