package com.naruto.mekvahandelivery.transaction_history;

import android.content.Context;
import android.content.Intent;
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
import com.naruto.mekvahandelivery.upcoming_orders.MyListDataUpcomingBooking;
import com.naruto.mekvahandelivery.vendor_pickup.UpcomingBookingVendor;

import java.util.ArrayList;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getDate;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getTime;

public class OrderHistoryAdapter extends RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MyListDataUpcomingBooking> dataArrayList;

   public OrderHistoryAdapter (Context context, ArrayList<MyListDataUpcomingBooking> dataArrayList) {
        this.context=context;
        this.dataArrayList=dataArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.order_history_list, viewGroup, false);
        return new ViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final MyListDataUpcomingBooking data = dataArrayList.get(i);

        viewHolder.textViewtotal.setText("Total " + "\u20B9 " + data.getMy_amount());
        viewHolder.tv_date.setText(getDate(data.getDate()));
        viewHolder.tv_time.setText(getTime(data.getTime()));


        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(view.getContext(), Transaction.class);
                i1.putExtra("date",getDate(data.getDate()));
                i1.putExtra("time",getTime(data.getTime()));
                i1.putExtra("booking_id",data.getOrderId());
                i1.putExtra("vehicletype",data.getVehicle_type());
                i1.putExtra("booking_id",data.getOrderId());
                i1.putExtra("logo",data.getLogo());
                i1.putExtra("brand_name",data.getModelName());
                i1.putExtra("licence_plate",data.getNumberPlate());
                i1.putExtra("amount",data.getMy_amount());
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewtotal, textViewdetail, tv_date,tv_time;
        private CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewtotal = itemView.findViewById(R.id.tvTotal);
            textViewdetail = itemView.findViewById(R.id.tvDetails);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_time = itemView.findViewById(R.id.tv_time);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }


}