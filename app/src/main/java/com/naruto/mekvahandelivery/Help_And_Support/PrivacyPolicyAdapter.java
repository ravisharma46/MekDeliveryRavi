package com.naruto.mekvahandelivery.Help_And_Support;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.mekvahandelivery.R;

import java.util.ArrayList;

public class PrivacyPolicyAdapter extends RecyclerView.Adapter<PrivacyPolicyAdapter.ViewHolder> {

    private Context context;
    private ArrayList<PrivacyData> policyDataArrayList;

    public PrivacyPolicyAdapter(Context context, ArrayList<PrivacyData> policyDataArrayList) {
        this.context = context;
        this.policyDataArrayList = policyDataArrayList;
    }

    @NonNull
    @Override
    public PrivacyPolicyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.privacy_policy_items, parent, false);
        return new PrivacyPolicyAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PrivacyData item = policyDataArrayList.get(position);

        final Typeface fontHeading = ResourcesCompat.getFont(context, R.font.gotham_medium);
        final Typeface fontnormal = ResourcesCompat.getFont(context,R.font.montserrat_regular);

        if(item != null)
        {
            if(item.getId().equals(1)){
                holder.mtextView.setTextColor(Color.BLACK);
                holder.mtextView.setPadding(0,24,0,24);
                holder.mtextView.setTypeface(holder.mtextView.getTypeface(), Typeface.BOLD);
                holder.mtextView.setTypeface(fontHeading);
                holder.mtextView.setTextSize(20);
                holder.mtextView.setText(item.getmString());

            }

            else if(item.getId().equals(2)  ){

                holder.mtextView.setTextSize(16);
                holder.mtextView.setTextColor(Color.BLACK);
                holder.mtextView.setPadding(0,0,0,0);
                holder.mtextView.setTypeface(fontHeading);
                holder.mtextView.setText(item.getmString());

            }

            else if  (item.getId().equals(3) ){

                holder.mtextView.setTextSize(12);
                holder.mtextView.setTextColor(Color.BLACK);
                holder.mtextView.setPadding(8,0,0,0);
                holder.mtextView.setTypeface(fontnormal);
                holder.mtextView.setText(item.getmString());

            }

            else if (item.getId().equals(4)  ){

                holder.mtextView.setTextSize(12);
                holder.mtextView.setTextColor(Color.BLACK);
                holder.mtextView.setPadding(16,0,0,0);
                holder.mtextView.setTypeface(fontnormal);
                holder.mtextView.setText(item.getmString());

            }

            else if(item.getId().equals(5) ) {

                holder.mtextView.setTextSize(12);
                holder.mtextView.setTextColor(Color.BLACK);
                holder.mtextView.setPadding(24,0,0,0);
                holder.mtextView.setTypeface(fontnormal);
                holder.mtextView.setText(item.getmString());
            }

            else if(item.getId().equals(000) ) {

                holder.mtextView.setTextSize(12);
                holder.mtextView.setTextColor(Color.BLACK);
                holder.mtextView.setPadding(0,0,0,0);
                holder.mtextView.setTypeface(fontnormal);
                holder.mtextView.setText(item.getmString());
            }

        }

        else{

        }
    }

    @Override
    public int getItemCount() {
        return policyDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public AppCompatTextView mtextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.view = view;
            mtextView = view.findViewById(R.id.txtPrivacyPolicy);
        }
    }
}
