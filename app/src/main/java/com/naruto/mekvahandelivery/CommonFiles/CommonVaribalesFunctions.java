package com.naruto.mekvahandelivery.CommonFiles;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.customer_pickup.UpcomingBookingCustomer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonVaribalesFunctions {
    private static final String TAG = "CoomanVarAndFun";

    public static final int RETRY_SECONDS = 8000;
    public static final int NO_OF_RETRY = 0 ;

    public static final String BASE = "https://mekvahan.com/api/";
    public static final String BASE_USER = BASE + "user/";

    public static final String KEY_CAR  = "Car";
    public static final String KEY_BIKE = "Bike";

    public static final String LOCATION_NOT_FOUND = "location_not_found";

    public static final String CUSTOMER_CARE    = "1234567890";
    public static final String CONTACT_MEKVAHAN = "+917838878899";




    public static final String TIME_FORMAT  = "hh:mm a";

    @SuppressLint("ResourceAsColor")
    public static void setStatusBarColor(Window window, int a){

        // if a=0 => primarydark color else light black

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if(a == 0)
                window.setStatusBarColor(Color.parseColor("#B71C1C"));
            else
                window.setStatusBarColor(Color.argb(255, 133, 146, 158));
        }
    }

    public static void sendNavigateIntent(Context context, double latitude, double longitude){

        String uri = "google.navigation:q="+latitude+","+longitude;

        Uri gmmIntentUri = Uri.parse(uri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        context.startActivity(mapIntent);

    }

    public static void sendEmailIntent(Context context){

        String email_id = "support@mekpark.com";

        String email_subject = "Feedback for Mekvahan";


        Intent emailIntent =  new Intent(Intent.ACTION_SENDTO,
                Uri.fromParts("mailto",email_id,null));

        emailIntent.putExtra(Intent.EXTRA_SUBJECT, email_subject);


        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(emailIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        if(isIntentSafe)
            context.startActivity(Intent.createChooser(emailIntent,"Send email via ..."));
        else
            Toast.makeText(context,"Email can't be send from here", Toast.LENGTH_SHORT).show();


    }


    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static void callIntent(Context context, String phoneNumber){

        String phone = phoneNumber;
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        context.startActivity(intent);

    }

//    public static LatLng getDeviceLocation(Context context) throws Exception {
//
//        LocationRequest.create()
//                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
//                .setInterval(10 * 1000)
//                .setFastestInterval(1 * 1000);
//
//        GPSTracker tracker = new GPSTracker(context);
//
//        if (!tracker.canGetLocation()) {
//            Log.e("asdf","shoud show aleart");
//            tracker.showSettingsAlert();
//        }
//
//        return new LatLng(tracker.getLatitude(), tracker.getLongitude());
//    }

    // Format : 06:45 PM
    public static String getFormattedTime(String TAG, String s) {

        String time = "NA";
        Date date;
        SimpleDateFormat sdf = new java.text.SimpleDateFormat(TIME_FORMAT);

        try {
            Long unix   = Long.valueOf(s);
            date        = new java.util.Date(unix*1000L);
            time        = sdf.format(date);

        }catch (Exception e){
            Log.e(TAG,"Exception cought while converting time : "+e.toString());

        }

        return time;

    }

    // Format : 1st Mar, 2019
    public static String getFormattedDate(String TAG, String unix) {

        String formatedstring = "NA";

        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Long longUnix = null;

        try {

            longUnix = Long.valueOf(unix);
            String date = sdf.format(new Date(longUnix * 1000L));

            if (date.endsWith("1") && !date.endsWith("11"))
                sdf = new SimpleDateFormat("d'st' MMM, yyyy");
            else if (date.endsWith("2") && !date.endsWith("12"))
                sdf = new SimpleDateFormat("d'nd' MMM, yyyy");
            else if (date.endsWith("3") && !date.endsWith("13"))
                sdf = new SimpleDateFormat("d'rd' MMM, yyyy");
            else
                sdf = new SimpleDateFormat("d'th' MMM, yyyy");

        }catch (Exception e){
            Log.e(TAG,"Exception cought while converting time : "+e.toString());
        }


        formatedstring = sdf.format(new Date(longUnix*1000L));


        return formatedstring;



    }

    public static void pickupConfirm(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View dialogView = inflater.inflate(R.layout.dialog_pickup_confirmed, null);

        // Specify alert dialog is not cancelable/not ignorable
        builder.setCancelable(true);

        // Set the custom layout as alert dialog view
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void dropConfirm(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View dialogView = inflater.inflate(R.layout.dialog_drop_off_confirmed, null);

        // Specify alert dialog is not cancelable/not ignorable
        builder.setCancelable(true);

        // Set the custom layout as alert dialog view
        builder.setView(dialogView);
        final AlertDialog dialog = builder.create();

        dialog.show();
    }



}
