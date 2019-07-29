package com.naruto.mekvahandelivery.customer_pickup;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.ceylonlabs.imageviewpopup.ImagePopup;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.customer_report.AddCustomerReport;
import com.naruto.mekvahandelivery.customer_report.ViewCustomerReport;
import com.naruto.mekvahandelivery.vendor_pickup.UpcomingBookingVendor;

import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.dropConfirm;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.sendNavigateIntent;

import java.util.HashMap;
import java.util.Map;

public class OnGoingBookingVendorDrop extends AppCompatActivity {
    private LinearLayout paint_linear,navigation;
    private TextView tvDetails, date, time;
    private ImageView call,iv_qrcode;
    private Button report_show,drop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoingbooking_vendordrop);

        paint_linear = findViewById(R.id.linear_paint_1);
        tvDetails = findViewById(R.id.tvDetails_1);

        report_show=findViewById(R.id.report_view);

        call = findViewById(R.id.call);
        iv_qrcode=findViewById(R.id.iv_qrcode);
        drop=findViewById(R.id.bt_drop);
        navigation=findViewById(R.id.ll_navigation);

       generateQrcode();


        final ImagePopup imagePopup = new ImagePopup(this);
        imagePopup.setWindowHeight(800); // Optional
        imagePopup.setWindowWidth(800); // Optional
       imagePopup.setBackgroundColor(getResources().getColor(R.color.offwhite_01));
        imagePopup.setFullScreen(true); // Optional
        imagePopup.setHideCloseIcon(true);  // Optional
        imagePopup.setImageOnClickClose(true);  // Optional


        imagePopup.initiatePopup(iv_qrcode.getDrawable());

        iv_qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePopup.viewPopup();
            }
        });

        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropConfirm(OnGoingBookingVendorDrop.this);
            }
        });



        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNavigateIntent(OnGoingBookingVendorDrop.this,28.717010,77.102364);
            }
        });





        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>#123</font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


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

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:123456789"));
                startActivity(callIntent);
            }
        });
        report_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnGoingBookingVendorDrop.this, ViewCustomerReport.class));
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


    public void generateQrcode(){
        try {
            //setting size of qr code
            int width =300;
            int height = 300;
            int smallestDimension = width < height ? width : height;


            String qrCodeData = "123456";
            //setting parameters for qr code
            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap =new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            CreateQRCode(qrCodeData, charset, hintMap, smallestDimension, smallestDimension);

        } catch (Exception ex) {
            Log.e("QrGenerate",ex.getMessage());
        }
    }

    public  void CreateQRCode(String qrCodeData, String charset, Map hintMap, int qrCodeheight, int qrCodewidth){


        try {
            //generating qr code in bitmatrix type
            BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
            //converting bitmatrix to bitmap

            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int[] pixels = new int[width * height];
            // All are 0, or black, by default
            for (int y = 0; y < height; y++) {
                int offset = y * width;
                for (int x = 0; x < width; x++) {
                    //pixels[offset + x] = matrix.get(x, y) ? BLACK : WHITE;
                    pixels[offset + x] = matrix.get(x, y) ?
                            ResourcesCompat.getColor(getResources(),R.color.chart_deep_red,null) :Color.WHITE;
                }
            }

            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            //setting bitmap to image view

            Bitmap overlay = BitmapFactory.decodeResource(getResources(), R.drawable.mek_logo);

           // iv_qrcode.setImageBitmap(mergeBitmaps(overlay,bitmap));
            iv_qrcode.setImageBitmap(bitmap);

        }catch (Exception er){
            Log.e("QrGenerate",er.getMessage());
        }
    }


}



