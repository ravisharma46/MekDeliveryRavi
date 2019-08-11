package com.naruto.mekvahandelivery.chauffeur_partner.ongoing_booking;

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
import com.naruto.mekvahandelivery.vendor_pickup.OngoingBookingCustomerDrop;

import java.util.ArrayList;

public class OngoingBookingChaufferAdapter extends RecyclerView.Adapter<OngoingBookingChaufferAdapter.ViewHolder> {
    
    
    private Context context;
    private ArrayList<MyListDataOngoingBookingchauffer> dataArrayList;


    public OngoingBookingChaufferAdapter(ArrayList<MyListDataOngoingBookingchauffer> dataArrayList) {
        this.dataArrayList = dataArrayList;

    }

    @NonNull
    @Override
    public OngoingBookingChaufferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.chauffer_ongoing_booking, viewGroup, false);
        return new OngoingBookingChaufferAdapter.ViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull OngoingBookingChaufferAdapter.ViewHolder viewHolder, int i) {

        final MyListDataOngoingBookingchauffer data = dataArrayList.get(i);

        viewHolder.textViewstatus.setText(data.getDescription());





        //viewHolder.textViewRupee.setText("\u20B9" + " 99");

        String status=data.getDescription();




        viewHolder.cv_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), OngoingBookingCustomerDrop.class);
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
