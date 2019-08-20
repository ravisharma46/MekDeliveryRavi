package com.naruto.mekvahandelivery.common_files;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.naruto.mekvahandelivery.login_signup.LoginActivity;

import java.util.HashMap;

public class LoginSessionManager {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME            = "LoginPreference";
    private static final String IS_LOGIN             = "IsLoggedIn";
    private static final String ON_BOARDING_SHOWN    = "onBoardingShown";

    public static final String TOKEN_TYPE      = "token_type";
    public static final String ACCESS_TOKEN    = "access_token";

    public static final String USER_ID     = "user_id";
    public static final String PROFILE_ID     = "profileId";
    public static final String NAME        = "name";
    public static final String MOBILE      = "mobile";
    public static final String EMAIL       = "email";
    public static final String TYPE    = "type";
    public static final String LATITUDE    = "latitude";
    public static final String LONGITUDE    = "longitude";
    public static final String PARTNER_ID     = "partnerId";
    public static final String ACTIVE       = "active";
    public static final String PAN_NUMBER       = "pan_number";
    public static final String ACCOUNT_NUMBER       = "account_number";
    public static final String IFSC_CODE      = "ifsc_code";
    public static final String CANCELLED_CHECK_NUMBER      = "cancelled_check_number";
    public static final String CANCELLED_CHECK      = "cancelled_check";





    @SuppressLint("CommitPrefEdits")
    public LoginSessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String token_type, String accessToken, String userId, String profileId,  String name, String mobile, String email, String type,
                                 String latitude,String longitude,String partnerId, String active,String panNumber,String accountNumber,String ifscCode,
                                   String cancelledCheckNumber,String cancelledCheck){

        editor.putBoolean(IS_LOGIN, true);

        editor.putString(TOKEN_TYPE,token_type);
        editor.putString(ACCESS_TOKEN,accessToken);
        editor.putString(USER_ID,userId);
        editor.putString(NAME,name);
        editor.putString(MOBILE,mobile);
        editor.putString(EMAIL,email);
        editor.putString(TYPE,type);
        editor.putString(LATITUDE,latitude);
        editor.putString(LONGITUDE,longitude);
        editor.putString(PARTNER_ID,partnerId);
        editor.putString(PROFILE_ID,profileId);
        editor.putString(ACTIVE,active);
        editor.putString(PAN_NUMBER,panNumber);
        editor.putString(ACCOUNT_NUMBER,accountNumber);
        editor.putString(IFSC_CODE,ifscCode);
        editor.putString(CANCELLED_CHECK_NUMBER,cancelledCheckNumber);
        editor.putString(CANCELLED_CHECK,cancelledCheck);

        editor.commit();
    }

    public void checkLogin() {

        if (!this.isLoggedIn()) {

            Intent i = new Intent(context, LoginActivity.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }


    public void setOnBoardingShown(){

        editor.putBoolean(ON_BOARDING_SHOWN, true);
        editor.commit();

    }

    public HashMap<String, String> getUserDetailsFromSP(){

        HashMap<String, String> user = new HashMap<String, String>();

        user.put(TOKEN_TYPE, pref.getString(TOKEN_TYPE, ""));
        user.put(ACCESS_TOKEN, pref.getString(ACCESS_TOKEN, ""));

        user.put(USER_ID, pref.getString(USER_ID, null));
        user.put(NAME, pref.getString(NAME, ""));
        user.put(MOBILE, pref.getString(MOBILE, null));
        user.put(EMAIL, pref.getString(EMAIL, ""));
        user.put(TYPE, pref.getString(TYPE, ""));
        user.put(LATITUDE, pref.getString(LATITUDE, ""));
        user.put(LONGITUDE, pref.getString(LONGITUDE, ""));
        user.put(PARTNER_ID, pref.getString(PARTNER_ID, ""));
        user.put(PROFILE_ID, pref.getString(PROFILE_ID, ""));
        user.put(ACTIVE, pref.getString(ACTIVE, ""));
        user.put(PAN_NUMBER, pref.getString(PAN_NUMBER, ""));
        user.put(ACCOUNT_NUMBER, pref.getString(ACCOUNT_NUMBER, ""));
        user.put(IFSC_CODE, pref.getString(IFSC_CODE, ""));
        user.put(CANCELLED_CHECK_NUMBER, pref.getString(CANCELLED_CHECK_NUMBER, ""));
        user.put(CANCELLED_CHECK, pref.getString(CANCELLED_CHECK, ""));

        return user;
    }

    public void logoutUser(){

        editor.clear();
        setOnBoardingShown();
        editor.commit();


        Intent i = new Intent(context, LoginActivity.class);

        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //new ClearRoom(MekVahanDatabase.getInstance(context)).execute();

        // Staring Login Activity
        Toast.makeText(context,"Logged Out", Toast.LENGTH_SHORT).show();
        context.startActivity(i);

    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public boolean onBoardingShown(){
        return pref.getBoolean(ON_BOARDING_SHOWN, false);
    }


}
