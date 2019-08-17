package com.naruto.mekvahandelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.pickupConfirm;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.ACCESS_TOKEN;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TOKEN_TYPE;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.google.zxing.Result;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CaptureActivityPortrait extends AppCompatActivity   implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    private  String res ="";
    private static final String myUrl = "https://mekvahan.com/api/delivery/upcoming_ongoing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_capture_portrait);

        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);

        Bundle bundle=getIntent().getExtras();
        assert bundle != null;
        String otp =bundle.getString("otp");
        res=otp;



    }


    private  void sendDb_pickupConfirm(String otp_input){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,myUrl, response -> {

            try{

                JSONObject object=new JSONObject(response);
                int status_1 = object.getInt("status");
                if(status_1!=1) {

                    Toast.makeText(getApplicationContext(),"Incorrect OTP",Toast.LENGTH_SHORT).show();
                    return;
                }


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
            sendDb_pickupConfirm(res);
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
