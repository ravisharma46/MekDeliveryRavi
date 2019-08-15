package com.naruto.mekvahandelivery.history;

import android.content.Context;
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

import com.bumptech.glide.Glide;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.ongoing_orders.MyListDataOngoingBooking;

import java.util.ArrayList;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getDate;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getTime;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {


    private Context context;
    private ArrayList<MyListDataOngoingBooking> dataArrayList;

    HistoryAdapter(Context context, ArrayList<MyListDataOngoingBooking> dataArrayList) {
        this.context=context;
        this.dataArrayList = dataArrayList;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_history_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        final MyListDataOngoingBooking data = dataArrayList.get(i);

        holder.carName.setText(data.getModelName());
        holder.service_type.setText(data.getService_name());
        holder.numberPlate.setText(data.getNumberPlate());
        holder.date.setText(getDate(data.getDate()));
        holder.time.setText(getTime(data.getTime()));
        holder.booking.setText(data.getOrderId());
        Glide.with(context).load(data.getLogo())
                .into(holder.carlogo);


//        if (cardata.getProgress().equals("Service Cancelled")) {
//            holder.progress.setTextColor(Color.RED);
//        }




            holder.cv_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i1 = new Intent(view.getContext(), Service_Completed.class);
                    i1.putExtra("amount",data.getAmount());
                    i1.putExtra("bookingid",data.getOrderId());
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

                }
            });



    }

    @Override
    public int getItemCount() {
        if (dataArrayList != null) {
            return dataArrayList.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView carName, numberPlate, service_type, progress,booking,date,time;
        private ImageView carlogo, reasonimg;
        private CardView cv_details;

        private ViewHolder(View view) {
            super(view);
            this.view = view;
            carName = view.findViewById(R.id.car_name);
            booking = view.findViewById(R.id.tvBookinghistory);
            numberPlate = view.findViewById(R.id.numberPlate);
            service_type = view.findViewById(R.id.service_type);
            progress = view.findViewById(R.id.progress);
            carlogo = view.findViewById(R.id.logo);
            reasonimg = view.findViewById(R.id.reasonImg);
            cv_details=view.findViewById(R.id.cv_details);
            time=view.findViewById(R.id.tv_time);
            date=view.findViewById(R.id.tv_date);
        }
    }
}
