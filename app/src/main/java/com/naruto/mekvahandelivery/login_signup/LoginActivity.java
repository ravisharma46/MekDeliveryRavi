package com.naruto.mekvahandelivery.login_signup;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.naruto.mekvahandelivery.R;

public class LoginActivity extends AppCompatActivity {
//    private static final String myUrl = "https://mekvahan.com/api/delivery/deliveryBoy";

    private ImageView iv_bg;
    private TextView tvfeedback;

//    private LoginSessionManager mSession;
    private String  tokenType,accessToken,profile_id,name,mobile,email,type,latitude,longitude,partner_id,active;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iv_bg = findViewById(R.id.bg_img);

        replaceFragment(new LoginFragment());

//        mSession=new LoginSessionManager(getApplicationContext());

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

//    public void loginSubmit(View view) {
//         userLogin();
//        Intent intent = new Intent(LoginActivity.this, NavActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        finish();
//
//    }

    @Override
    public void onBackPressed() {
        finish();

    }

    public void replaceFragment(Fragment fragment) {
        Log.e(TAG, "replaceFragment");
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

//    public void userLogin() {
//
//
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Loading....");
//        progressDialog.show();
//
//
//        //----if everything is fine-----
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, myUrl,
//                response -> {
//                    progressDialog.dismiss();
//
//                    try {
//
//                        Log.i("TAG",response);
//
//                        JSONObject obj = new JSONObject(response);
//                         tokenType   = obj.getString("token_type");
//                         accessToken = obj.getString("access_token");
//
//                        JSONObject user = obj.getJSONObject("DeliveryBoy details");
//                        Log.e("TAG", response);
//
//                        int userId          = user.getInt("id");
//                         profile_id         = user.getString("profile_id");
//                         name         = user.getString("name");
//                         mobile       = user.getString("mobile");
//                         email        = user.getString("email");
//                         type =         user.getString("type");
//                         latitude           = user.getString("latitude");
//                         longitude     = user.getString("longitude");
//                         partner_id      = user.getString("partner_id");
//                         active     = user.getString("active");
//
//                        mSession.createLoginSession(tokenType,accessToken,String.valueOf(userId),profile_id,
//                       name,mobile,email,type,latitude,longitude,partner_id,active );
//
//                        Intent intent = new Intent(LoginActivity.this, NavActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        startActivity(intent);
//                        finish();
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                },
//                error -> {
//                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
//                    Log.e("TAGR", error.toString());
//
//                }) {
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<>();
//
//                // params.put("delivery_boy_id","1");
//                params.put("mobile", "9911202111");
//                params.put("password", "mridul");
//                params.put("provider", "deliverys");
//
//                Log.e("TAG", params.toString());
//                return params;
//            }
//
//
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//
//                return super.getHeaders();
//            }
//        };
//
//
//        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
//                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//
//        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
//
//    }


}
