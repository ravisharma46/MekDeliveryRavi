package com.naruto.mekvahandelivery.transaction_history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.mekvahandelivery.R;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    //   private List<Listitem> listitems;
    private Context context;
    //ValueFilter valueFilter;

    public TransactionAdapter(Context context) {
        //this.listitems = listitems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.transaction_history_list, viewGroup, false);
        return new ViewHolder(v);


    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
//        final Listitem listitem=listitems.get(i);
//
//        viewHolder.textViewname.setText(listitem.getName());
//        viewHolder.textViewrent.setText(listitem.getRent_from());
//        viewHolder.textViewdeposite.setText(listitem.getSecurity_deposit_from());
//        viewHolder.textViewaccomd.setText(listitem.getAccomodation_allowed_str());
//        viewHolder.textViewbed.setText(listitem.getAvailable_bed_count()+" Beds");
//
//        String state_city= listitem.getCity()+","+listitem.getState();
//        viewHolder.textViewcity.setText(state_city);


        viewHolder.textViewRupee.setText("\u20B9" + " 99");


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewRupee, textViewcity, textViewstate, textViewrent, textViewdeposite, textViewaccomd, textViewbed;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewRupee = itemView.findViewById(R.id.tvRuppee);
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