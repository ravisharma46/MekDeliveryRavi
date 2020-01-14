package com.naruto.mekvahandelivery.customer_pickup;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.TimeoutError;
import com.android.volley.toolbox.StringRequest;
import com.broooapps.otpedittext2.OtpEditText;
import com.bumptech.glide.Glide;
import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.google.android.gms.common.internal.Constants;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.naruto.mekvahandelivery.NavActivity;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;
import com.naruto.mekvahandelivery.custom_list_data.CustomListAdapter;
import com.naruto.mekvahandelivery.customer_report.AddCustomerReport;
import com.naruto.mekvahandelivery.customer_report.VolleyMultipartRequest;
import com.naruto.mekvahandelivery.customer_report.VolleySingleton;
import com.naruto.mekvahandelivery.login_signup.FragmentForgotPassword;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.BASE;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.callIntent;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.pickupConfirm;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.sendNavigateIntent;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.ACCESS_TOKEN;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TOKEN_TYPE;

public class UpcomingBookingCustomer extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayout navigation;
    private ImageView call,vehicle_image;
    private TextView tvDetails,date, time,name,address,vehicleBrand,vehicleName,numberPlate,serviceName;
    private Button report,confirm_booking;

    public ArrayList<String> arrayList, arrayListsend;
    public List<CustomerPickupData> customerPickupDataList;
    private final int REQUEST_CODE = 10;
    private Uri photoURI;
    private int photoIndex = 0;

    private String otp_input="0000",bookingid="";
    private OtpEditText otpEditText;

    private static final String myUrl = "https://mekvahan.com/api/delivery/upcoming_ongoing";
    private static final String myUrl_img = "https://mekvahan.com/api/delivery/pickup_image";

    private ProgressDialog mProgressDialog;
    private ImageView uvPickupImage;
    private ImagePopup imagePopup;
    private Boolean aBoolean=false;
    private double latitude=0.0,longitude=0.0;
    private Boolean isCustomerReportUpload = false;
    private LoginSessionManager sessionManager;
    private Bitmap bitmap;


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
        uvPickupImage = findViewById(R.id.iv_uvpickup);
        sessionManager = new LoginSessionManager(this);

        otpEditText=findViewById(R.id.et_otp);
        otpEditText.setOnClickListener(view -> {
            otp_input = String.valueOf(otpEditText.getText());
            Log.e("TAG",otp_input);
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
        try{
            latitude= Double.parseDouble(bundle.getString("latitude"));
            longitude=Double.parseDouble( bundle.getString("longitude"));

        }
        catch (Exception e){
            e.printStackTrace();
        }

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

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("Order id: "+bookingid));
        final Drawable upArrow = getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        assert upArrow != null;
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
              sendNavigateIntent(UpcomingBookingCustomer.this,latitude,longitude);
        });

        report.setOnClickListener(view -> {
            Intent intent = new Intent(UpcomingBookingCustomer.this, AddCustomerReport.class);
            intent.putExtra("bookingid", bookingid);
            intent.putExtra("vehicletype", vehicle_type);
            startActivityForResult(intent,101);
        });

       confirm_booking.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sendDb_exterior_image();
               //sendDb_pickupConfirm();
           }
       });

        mProgressDialog = new ProgressDialog(getApplicationContext());
        mProgressDialog.setMessage("Please wait...");

        imagePopup = new ImagePopup(UpcomingBookingCustomer.this);
        imagePopup.setWindowHeight(800); // Optional
        imagePopup.setWindowWidth(800); // Optional
        imagePopup.setBackgroundColor(getColor(R.color.offwhite_01));
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(true);  // Optional
        imagePopup.setImageOnClickClose(true);

        if(!aBoolean){
            imagePopup.initiatePopup(imagePopup.getDrawable());
        }
        uvPickupImage.setOnClickListener(view -> imagePopup.viewPopup());

    }

    private void sendDb_pickupConfirm(){
      //  mProgressDialog.show();
        if (isCustomerReportUpload!=true) {
            Snackbar.make(confirm_booking, "Please add customer report..!",
                    BaseTransientBottomBar.LENGTH_SHORT).setAction("Ok", null).show();
            return;
        }
        StringRequest stringRequest=new StringRequest(Request.Method.POST,myUrl,response -> {

            try{
               // mProgressDialog.dismiss();
                JSONObject object=new JSONObject(response);
                int status_1 = object.getInt("status");
                if(status_1!=1) {
                    dialogpop();
                    //Toast.makeText(getApplicationContext(),"Incorrect OTP",Toast.LENGTH_SHORT).show();
                    return;
                }
               // mProgressDialog.dismiss();
                pickupConfirm(UpcomingBookingCustomer.this);
                delay(new NavActivity());
            }
            catch (Exception e){
                e.printStackTrace();
            }

        },error -> {
          //  mProgressDialog.dismiss();
            Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
            Log.e("TAG", error.toString());
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> headers=new HashMap<>();
                headers.put("otp",otp_input);
                return headers;
            }

            @Override
            public Map<String, String> getHeaders() {
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

        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, myUrl_img,
                response -> {

                    String resultResponse = new String(response.data);
                    Log.e("IMG123:=",resultResponse );

                    try {
                        JSONObject jsonObject = new JSONObject(resultResponse);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, error -> {
            NetworkResponse networkResponse = error.networkResponse;
            String errorMessage = "Unknown error";
            if (networkResponse == null) {
                if (error.getClass().equals(TimeoutError.class)) {
                    errorMessage = "Request timeout";
                } else if (error.getClass().equals(NoConnectionError.class)) {
                    errorMessage = "Failed to connect server";
                }
            } else {
                String result = new String(networkResponse.data);
                try {
                   // Log.e("result string", newBId+" "+result);
                    JSONObject response = new JSONObject(result);
                    String status = response.getString("status");
                    String message = response.getString("message");

                    Log.e("Error Status", status);
                    Log.e("Error Message", message);

                    switch (networkResponse.statusCode) {
                        case 404:
                            errorMessage = "Resource not found";
                            break;
                        case 401:
                            errorMessage = message + " Please login again";
                            break;
                        case 400:
                            errorMessage = message + " Check your inputs";
                            break;
                        case 500:
                            errorMessage = message + " Something is getting wrong";
                            break;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            Log.i("Error", errorMessage);
            error.printStackTrace();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> bodyparams = new HashMap<>();
                String bookinID= bookingid.replace("#","");
                bodyparams.put("booking_id", bookinID);


                return bodyparams;
            }

            @Override
            protected Map<String, DataPart> getByteData() throws IOException {
                Map<String, DataPart> params = new HashMap<>();
                // file name could found file base or direct access from real path
                // for now just get bitmap data from ImageView

                params.put("pickup_image",new DataPart(getFilename(), getBytes(), "image/jpeg"));

                return params;
            }

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headerParams = new HashMap<>();
                headerParams.put("Accept", "application/json");
                headerParams.put("Authorization", sessionManager.getUserDetailsFromSP()
                        .get(LoginSessionManager.TOKEN_TYPE)+" "+sessionManager.getUserDetailsFromSP()
                        .get(LoginSessionManager.ACCESS_TOKEN));
                return headerParams;
            }
        };

        multipartRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(this.getApplicationContext()).addToRequestQueue(multipartRequest);

    }

    private String getFilename() {
        String fileName = photoURI.toString();
        int lindex = fileName.lastIndexOf('/');
        return  fileName.substring(lindex+1);
    }

    public byte[] getBytes() throws IOException {
        InputStream iStream;

            iStream = getContentResolver().openInputStream(photoURI);


        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len;
        if (iStream != null) {
            while ((len = iStream.read(buffer)) != -1) {
                byteBuffer.write(buffer, 0, len);
            }
        } else
            Log.e("iStream: ", "null");
        assert iStream != null;
        iStream.close();
        return byteBuffer.toByteArray();
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
        if (ContextCompat.checkSelfPermission(UpcomingBookingCustomer.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(UpcomingBookingCustomer.this,
                    new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
            return;
        }

        dispatchTakePictureIntent(REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

            try {
                Glide.with(uvPickupImage.getContext()).load(photoURI)
                        .fitCenter().placeholder(R.drawable.image_svg)
                        .into(uvPickupImage);
                aBoolean=true;
                Log.e("imagefilepath",photoURI.toString());
                imagePopup.initiatePopupWithPicasso(photoURI);
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoURI);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (requestCode == 101 ) {
            try{
                String status =data.getStringExtra("upload_status");
                if(status.contains("true")){
                    isCustomerReportUpload=true;
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }


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

    private void dialogpop(){
        // mProgressDialog.dismiss();
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        alertBuilder.setMessage("Incorrect OTP").setCancelable(false);

        alertBuilder.setPositiveButton("Retry", (dialog, which) -> dialog.cancel());

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