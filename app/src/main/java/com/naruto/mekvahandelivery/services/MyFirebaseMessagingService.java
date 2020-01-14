package com.naruto.mekvahandelivery.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCMMessageing";

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.e("NEW_TOKEN",s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.e("TAG",remoteMessage.getNotification().getBody());

        Log.e(TAG, "From: " + remoteMessage.getFrom());
        if (remoteMessage.getNotification() != null) {
            Log.e(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }


        notifyUser(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());

    }

    public void notifyUser(String title ,String notification){

        MyFcmNotificationManager myFcmNotificationManager = new MyFcmNotificationManager(getApplicationContext());
        myFcmNotificationManager.createNotification(title,notification);
    }

    private void storeTokenInSP(String refreshedToken) {
        SharedPrefFcm.getmInstance(getApplicationContext()).storeToken(refreshedToken);
        Log.e(TAG, "token stored in sharedPref : "+SharedPrefFcm.getmInstance(getApplicationContext()).getToken());
    }
}


//	FirebaseInstanceId.getInstance().getInstanceId()
//            .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
//@Override
//public void onComplete(@NonNull Task<InstanceIdResult> task) {
//
//        if(task.isSuccessful()){
//        String token = task.getResult().getToken();
//
//        Log.e("TOKEN",token);
//
//        }
//        else{
//        Log.e("TOKEN","FAILDED");
//        }
//
//
//        }
//        });