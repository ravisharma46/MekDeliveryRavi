package com.naruto.mekvahandelivery.custom_list_data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.mekvahandelivery.R;

import java.util.ArrayList;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {

    private ArrayList<String> data;
    private String booking;

    public CustomListAdapter(ArrayList<String> data,String booking) {
        this.data = data;
        this.booking=booking;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_listview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        holder.data.setText(data.get(i));

        if(booking.contains("upcoming")){
            holder.iv_check.setImageResource(R.drawable.checked_svg);
        }

        if(i%2!=0){
            holder.fm.setBackgroundResource(R.drawable.frame_rect);
        }





    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView data;
        private ImageView iv_check;
        private FrameLayout fm;

        private ViewHolder(View view) {
            super(view);
            this.view = view;
            data = view.findViewById(R.id.tv_data);
            iv_check=view.findViewById(R.id.iv_check);
            fm=view.findViewById(R.id.fl_framelayout);

        }
    }
}
