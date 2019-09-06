package com.naruto.mekvahandelivery.customer_pickup;

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

class AddUpcomingCustomerPickupAdapter extends RecyclerView.Adapter<AddUpcomingCustomerPickupAdapter.ViewHolder> {

    private OnAdapterClickListener onAdapterClickListener;
    private List<CustomerPickupData> customerPickupDataList;
    private Context context;

    public AddUpcomingCustomerPickupAdapter(List<CustomerPickupData> customerPickupDataList, Context context) {
        this.customerPickupDataList = customerPickupDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_customer_report_images, parent, false);

        if (this.context instanceof OnAdapterClickListener) {
            this.onAdapterClickListener = (OnAdapterClickListener)this.context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnAdapterClickListener");
        }

        return new AddUpcomingCustomerPickupAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CustomerPickupData data = customerPickupDataList.get(position);

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

            holder.ivcancel.setOnClickListener(view -> {
                onAdapterClickListener.onAdapterInteraction(holder.getAdapterPosition());
            });
        }

    }

    @Override
    public int getItemCount() {
        if (customerPickupDataList == null) {
            return 0;
        } else
            return customerPickupDataList.size();
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