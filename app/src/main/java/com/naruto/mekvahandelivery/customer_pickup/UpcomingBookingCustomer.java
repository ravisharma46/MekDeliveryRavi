package com.naruto.mekvahandelivery.customer_pickup;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.broooapps.otpedittext2.OtpEditText;
import com.bumptech.glide.Glide;
import com.naruto.mekvahandelivery.NavActivity;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;
import com.naruto.mekvahandelivery.custom_list_data.CustomListAdapter;
import com.naruto.mekvahandelivery.customer_report.AddCustomerReport;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.callIntent;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.pickupConfirm;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.ACCESS_TOKEN;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TOKEN_TYPE;

public class UpcomingBookingCustomer extends AppCompatActivity implements AddUpcomingCustomerPickupAdapter.OnAdapterClickListener {
    private RecyclerView recyclerView, recyclerViewCustPickup;
    private RecyclerView.Adapter adapter, adapterCustPickup;
    private LinearLayout navigation;
    private ImageView call,vehicle_image;
    private TextView tvDetails,date, time,name,address,vehicleBrand,vehicleName,numberPlate,serviceName;
    private Button report,confirm_booking;

    public ArrayList<String> arrayList, arrayListsend;
    public List<CustomerPickupData> customerPickupDataList;
    private final int REQUEST_CODE = 10;
    private Uri photoURI;
    private int photoIndex = 0;

    private String otp_input="",bookingid="";
    private OtpEditText otpEditText;

    private static final String myUrl = "https://mekvahan.com/api/delivery/upcoming_ongoing";
    private static final String myUrl_img = "https://mekvahan.com/api/delivery/pickup_image";

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_booking_customer);

        tvDetails = findViewById(R.id.tvDetails);
        report = findViewById(R.id.tvcustomer_report);
        call = findViewById(R.id.call);
        confirm_booking=findViewById(R.id.bt_confirm);
        navigation=findViewById(R.id.ll_navigation);

        vehicle_image=findViewById(R.id.iv_carimage);
        date=findViewById(R.id.tv_date);
        time=findViewById(R.id.tv_time);
        name=findViewById(R.id.tv_name);
        address=findViewById(R.id.tv_address);
        vehicleBrand=findViewById(R.id.tv_vehiclebrand);
        vehicleName=findViewById(R.id.tv_vehiclename);
        numberPlate=findViewById(R.id.tv_numberPlate);
        serviceName=findViewById(R.id.tv_servicename);

        otpEditText=findViewById(R.id.et_otp);
        otpEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otp_input = String.valueOf(((EditText) findViewById(R.id.et_otp)).getText());
                Log.e("TAG",otp_input);
            }
        });

        arrayList=new ArrayList<>();
        arrayListsend=new ArrayList<>();
        customerPickupDataList = new ArrayList<>();

        Bundle bundle=getIntent().getExtras();
        assert bundle != null;
        String name_1 =bundle.getString("name");
        String vehicle_type =bundle.getString("vehicletype");
        bookingid =bundle.getString("bookingid");
        String address_1 =bundle.getString("address");
//        double latitude= Double.parseDouble(bundle.getString("latitude"));
    //    double longitude=Double.parseDouble( bundle.getString("longitude"));
        String dropdate=bundle.getString("dropDate");
        String dropTime= bundle.getString("dropTime");
        String amount=bundle.getString("amount");
        String otp_1=bundle.getString("otp");
        String mobileNo=bundle.getString("mobile");
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

        recyclerView = findViewById(R.id.recyclerView_listView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        adapter = new CustomListAdapter(arrayListsend,"upcoming");
        recyclerView.setAdapter(adapter);



        recyclerViewCustPickup = findViewById(R.id.rv_imagecustomerpickup);
        recyclerViewCustPickup.setHasFixedSize(false);
        recyclerViewCustPickup.setLayoutManager(new LinearLayoutManager(recyclerViewCustPickup.getContext(),
                LinearLayoutManager.HORIZONTAL, false));

        adapterCustPickup = new AddUpcomingCustomerPickupAdapter(customerPickupDataList, recyclerViewCustPickup.getContext());
        recyclerViewCustPickup.setAdapter(adapterCustPickup);

        name.setText(name_1);
        address.setText(address_1);

        //  String d=getFormattedDate("TAG",dropdate);

        date.setText(dropdate);
        time.setText(dropTime);
        vehicleName.setText(vehiclename);
        vehicleBrand.setText(vehiclebrand);
        numberPlate.setText(numberplate);
        serviceName.setText(servicename);

        try{
            Glide.with(UpcomingBookingCustomer.this).load(vehicleImageUrl)
                    .into(vehicle_image);

        }
        catch (Exception e){
            e.printStackTrace();
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml(bookingid));
        final Drawable upArrow = getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        tvDetails.setOnClickListener(new View.OnClickListener() {
            int check = 1;

            @Override
            public void onClick(View view) {

                if (check == 1) {
                    recyclerView.setVisibility(View.VISIBLE);
                    check = 0;
                } else {
                    recyclerView.setVisibility(View.GONE);
                    check = 1;
                }

            }
        });

        call.setOnClickListener(view -> callIntent(UpcomingBookingCustomer.this,mobileNo));

        navigation.setOnClickListener(view -> {
          //  sendNavigateIntent(UpcomingBookingCustomer.this,latitude,longitude);
        });

        report.setOnClickListener(view -> {
            Intent intent = new Intent(UpcomingBookingCustomer.this, AddCustomerReport.class);
            intent.putExtra("bookingId", bookingid);
            intent.putExtra("vehicletype", vehicle_type);
            startActivity(intent);
        });

        confirm_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendDb_pickupConfirm();

            }
        });

        mProgressDialog = new ProgressDialog(getApplicationContext());
        mProgressDialog.setMessage("Please wait...");

    }


    private void sendDb_pickupConfirm(){
        //mProgressDialog.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST,myUrl,response -> {

            try{

                JSONObject object=new JSONObject(response);
                int status_1 = object.getInt("status");
                if(status_1!=1) {
                     dialogpop();
                    //Toast.makeText(getApplicationContext(),"Incorrect OTP",Toast.LENGTH_SHORT).show();
                    return;
                }
                //mProgressDialog.dismiss();
                pickupConfirm(UpcomingBookingCustomer.this);
                delay(new NavActivity());



            }
            catch (Exception e){
                e.printStackTrace();
            }




        },error -> {
            Toast.makeText(getApplicationContext(),"Something get wrong",Toast.LENGTH_LONG).show();
            Log.e("TAG", error.toString());
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> headers=new HashMap<>();
                headers.put("otp",otp_input);
                return headers;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers=new HashMap<>();
                headers.put("Accept","application/json");
                LoginSessionManager loginSessionManager=new LoginSessionManager(Objects.requireNonNull(getApplication()));
                HashMap<String,String> token=loginSessionManager.getUserDetailsFromSP();
                String token_type=token.get(TOKEN_TYPE);
                String acces_token= token.get(ACCESS_TOKEN);
                headers.put("Authorization",token_type+" "+acces_token);

                return headers;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }



    private void sendDb_exterior_image(){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,myUrl_img,response -> {

            try{

                JSONObject object=new JSONObject(response);
                int status_1 = object.getInt("status");
                if(status_1!=1) {
                    dialogpop();
                    //Toast.makeText(getApplicationContext(),"Incorrect OTP",Toast.LENGTH_SHORT).show();
                    return;
                }
                sendDb_pickupConfirm();


            }
            catch (Exception e){
                e.printStackTrace();
            }




        },error -> {
            Toast.makeText(getApplicationContext(),"Something get wrong",Toast.LENGTH_LONG).show();
            Log.e("TAG", error.toString());
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> headers=new HashMap<>();
                headers.put("pickup_image","pickupimage");
                String bookingID=bookingid.replace("#","");
                headers.put("booking_id",bookingID);

                return headers;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers=new HashMap<>();
                headers.put("Accept","application/json");
                LoginSessionManager loginSessionManager=new LoginSessionManager(Objects.requireNonNull(getApplication()));
                HashMap<String,String> token=loginSessionManager.getUserDetailsFromSP();
                String token_type=token.get(TOKEN_TYPE);
                String acces_token= token.get(ACCESS_TOKEN);
                headers.put("Authorization",token_type+" "+acces_token);

                return headers;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onAddImageButtonClick(View view) {
        dispatchTakePictureIntent(REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            customerPickupDataList.add(photoIndex, new CustomerPickupData(photoIndex, photoURI));
            adapterCustPickup.notifyItemInserted(photoIndex++);
            recyclerViewCustPickup.scrollToPosition(photoIndex-1);
        }
    }

    private void dispatchTakePictureIntent(int requestCode) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                ex.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this,
                        "com.naruto.mekvahandelivery",
                        photoFile);

                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, requestCode);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        // Save a file: path for use with ACTION_VIEW intents
        return File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
    }

    @Override
    public void onAdapterInteraction(int position) {
        customerPickupDataList.remove(position);
        recyclerViewCustPickup.getRecycledViewPool().clear();
        adapterCustPickup.notifyItemRemoved(position);
    }

    private void dialogpop(){
       // mProgressDialog.dismiss();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        alertBuilder.setMessage("Incorrect OTP").setCancelable(false);

        alertBuilder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });


        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.setTitle("OTP Results");
        alertDialog.show();
    }

    public void delay(Activity activity){
        Handler handler = new Handler();

        handler.postDelayed(() -> {
            Intent intent = new Intent(UpcomingBookingCustomer.this, activity.getClass());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();


            startActivity(intent);

        }, 800);
    }

}