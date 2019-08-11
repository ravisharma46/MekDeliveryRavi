package com.naruto.mekvahandelivery;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.user_profile.Checklist;
import com.naruto.mekvahandelivery.user_profile.ShowAccountDetails;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.accounts.AccountManager.KEY_PASSWORD;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.EMAIL;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.MOBILE;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.NAME;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.PROFILE_ID;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TYPE;

public class UserProfile extends AppCompatActivity {

    private static final int GALLARY_REQUEST = 1;
    private Button change_passWord, bt_done,bt_checklist;
    private FrameLayout account_details;
    private TextView name, mobile, email, address, partnerType, executive_id, name_1, update_pic;
    //private static final String myUrl="https://mekvahan.com/api/user/delivery/completeDelivery";
    private CircleImageView imageView;
    private int mFlag = 0;
    private LoginSessionManager msessionManager;


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
        address = findViewById(R.id.tvaddress);
        partnerType = findViewById(R.id.tvpartner);
        executive_id = findViewById(R.id.tvprofileid);
        update_pic = findViewById(R.id.tvupdatepic);
        bt_checklist=findViewById(R.id.bt_checklist);



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









        update_pic.setOnClickListener(view -> {
            if (ContextCompat.checkSelfPermission(UserProfile.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(UserProfile.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                return;
            }

            mFlag = 2;
            Intent gallaryIntent = new Intent(Intent.ACTION_PICK);
            gallaryIntent.setType("image/*");
            gallaryIntent.putExtra("flag", 1);

            startActivityForResult(gallaryIntent, GALLARY_REQUEST);
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




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLARY_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();

            imageView.setImageURI(imageUri);


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





}

