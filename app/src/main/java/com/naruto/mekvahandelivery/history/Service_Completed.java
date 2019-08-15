package com.naruto.mekvahandelivery.history;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.custom_list_data.CustomListAdapter;
import com.naruto.mekvahandelivery.customer_pickup.UpcomingBookingCustomer;

import java.util.ArrayList;

public class Service_Completed extends AppCompatActivity {

    private TextView rupeeAmount, rupeepaytm,rupTax,rupSubtotal,rupAdditonalchrg,rupTotal,tvDetails,service, vehicleBrand,vehicleName,numberPlate,serviceName;
    private ImageView vehicle_image;
    private TextView btnClickme;
    private RelativeLayout rrTilte;
    private ArrayList<String> arrayList;
    private ArrayList<String> arrayListsend;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service__completed);





        rupeeAmount = findViewById(R.id.rupeeAmount);
        rupeepaytm = findViewById(R.id.rupeePaytm);
        tvDetails=findViewById(R.id.tvDetails);
        service=findViewById(R.id.service);
        rrTilte=findViewById(R.id.firstRelative);
        vehicleBrand=findViewById(R.id.tv_vehiclebrand);
        vehicleName=findViewById(R.id.tv_vehiclename);
        numberPlate=findViewById(R.id.tv_numberPlate);
        serviceName=findViewById(R.id.tv_servicename);
        vehicle_image=findViewById(R.id.iv_carimage);
        rupTotal=findViewById(R.id.tvTotal);
        rupAdditonalchrg=findViewById(R.id.tv_additonalcharge);
        rupTax=findViewById(R.id.tv_tax);
        rupSubtotal=findViewById(R.id.tv_subtotal);
        rupTotal=findViewById(R.id.tv_total);



        arrayList=new ArrayList<>();
        arrayListsend=new ArrayList<>();


        Bundle bundle=getIntent().getExtras();
        String bookingid =bundle.getString("bookingid");
        String amount=bundle.getString("amount");
        String vehiclename=bundle.getString("vehiclename");
        String vehiclebrand=bundle.getString("vehiclebrand");
        String numberplate=bundle.getString("numberplate");
        String vehicleImageUrl=bundle.getString("imageurl");
        String servicename=bundle.getString("servicename");
        String action1=bundle.getString("action1");
        String action2=bundle.getString("action2");
        String action3=bundle.getString("action3");
        String action4=bundle.getString("action4");
        String action5=bundle.getString("action5");
        String action6=bundle.getString("action6");
        String action7=bundle.getString("action7");
        String action8=bundle.getString("action8");
        String action9=bundle.getString("action9");
        String action10=bundle.getString("action10");
        String action11=bundle.getString("action11");
        String action12=bundle.getString("action12");
        String action13=bundle.getString("action13");
        String action14=bundle.getString("action14");
        String action15=bundle.getString("action15");
        arrayList.add(action1);
        arrayList.add(action2);
        arrayList.add(action3);
        arrayList.add(action4);
        arrayList.add(action6);
        arrayList.add(action7);
        arrayList.add(action8);
        arrayList.add(action9);
        arrayList.add(action10);
        arrayList.add(action11);
        arrayList.add(action12);
        arrayList.add(action13);
        arrayList.add(action14);
        arrayList.add(action15);

        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i).isEmpty()){
                break;
            }else{
                arrayListsend.add(arrayList.get(i));
            }
        }



        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_listView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        adapter = new CustomListAdapter((ArrayList<String>) arrayListsend,"history");
        recyclerView.setAdapter(adapter);

        vehicleName.setText(vehiclename);
        vehicleBrand.setText(vehiclebrand);
        numberPlate.setText(numberplate);
        serviceName.setText(servicename);



        try{
            Glide.with(Service_Completed.this).load(vehicleImageUrl)
                    .into(vehicle_image);

        }
        catch (Exception e){
            e.printStackTrace();
        }


        rupeepaytm.setText("\u20B9 " + amount);
        rupeeAmount.setText("\u20B9 " + amount);
        rupSubtotal.setText("\u20B9 " + amount);
        rupTax.setText("\u20B9 " + "0");
        rupAdditonalchrg.setText("\u20B9 " + "0");
        rupTotal.setText("\u20B9 " + amount);

        //Action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml(bookingid));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);






        tvDetails.setOnClickListener(new View.OnClickListener() {
            int check=1;
            @Override
            public void onClick(View view) {

                if(check==1){
                    recyclerView.setVisibility(View.VISIBLE);
                    check=0;
                }
                else{
                    recyclerView.setVisibility(View.GONE);
                    check=1;
                }


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
