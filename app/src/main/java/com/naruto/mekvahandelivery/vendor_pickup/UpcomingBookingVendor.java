package com.naruto.mekvahandelivery.vendor_pickup;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.ScanQrcode;
import com.naruto.mekvahandelivery.customer_pickup.CustomerPickupData;
import com.naruto.mekvahandelivery.customer_report.AddCustomerReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.sendNavigateIntent;

public class UpcomingBookingVendor extends AppCompatActivity implements UpcomingVendorPickupAdapter.OnAdapterClickListener {

    private LinearLayout paint_linear,navigation;
    private Button report,pickup_confirm;
    private TextView tvDetails;
    private RecyclerView recyclerViewVendorPickup;
    private RecyclerView.Adapter adapterVendorPickup;

    private List<UpcomingVendorPickupData> upcomingVendorPickupDataList;
    private final int REQUEST_CODE = 20;
    private int photoIndex = 0;
    private Uri photoURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_booking_vendor);

        report= findViewById(R.id.bt_addReport);
        tvDetails=findViewById(R.id.tvDetails);
        paint_linear = findViewById(R.id.linear_paint);
        pickup_confirm=findViewById(R.id.btpickup);
        navigation=findViewById(R.id.ll_navigation);
        recyclerViewVendorPickup = findViewById(R.id.rv_imagevendorpickup);

        upcomingVendorPickupDataList = new ArrayList<>();

        recyclerViewVendorPickup.setHasFixedSize(false);
        recyclerViewVendorPickup.setLayoutManager(new LinearLayoutManager(recyclerViewVendorPickup.getContext(),
                LinearLayoutManager.HORIZONTAL, false));

        adapterVendorPickup = new UpcomingVendorPickupAdapter(upcomingVendorPickupDataList,
                recyclerViewVendorPickup.getContext());
        recyclerViewVendorPickup.setAdapter(adapterVendorPickup);

        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>#123</font>"));
            final Drawable upArrow = getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
            upArrow.setColorFilter(getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        } catch(Exception e){
            e.printStackTrace();
        }

        report.setOnClickListener(view -> startActivity(new Intent(
                UpcomingBookingVendor.this, AddCustomerReport.class)));

        tvDetails.setOnClickListener(new View.OnClickListener() {
            int check = 1;

            @Override
            public void onClick(View view) {

                if (check == 1) {
                    paint_linear.setVisibility(View.VISIBLE);
                    check = 0;
                } else {
                    paint_linear.setVisibility(View.GONE);
                    check = 1;
                }

            }
        });

        navigation.setOnClickListener(view -> sendNavigateIntent(UpcomingBookingVendor.this,
                28.717010,77.102364));

        pickup_confirm.setOnClickListener(view -> startActivity(new Intent(UpcomingBookingVendor.this, ScanQrcode.class)));

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
            upcomingVendorPickupDataList.add(photoIndex, new UpcomingVendorPickupData(photoIndex, photoURI));
            adapterVendorPickup.notifyItemInserted(photoIndex++);
            recyclerViewVendorPickup.scrollToPosition(photoIndex-1);
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
        upcomingVendorPickupDataList.remove(position);
        recyclerViewVendorPickup.getRecycledViewPool().clear();
        adapterVendorPickup.notifyItemRemoved(position);
    }
}