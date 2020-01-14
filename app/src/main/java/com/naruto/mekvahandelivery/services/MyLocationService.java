package com.naruto.mekvahandelivery.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.model.LatLng;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.getDeviceLocation;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.ACCESS_TOKEN;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TOKEN_TYPE;

public class MyLocationService extends Service implements LocationListener {

    private static final String myUrl = "https://mekvahan.com/api/delivery/updateLatLong";
    private  Context mContext;
    private LatLng mlatLng;
    private  Double lat,log;




    public MyLocationService(Context context){
        this.mContext = context;
    }

    public MyLocationService(){
        super();
        mContext = MyLocationService.this;
    }




    @Override
    public IBinder onBind(Intent intent) {
        return  null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        try{
            mlatLng= getDeviceLocation(mContext);
        }
        catch (Exception e){
            e.printStackTrace();
        }

         lat=mlatLng.latitude;
        log=mlatLng.longitude;

        sendLocation();

        return START_STICKY;
    }

    private void sendLocation() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, myUrl,
                response -> {


                    try {

                        JSONObject jsonObject = new JSONObject(response);

                        int status = jsonObject.getInt("status");
                        String resp=jsonObject.getString("response");
                         Log.e("TAG",resp);






                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(mContext, "Something went wrong", Toast.LENGTH_SHORT).show();
                    Log.e("TAGR", error.toString());

                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("latitude", Double.toString(lat));
                params.put("longitude", Double.toString(log));

                Log.e("TAG",Double.toString(lat));




                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String,String> headers=new HashMap<>();
                headers.put("Accept","application/json");
                LoginSessionManager loginSessionManager=new LoginSessionManager(mContext);
                HashMap<String,String> token=loginSessionManager.getUserDetailsFromSP();
                String token_type = token.get(TOKEN_TYPE);
                String acces_token = token.get(ACCESS_TOKEN);
                headers.put("Authorization",token_type+" "+acces_token);
                return headers;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(mContext).addToRequestQueue(stringRequest);



    }
    @Override
    public void onLocationChanged(Location location) {
        sendLocation();
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }






}
