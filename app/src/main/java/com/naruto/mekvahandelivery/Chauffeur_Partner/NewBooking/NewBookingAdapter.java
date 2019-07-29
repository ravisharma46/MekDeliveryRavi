package com.naruto.mekvahandelivery.Chauffeur_Partner.NewBooking;

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

import com.naruto.mekvahandelivery.OngoingOrders.MyListDataOngoingBooking;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.customer_pickup.OnGoingBookingVendorDrop;
import com.naruto.mekvahandelivery.vendor_pickup.OngoingBookingCustomerDrop;

import java.util.ArrayList;

public class NewBookingAdapter extends RecyclerView.Adapter<NewBookingAdapter.ViewHolder> {

    private Context context;
    private ArrayList<MyListDataNewBooking> dataArrayList;


    public  NewBookingAdapter(ArrayList<MyListDataNewBooking> dataArrayList) {
        this.dataArrayList = dataArrayList;

    }

    @NonNull
    @Override
    public  NewBookingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.chauffer_new_booking, viewGroup, false);
        return new  NewBookingAdapter.ViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull  NewBookingAdapter.ViewHolder viewHolder, int i) {

        final MyListDataNewBooking data = dataArrayList.get(i);

        viewHolder.textViewstatus.setText(data.getDescription());




        String status=data.getDescription();




            viewHolder.cv_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), NewBookingOrderView.class);
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

            textVieworderid = itemView.findViewById(R.id.order_id_2);
            textViewstatus= itemView.findViewById(R.id.status);
            cv_details=itemView.findViewById(R.id.cv_details);


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
