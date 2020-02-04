package com.naruto.mekvahandelivery.user_profile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.TimeoutError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.UserProfile;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;
import com.naruto.mekvahandelivery.customer_pickup.UpcomingBookingCustomer;
import com.naruto.mekvahandelivery.customer_report.VolleyMultipartRequest;
import com.naruto.mekvahandelivery.customer_report.VolleySingleton;
import com.naruto.mekvahandelivery.upcoming_orders.MyListDataUpcomingBooking;
import com.naruto.mekvahandelivery.upcoming_orders.UpcomingAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.LOCATION_NOT_FOUND;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getDeviceLocation;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.ACCESS_TOKEN;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TOKEN_TYPE;

public class Checklist extends AppCompatActivity {

    private final int REQUEST_CODE = 10;

    private ImageView back_button,cross,selfie;
    private LinearLayout useCurrentLocation;
    private LatLng mCurrentLatLng;
    private ProgressBar mProgressBar;
    private FrameLayout fl_takepicture;
    private Uri photoURI;
    private Boolean isSelfieTaken=false;
    private Button bt_done,bt_update;
    private Switch sw_shower,sw_charger,sw_powerBank,sw_uniform,sw_backPack,sw_swipingMachine,sw_idCard;
    private static final int PICK_IMAGE_REQUEST = 0;
    private final String TAG = "Main Activity";
    private static final String myUrl_checklist = "https://mekvahan.com/api/delivery_checklist";
    private String shower,charger,powerBank,uniform,backpack,swipingMachine,idCard;

    private LoginSessionManager sessionManager;
    private  String selfie_path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        back_button=findViewById(R.id.iv_backpress);
        useCurrentLocation=findViewById(R.id.ll_use_current_location);
        mProgressBar = findViewById(R.id.progress_bar);
        fl_takepicture=findViewById(R.id.fl_takepicture);
        selfie=findViewById(R.id.iv_selfie);
        bt_done=findViewById(R.id.bt_done);
        bt_update =  findViewById(R.id.bt_update);


        sw_shower = findViewById(R.id.sw_shower);
        sw_charger = findViewById(R.id.sw_charger);
        sw_powerBank = findViewById(R.id.sw_power_bank);
        sw_uniform = findViewById(R.id.sw_uniform);
        sw_backPack = findViewById(R.id.sw_backpack);
        sw_swipingMachine = findViewById(R.id.sw_swipping_machine);
        sw_idCard = findViewById(R.id.sw_id_card);


        sessionManager = new LoginSessionManager(this);

        fl_takepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Checklist.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(Checklist.this,
                            new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
                    return;
                }

                dispatchTakePictureIntent(REQUEST_CODE);
            }
        });

        selfie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog settingsDialog = new Dialog(Checklist.this);
                settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                settingsDialog.setContentView(R.layout.popup_layout);
                ImageView image = settingsDialog.findViewById(R.id.chosen_image);
                Glide.with(Checklist.this).load(selfie_path).fitCenter().into(image);
                settingsDialog.setCanceledOnTouchOutside(true);
                settingsDialog.show();
            }
        });



        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        getCurrentLocationAndFillPickPoint();

        useCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentLocationAndFillPickPoint();
            }
        });



        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postChecklist();
                //onBackPressed();
            }
        });

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postChecklist();
            }
        });


        sw_shower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw_shower.isChecked()){
                    shower="1";
                }
                else {
                    shower="0";
                }
            }
        });
        sw_charger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw_charger.isChecked()){
                    charger="1";
                }
                else {
                    charger="0";
                }
            }
        });
        sw_powerBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw_powerBank.isChecked()){
                    powerBank="1";
                }
                else {
                    powerBank="0";
                }
            }
        });
        sw_uniform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw_uniform.isChecked()){
                    uniform="1";
                }
                else {
                    uniform="0";
                }
            }
        });
        sw_backPack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw_backPack.isChecked()){
                    backpack="1";
                }
                else {
                    backpack="0";
                }
            }
        });
        sw_swipingMachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw_swipingMachine.isChecked()){
                    swipingMachine="1";
                }
                else {
                    swipingMachine="0";
                }
            }
        });
        sw_idCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sw_idCard.isChecked()){
                    idCard="1";
                }
                else {
                    idCard="0";
                }
            }
        });



        getChecklist();



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

               // mPhotoFile = photoFile;
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, requestCode);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "MEK_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        // Save a file: path for use with ACTION_VIEW intents
//        File image = File.createTempFile(
//                imageFileName,  /* prefix */
//                ".jpg",         /* suffix */
//                storageDir      /* directory */
//        );
//        String currentPhotoPath = image.getAbsolutePath();
        return File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
    }



    private void postChecklist(){

        if(!isSelfieTaken){
            Toast.makeText(getApplicationContext(), "Please take selfie..", Toast.LENGTH_LONG).show();
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Updating Checklist..!");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, myUrl_checklist,
                response -> {

                    String resultResponse = new String(response.data);

                    Toast.makeText(getApplicationContext(), "Successfully updated..!", Toast.LENGTH_LONG).show();
                    finish();
                    try {
                        JSONObject jsonObject = new JSONObject(resultResponse);
                        progressDialog.dismiss();
                    } catch (Exception e) {
                        progressDialog.dismiss();
                        e.printStackTrace();
                    }
                }, error -> {
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Failed to Upload..!", Toast.LENGTH_LONG).show();
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
                    progressDialog.dismiss();
                    e.printStackTrace();
                }
            }
            Log.i("Error", errorMessage);
            error.printStackTrace();
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> bodyparams = new HashMap<>();
                bodyparams.put("shower",shower);
                bodyparams.put("charger",charger );
                bodyparams.put("power_bank",powerBank );
                bodyparams.put("uniform",uniform );
                bodyparams.put("backpack",backpack );
                bodyparams.put("swiping_machine",swipingMachine );
                bodyparams.put("id_card",idCard );
                return bodyparams;
            }

            @Override
            protected Map<String, DataPart> getByteData() throws IOException {
                Map<String, DataPart> params = new HashMap<>();
                // file name could found file base or direct access from real path
                // for now just get bitmap data from ImageView
                params.put("image1", new DataPart(getFilename(), getBytes(), "image/jpeg"));
                params.put("image2", new DataPart(getFilename(), getBytes(), "image/jpeg"));
                params.put("image3", new DataPart(getFilename(), getBytes(), "image/jpeg"));
                return params;
            }

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headerParams = new HashMap<>();
                headerParams.put("Accept", "application/json");
                headerParams.put("Authorization", sessionManager.getUserDetailsFromSP()
                        .get(LoginSessionManager.TOKEN_TYPE) + " " + sessionManager.getUserDetailsFromSP()
                        .get(LoginSessionManager.ACCESS_TOKEN));
                return headerParams;
            }
        };

        multipartRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS * 1000),
                NO_OF_RETRY, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(this.getApplicationContext()).addToRequestQueue(multipartRequest);
    }



    private String getFilename() {
        String fileName = photoURI.toString();
        int lindex = fileName.lastIndexOf('/');
        return fileName.substring(lindex + 1);
    }

    public byte[] getBytes() throws IOException {

        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoURI);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 25, baos);
       return data = baos.toByteArray();
    }



    private void getChecklist() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, myUrl_checklist,
                response -> {
                    try {

                        progressDialog.dismiss();

                        JSONObject Object = new JSONObject(response);
                        int status_1 = Object.getInt("status");
                        if (status_1 != 1) {
                            Toast.makeText(getApplicationContext(), "There is no data", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        JSONObject data = Object.getJSONObject("data");

                        String shower = data.getString("shower");
                        String charger = data.getString("charger");
                        String powerBank = data.getString("power_bank");
                        String uniform = data.getString("uniform");
                        String backpack = data.getString("backpack");
                        String swiping_machine = data.getString("swiping_machine");
                        String idCard = data.getString("id_card");
                        String image = data.getString("image1");
                        selfie_path = image;

                        if(shower.contains("1")){
                            sw_shower.setChecked(true);
                        }
                        if(charger.contains("1")){
                            sw_charger.setChecked(true);
                        }
                        if(powerBank.contains("1")){
                            sw_powerBank.setChecked(true);
                        }
                        if(uniform.contains("1")){
                            sw_uniform.setChecked(true);
                        }
                        if(backpack.contains("1")){
                            sw_backPack.setChecked(true);
                        }
                        if(swiping_machine.contains("1")){
                            sw_swipingMachine.setChecked(true);
                        }
                        if(idCard.contains("1")){
                            sw_idCard.setChecked(true);
                        }
                         try{
                             Glide.with(Checklist.this).load(image)
                                     .into(selfie);
                         }
                         catch (Exception e){
                             e.printStackTrace();
                         }



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            Log.e("TAG", error.toString());
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Accept", "application/json");
                LoginSessionManager loginSessionManager = new LoginSessionManager(Objects.requireNonNull(getApplicationContext()));
                HashMap<String, String> token = loginSessionManager.getUserDetailsFromSP();
                String token_type = token.get(TOKEN_TYPE);
                String acces_token = token.get(ACCESS_TOKEN);
                headers.put("Authorization", token_type + " " + acces_token);

                return headers;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS * 1000),
                NO_OF_RETRY, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }


    private void getCurrentLocationAndFillPickPoint() {

        mProgressBar.setVisibility(View.VISIBLE);

        try {
            mCurrentLatLng = getDeviceLocation(Checklist.this);
        } catch (Exception e) {
            e.printStackTrace();
        }


        setAddress(mCurrentLatLng);

    }

    private void setAddress(LatLng latLng) {
        //Log.e(TAG, "called : setAddress");

        TextView tv_address  = findViewById(R.id.tv_location_address);

        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Log.e(TAG,"address found="+addresses);

        if(addresses==null ) {
            tv_address.setText(LOCATION_NOT_FOUND);
            //tv_address.setSelection(et_address.getText().length());
            mProgressBar.setVisibility(View.GONE);
            return;
        }

        else if(addresses.size()==0){
            tv_address.setText(LOCATION_NOT_FOUND);
           // tv_address.setSelection(et_address.getText().length());
            mProgressBar.setVisibility(View.GONE);
            return;
        }

        String address = addresses.get(0).getAddressLine(0);

        int countComma = 0;
        int indexOf2ndComma = -1;

        int i=0;

        for (i=0;i<address.length();i++)
        {
            if(address.charAt(i) == ',')
                countComma++;
            if(countComma == 5){
                break;
            }
        }
        indexOf2ndComma = i;

        address = address.substring(0,indexOf2ndComma);

        tv_address.setText(address);
        //et_address.setSelection(et_address.getText().length());

        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            try {
                Glide.with(selfie.getContext()).load(photoURI)
                        .fitCenter().placeholder(R.drawable.image_svg)
                        .into(selfie);
                isSelfieTaken=true;


               // imagePopup.initiatePopupWithPicasso(photoURI);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
