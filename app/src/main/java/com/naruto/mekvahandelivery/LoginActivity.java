package com.naruto.mekvahandelivery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager;
import com.naruto.mekvahandelivery.CommonFiles.MySingleton;
import com.naruto.mekvahandelivery.FeedbackPage.Feedback_page;

import org.json.JSONException;
import org.json.JSONObject;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.sendEmailIntent;
import java.util.HashMap;
import java.util.Map;

import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.RETRY_SECONDS;

public class LoginActivity extends AppCompatActivity {
    private static final String myUrl = "https://mekvahan.com/api/delivery/deliveryBoy";

    private ImageView iv_bg;
    private TextView tvfeedback;

    private LoginSessionManager mSession;
    private String  tokenType,accessToken,profile_id,name,mobile,email,type,latitude,longitude,partner_id,active;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iv_bg = findViewById(R.id.bg_img);
        tvfeedback=findViewById(R.id.btv_feedback);

        tvfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmailIntent(LoginActivity.this);
            }
        });



        mSession=new LoginSessionManager(getApplicationContext());

    }

    @Override
    protected void onResume() {
        super.onResume();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int windowWidth = size.x;
        int windowHeight = size.y;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                windowWidth, (windowHeight / 2)-40);
        iv_bg.setLayoutParams(params);
        iv_bg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void loginSubmit(View view) {
         userLogin();

    }

    @Override
    public void onBackPressed() {
        finish();


    }

    public void userLogin() {


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();


        //----if everything is fine-----
        StringRequest stringRequest = new StringRequest(Request.Method.POST, myUrl,
                response -> {
                    progressDialog.dismiss();

                    try {

                        Log.i("TAG",response);

                        JSONObject obj = new JSONObject(response);
                         tokenType   = obj.getString("token_type");
                         accessToken = obj.getString("access_token");

                        JSONObject user = obj.getJSONObject("DeliveryBoy details");
                        Log.e("TAG", response);

                        int userId          = user.getInt("id");
                         profile_id         = user.getString("profile_id");
                         name         = user.getString("name");
                         mobile       = user.getString("mobile");
                         email        = user.getString("email");
                         type =         user.getString("type");
                         latitude           = user.getString("latitude");
                         longitude     = user.getString("longitude");
                         partner_id      = user.getString("partner_id");
                         active     = user.getString("active");

                        mSession.createLoginSession(tokenType,accessToken,String.valueOf(userId),profile_id,
                       name,mobile,email,type,latitude,longitude,partner_id,active );

                        Intent intent = new Intent(LoginActivity.this, NavActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    Log.e("TAGR", error.toString());

                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();

                // params.put("delivery_boy_id","1");
                params.put("mobile", "9911202111");
                params.put("password", "mridul");
                params.put("provider", "deliverys");

                Log.e("TAG", params.toString());
                return params;
            }


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                return super.getHeaders();
            }
        };


        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }


}
