package com.naruto.mekvahandelivery.upcoming_orders;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.naruto.mekvahandelivery.R;

import java.util.ArrayList;
import java.util.List;

public class PickupImageAdapter extends RecyclerView.Adapter<PickupImageAdapter.ViewHolder> {


    private ArrayList<Uri> pickup_image;
    private Context context;
    private String booking;

    public PickupImageAdapter(ArrayList<Uri> pickup_image,Context context,String booking) {
        this.pickup_image= pickup_image;
        this.context=context;
        this.booking = booking;
    }

    @NonNull
    @Override
    public  PickupImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_customer_report_images, parent, false);

        return new PickupImageAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PickupImageAdapter.ViewHolder holder, int i) {

         if(booking.contains("ongoing")){
             holder.ivcancel.setVisibility(View.GONE);
         }

            Glide.with(context)
                    .load(pickup_image.get(i))
                    .apply(new RequestOptions().centerCrop()
                            .fitCenter()
                            .placeholder(R.drawable.image_svg))
                    .into(holder.ivevent);

        holder.ivevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog settingsDialog = new Dialog(context);
                settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                settingsDialog.setContentView(R.layout.popup_layout);
                ImageView image = settingsDialog.findViewById(R.id.chosen_image);
                Glide.with(context).load(pickup_image.get(i)).fitCenter().into(image);
                settingsDialog.setCanceledOnTouchOutside(true);
                settingsDialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return pickup_image.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
      private   ImageView ivevent, ivcancel;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivevent = itemView.findViewById(R.id.iv_document);
            ivcancel = itemView.findViewById(R.id.iv_cancel);


            ivcancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    pickup_image.remove(pos);
                    notifyItemRemoved(pos);

                }
            });




        }
    }

}
