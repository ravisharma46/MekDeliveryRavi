package com.naruto.mekvahandelivery;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.user_profile.Checklist;
import com.naruto.mekvahandelivery.user_profile.ShowAccountDetails;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.accounts.AccountManager.KEY_PASSWORD;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.LOCATION_NOT_FOUND;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.EMAIL;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.LATITUDE;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.LONGITUDE;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.MOBILE;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.NAME;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.PROFILE_ID;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TYPE;

public class UserProfile extends AppCompatActivity {

    private static  final int PARKING_PIC=3;
    private static final int CROP_PARKING= 4;
    private static final int PROFILE_REQUEST = 1;
    private static final int CROP_PROFILE = 2;


    private Button change_passWord, bt_done,bt_checklist;
    private FrameLayout account_details,fl_park;
    private TextView name, mobile, email, address, partnerType, executive_id, name_1,addmore,remove;
    private CircleImageView imageView;
    private LoginSessionManager msessionManager;
    private ImageView iv_plus,iv_park;
    private LinearLayout update_pic;


    private static final int PICK_IMAGE_REQUEST = 0;
    private static final int PICK_IMAGE_REQUEST_PARKING = 1;
    private final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);



        change_passWord = findViewById(R.id.btChange_pass);
        account_details = findViewById(R.id.account_details);
        bt_done = findViewById(R.id.bt_done);

        imageView = findViewById(R.id.image_icon);
        name = findViewById(R.id.tvname);
        name_1 = findViewById(R.id.tvname1);
        mobile = findViewById(R.id.tvmobile);
        email = findViewById(R.id.tvemail);
        partnerType = findViewById(R.id.tvpartner);
        executive_id = findViewById(R.id.tvprofileid);
        update_pic = findViewById(R.id.tvupdatepic);
        bt_checklist=findViewById(R.id.bt_checklist);
        addmore=findViewById(R.id.tv_addmore);
        iv_plus=findViewById(R.id.iv_plus);
        iv_park=findViewById(R.id.iv_parking);
        fl_park=findViewById(R.id.fl_parking);
        remove=findViewById(R.id.tv_remove);





        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Profile</font>"));
            final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
            upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);
        }
       catch (Exception e){
            e.printStackTrace();
       }

        msessionManager=new LoginSessionManager(getApplicationContext());
        HashMap<String,String> userInfo=msessionManager.getUserDetailsFromSP();

        name.setText("Mr. "+userInfo.get(NAME));
        name_1.setText(userInfo.get(NAME));
        mobile.setText(userInfo.get(MOBILE));
        email.setText(userInfo.get(EMAIL));
        partnerType.setText(userInfo.get(TYPE));
        executive_id.setText(userInfo.get(PROFILE_ID));

        String a=userInfo.get(LATITUDE);
        String b=userInfo.get(LONGITUDE);



        double lat=	Double.parseDouble(a);
        double longitude=	Double.parseDouble(b);

setAddress(lat,longitude);






        update_pic.setOnClickListener(view -> {
            //imageSelect(2000);

            if (ContextCompat.checkSelfPermission(UserProfile.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(UserProfile.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                return;
            }
            Intent gallaryIntent = new Intent(Intent.ACTION_PICK);
            gallaryIntent.setType("image/*");
            gallaryIntent.putExtra("flag", 1);

            startActivityForResult(gallaryIntent, PROFILE_REQUEST);


        });

        fl_park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(UserProfile.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(UserProfile.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                    return;
                }
                Intent gallaryIntent = new Intent(Intent.ACTION_PICK);
                gallaryIntent.setType("image/*");
                gallaryIntent.putExtra("flag", 1);

                startActivityForResult(gallaryIntent, PARKING_PIC);
            }
        });





        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iv_park.setImageResource(R.drawable.frame_rect);
                addmore.setVisibility(View.VISIBLE);
                iv_plus.setVisibility(View.VISIBLE);
            }
        });



        bt_checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this, Checklist.class));
            }
        });


        change_passWord.setOnClickListener(view -> changePassword());

        account_details.setOnClickListener(view -> {
            Intent i = new Intent(UserProfile.this, ShowAccountDetails.class);
            startActivity(i);
        });


        bt_done.setOnClickListener(view -> onBackPressed());




    }

    public void changePassword() {

        final AlertDialog alertDialog;

        LayoutInflater inflater = LayoutInflater.from(UserProfile.this);
        final View v = inflater.inflate(R.layout.dialog_change_password, null);


        alertDialog = new AlertDialog.Builder(UserProfile.this, android.
                R.style.Theme_DeviceDefault_Light_Dialog_MinWidth).create();

        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        alertDialog.setView(v);

        final EditText et_current_pass, et_new_pass, et_confirm_pass;
        final TextView password_error;
        TextView done, cancel;


        et_current_pass = v.findViewById(R.id.current_password);
        et_new_pass = v.findViewById(R.id.new_password);
        et_confirm_pass = v.findViewById(R.id.confirm_password);


        password_error = v.findViewById(R.id.tv_password_error);

        done = v.findViewById(R.id.done);
        cancel = v.findViewById(R.id.cancel);

        done.setOnClickListener(v1 -> {

            String currentPass, newPass, confirmPass;

            currentPass = et_current_pass.getText().toString().trim();
            newPass = et_new_pass.getText().toString().trim();
            confirmPass = et_confirm_pass.getText().toString().trim();


            if (currentPass.equals("") || newPass.equals("") ||
                    confirmPass.equals("")) {
                password_error.setVisibility(View.VISIBLE);
                password_error.setText("All field are required");
                return;
            }


            //if old password is wrong
                if(!currentPass.equals(msessionManager.getUserDetailsFromSP()
                        .get(KEY_PASSWORD))){
                    password_error.setVisibility(View.VISIBLE);
                    password_error.setText("*Current password is wrong");
                    et_new_pass.setText("");
                    et_confirm_pass.setText("");

                    return;
                }


            //if new password is shorter than six character
            if (newPass.length() < 6) {
                password_error.setVisibility(View.VISIBLE);
                password_error.setText("*New password must be of at least six characters");
                et_confirm_pass.setText("");
                return;
            }

            if (!newPass.equals(confirmPass)) {
                password_error.setVisibility(View.VISIBLE);
                password_error.setText("*New password and confirm password do not match");
                et_confirm_pass.setText("");
                return;
            }

            password_error.setVisibility(View.GONE);

            //Toast.makeText(EditProfile.this,"new Pass "+newPass,Toast.LENGTH_SHORT).show();

            //et_password.setText(newPass);
            //sendNewPasswordToDataBase(newPass);
            alertDialog.dismiss();

        });

        cancel.setOnClickListener(v12 -> alertDialog.dismiss());
        alertDialog.show();


    }

    public void imageSelect(int check) {
        permissionsCheck();
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.setType("image/*");
        if(check==2000){
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        }
        if(check==1000){
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST_PARKING);
        }

    }

    public void permissionsCheck() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode == PROFILE_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();

            Intent cropIntent = CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .getIntent(this);
            startActivityForResult(cropIntent, CROP_PROFILE);

        }
        if (requestCode == CROP_PROFILE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
               // mProgressDialog.show();

                Uri resultUri = result.getUri();
                // sendProfilePicToServer(resultUri);
               // Glide.with(this).load(resultUri).into(imageView);
                imageView.setImageURI(resultUri);
                imageView.invalidate();


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Toast.makeText(UserProfile.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == PARKING_PIC && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();

            Intent cropIntent = CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .getIntent(this);
            startActivityForResult(cropIntent, CROP_PARKING);

        }
        if (requestCode == CROP_PARKING) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                // mProgressDialog.show();

                Uri resultUri = result.getUri();
                // sendProfilePicToServer(resultUri);


                try {
                    Glide.with(iv_park.getContext()).load(resultUri)
                            .fitCenter().placeholder(R.drawable.image_svg)
                            .into(iv_park);



                    // imagePopup.initiatePopupWithPicasso(photoURI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                iv_plus.setVisibility(View.GONE);
                addmore.setVisibility(View.GONE);


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Toast.makeText(UserProfile.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        }










    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setAddress(double lat, double lang) {
        Log.e("TAG", "called : setAddress");

        TextView tv_address  = findViewById(R.id.tv_address);

        Geocoder geocoder;
        List<Address> addresses = null;
        geocoder = new Geocoder(this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(lat, lang, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.e("TAG","address found="+addresses);

        if(addresses==null ) {
            tv_address.setText(LOCATION_NOT_FOUND);
          //  tv_address.setSelection(et_address.getText().length());
           // mProgressBar.setVisibility(View.GONE);
            return;
        }

        else if(addresses.size()==0){
            tv_address.setText(LOCATION_NOT_FOUND);
           // tv_address.setSelection(et_address.getText().length());
            //mProgressBar.setVisibility(View.GONE);
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
        //tv_address.setSelection(et_address.getText().length());

        //mProgressBar.setVisibility(View.GONE);



    }



}

