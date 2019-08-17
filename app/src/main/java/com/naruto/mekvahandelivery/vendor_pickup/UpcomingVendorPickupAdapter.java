package com.naruto.mekvahandelivery.vendor_pickup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.naruto.mekvahandelivery.R;

import java.util.List;

public class UpcomingVendorPickupAdapter extends RecyclerView.Adapter<UpcomingVendorPickupAdapter.ViewHolder> {

    private Context context;
    private List<UpcomingVendorPickupData> upcomingVendorPickupDataList;
    private OnAdapterClickListener onAdapterClickListener;

    UpcomingVendorPickupAdapter(List<UpcomingVendorPickupData> upcomingVendorPickupDataList, Context context) {
        this.context = context;
        this.upcomingVendorPickupDataList = upcomingVendorPickupDataList;
    }

    @NonNull
    @Override
    public UpcomingVendorPickupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context)
                .inflate(R.layout.add_customer_report_images, parent, false);

        if (this.context instanceof OnAdapterClickListener) {
            this.onAdapterClickListener = (OnAdapterClickListener)this.context;
        } else {
            throw new RuntimeException(context.toString() + " must implement onAdapterClickListener.");
        }
        return new UpcomingVendorPickupAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingVendorPickupAdapter.ViewHolder holder, int position) {
        final UpcomingVendorPickupData data = upcomingVendorPickupDataList.get(position);

        if (data != null) {
            try {
                Glide.with(context)
                        .load(data.getPhotoUri())
                        .apply(new RequestOptions().centerCrop()
                                .fitCenter()
                                .placeholder(R.drawable.image_svg))
                        .into(holder.ivevent);
            } catch (Exception e) {
                e.printStackTrace();
            }

            holder.ivcancel.setOnClickListener(view ->
                    onAdapterClickListener.onAdapterInteraction(holder.getAdapterPosition()));
        }

    }

    @Override
    public int getItemCount() {
        if (upcomingVendorPickupDataList != null) {
            return upcomingVendorPickupDataList.size();
        } else
            return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivevent, ivcancel;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivevent = itemView.findViewById(R.id.iv_document);
            ivcancel = itemView.findViewById(R.id.iv_cancel);
        }
    }

    public interface OnAdapterClickListener {
        void onAdapterInteraction(int position);
    }
}
