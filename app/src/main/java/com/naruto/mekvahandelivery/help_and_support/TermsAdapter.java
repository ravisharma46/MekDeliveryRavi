package com.naruto.mekvahandelivery.help_and_support;

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

public class TermsAdapter extends RecyclerView.Adapter<TermsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TermsData> termsDataArrayList;

    public TermsAdapter(Context context, ArrayList<TermsData> termsData) {
        this.context = context;
        this.termsDataArrayList = termsData;
    }

    @NonNull
    @Override
    public TermsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.terms_item, parent, false);
        return new TermsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TermsAdapter.ViewHolder holder, int position) {

        final TermsData item = termsDataArrayList.get(position);

        final Typeface fontHeading = ResourcesCompat.getFont(context,R.font.gotham_medium);
        final Typeface fontnormal = ResourcesCompat.getFont(context,R.font.montserrat_regular);

        if (item != null)
        {
            if(item.getId().equals(10)){

                holder.mtextView.setTextColor(Color.BLACK);
                holder.mtextView.setPadding(0,24,0,24);
                holder.mtextView.setTypeface(holder.mtextView.getTypeface(), Typeface.BOLD);
                holder.mtextView.setTypeface(fontHeading);
                holder.mtextView.setTextSize(20);
                holder.mtextView.setText(item.getmString());

            }

            else if(item.getId().equals(3) ){

                holder.mtextView.setTextSize(12);
                holder.mtextView.setTextColor(Color.BLACK);
                holder.mtextView.setPadding(0,0,0,0);
                holder.mtextView.setTypeface(fontHeading);
                holder.mtextView.setText(item.getmString());

            }

            else if(item.getId().equals(2) ){

                holder.mtextView.setTextSize(12);
                holder.mtextView.setTextColor(Color.BLACK);
                holder.mtextView.setPadding(8,0,0,0);
                holder.mtextView.setTypeface(fontnormal);
                holder.mtextView.setText(item.getmString());

            }

        }
        else {

        }
    }

    @Override
    public int getItemCount() {
        return termsDataArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public View view;
        public AppCompatTextView mtextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.view = view;
            mtextView = view.findViewById(R.id.txtTermsAndCondition);
        }
    }

}
