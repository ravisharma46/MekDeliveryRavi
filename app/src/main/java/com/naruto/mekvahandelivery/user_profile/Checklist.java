package com.naruto.mekvahandelivery.user_profile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.model.LatLng;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.UserProfile;
import com.naruto.mekvahandelivery.customer_pickup.UpcomingBookingCustomer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.LOCATION_NOT_FOUND;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getDeviceLocation;

public class Checklist extends AppCompatActivity {

    private final int REQUEST_CODE = 10;

    private ImageView back_button,cross,selfie;
    private LinearLayout useCurrentLocation;
    private LatLng mCurrentLatLng;
    private ProgressBar mProgressBar;
    private FrameLayout fl_takepicture;
    private Uri photoURI;
    private Boolean aBoolean=false;
    private Button bt_done;

    private static final int PICK_IMAGE_REQUEST = 0;
    private final String TAG = "Main Activity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        back_button=findViewById(R.id.iv_backpress);
        useCurrentLocation=findViewById(R.id.ll_use_current_location);
        mProgressBar = findViewById(R.id.progress_bar);
        fl_takepicture=findViewById(R.id.fl_takepicture);
        cross=findViewById(R.id.iv_cross);
        selfie=findViewById(R.id.iv_selfie);
        bt_done=findViewById(R.id.bt_done);

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

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selfie.setImageResource(R.drawable.image_svg);
            }
        });

        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

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
                aBoolean=true;


               // imagePopup.initiatePopupWithPicasso(photoURI);
            } catch (Exception e) {
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


}
