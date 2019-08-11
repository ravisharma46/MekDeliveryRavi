package com.naruto.mekvahandelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.pickupConfirm;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CaptureActivityPortrait extends AppCompatActivity   implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    private  String res ="123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_capture_portrait);

        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);

    }


    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v("TAG", rawResult.getText()); // Prints scan results
        Log.v("TAG", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)


        String ans=rawResult.toString();
        if(ans.contentEquals(res)){
            pickupConfirm(CaptureActivityPortrait.this);
            delay(new NavActivity());

        }
        else{
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

            alertBuilder.setMessage("Incorrect Qr Code").setCancelable(false);

            alertBuilder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    mScannerView.resumeCameraPreview(CaptureActivityPortrait.this::handleResult);
                    // Want to run this code again
                }
            });


            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.setTitle("Scan Results");
            alertDialog.show();


        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void delay(Activity activity){
        Handler handler = new Handler();

        handler.postDelayed(() -> {
            Intent intent = new Intent(CaptureActivityPortrait.this, activity.getClass());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();


            startActivity(intent);

        }, 150);
    }

}
