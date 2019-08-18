package com.naruto.mekvahandelivery.customer_report;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.naruto.mekvahandelivery.R;

import java.util.List;

class ViewCustomerReportAdapter extends RecyclerView.Adapter<ViewCustomerReportAdapter.ViewHolder> {

    private OnReportAdapterClickListener onReportAdapterClickListener;
    
    private List<String> imageStringList, keyList;
    private Context context;
    
    ViewCustomerReportAdapter(List<String> keyList, List<String> imageStringList, Context context) {
        this.context = context;
        this.imageStringList = imageStringList;
        this.keyList = keyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.add_customer_report_images, parent, false);
        
        if (context instanceof OnReportAdapterClickListener) {
            this.onReportAdapterClickListener = (OnReportAdapterClickListener)this.context;
        } else 
            throw new RuntimeException(context.toString() + "must implement OnReportAdapterClickListener");
        
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String data = imageStringList.get(position);
        final String finalKey = keyList.get(position);

        if (!data.equals("https://mekvahan.com/public/")) {
            try {
                Glide.with(context).load(data).fitCenter().into(holder.ivevent);
            } catch (Exception e) {
                onReportAdapterClickListener.onReportAdapterInteraction(finalKey,"");
                e.printStackTrace();
            }
            onReportAdapterClickListener.onReportAdapterInteraction(finalKey, data);
        } else {
            onReportAdapterClickListener.onReportAdapterInteraction(finalKey,"");
        }
        holder.ivcancel.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        if (imageStringList != null) {
            return imageStringList.size();
        } else 
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        
        ImageView ivcancel, ivevent;
        
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            
            ivcancel = itemView.findViewById(R.id.iv_cancel);
            ivevent = itemView.findViewById(R.id.iv_document);
        }
    }

    public interface OnReportAdapterClickListener {
        void onReportAdapterInteraction(String key, String imageString);
    }
}
