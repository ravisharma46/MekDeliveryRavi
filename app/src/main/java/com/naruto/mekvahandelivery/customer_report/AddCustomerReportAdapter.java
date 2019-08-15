package com.naruto.mekvahandelivery.customer_report;

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

public class AddCustomerReportAdapter extends RecyclerView.Adapter<AddCustomerReportAdapter.ViewHolder> {

    private List<AddCustomerReportData> imageDocumentList;

    private OnAdapterClickListener onAdapterClickListener;

    private Context context;

    AddCustomerReportAdapter(List<AddCustomerReportData> imageDocumentList, Context context) {
        this.imageDocumentList = imageDocumentList;
        this.context = context;
    }

    @NonNull
    @Override
    public AddCustomerReportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.add_customer_report_images, parent, false);

        if (this.context instanceof OnAdapterClickListener) {
            this.onAdapterClickListener = (OnAdapterClickListener) this.context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnAdapterClickListener");
        }
        return new AddCustomerReportAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AddCustomerReportAdapter.ViewHolder holder, int position) {
        final AddCustomerReportData data = imageDocumentList.get(position);

        if (data.getPhotoUri() != null) {

            Glide.with(context)
                    .load(data.getPhotoUri())
                    .apply(new RequestOptions().centerCrop()
                            .fitCenter()
                            .placeholder(R.drawable.image_svg))
                    .into(holder.ivevent);
        } else {
            holder.ivevent.setImageDrawable(context.getDrawable(R.drawable.image_svg));
        }

        holder.ivcancel.setOnClickListener(view -> {
            if (data.getBtnstate().equals("1")) {
                onAdapterClickListener.onAdapterInteraction(data.getButtonId());
            } else if (data.getBtnstate().equals("3")) {
                onAdapterClickListener.onAdapterInteraction(holder.getAdapterPosition()+"z");
            }
        });
    }

    @Override
    public int getItemCount() {
        if (imageDocumentList != null) {
            return imageDocumentList.size();
        } else {
            return 0;
        }
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
        void onAdapterInteraction(String buttonId);
    }

}