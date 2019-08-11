package com.naruto.mekvahandelivery.chauffeur_partner.upcoming_booking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.customer_pickup.UpcomingBookingCustomer;

import java.util.ArrayList;

public class UpcomingBookingChaufferAdapter extends RecyclerView.Adapter<UpcomingBookingChaufferAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MyListDataUpcomingBookingchauffer> dataArrayList;


    public UpcomingBookingChaufferAdapter(ArrayList<MyListDataUpcomingBookingchauffer> dataArrayList) {
        this.dataArrayList = dataArrayList;

    }

    @NonNull
    @Override
    public UpcomingBookingChaufferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.chauffer_upcoming_booking, viewGroup, false);

        return new UpcomingBookingChaufferAdapter.ViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull  UpcomingBookingChaufferAdapter.ViewHolder viewHolder, int i) {

        final MyListDataUpcomingBookingchauffer data = dataArrayList.get(i);

        viewHolder.textViewstatus.setText(data.getDescription());





        //viewHolder.textViewRupee.setText("\u20B9" + " 99");

        String status=data.getDescription();




        viewHolder.cv_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), UpcomingBookingCustomer.class);
                view.getContext().startActivity(i);

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
        private TextView textVieworderid, textViewstatus, textViewstate, textViewrent, textViewdeposite, textViewaccomd, textViewbed;
        private CardView cv_details;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textVieworderid = itemView.findViewById(R.id.order_id_1);
            textViewstatus= itemView.findViewById(R.id.status_U);
            cv_details=itemView.findViewById(R.id.cv_details);

        }
    }

}
