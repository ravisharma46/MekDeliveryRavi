package com.naruto.mekvahandelivery.customer_report;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.TimeoutError;
import com.android.volley.toolbox.StringRequest;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.BASE;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;

@SuppressLint("SetTextI18n")
public class ViewCustomerReport extends AppCompatActivity implements ViewCustomerReportAdapter.OnReportAdapterClickListener {

    private LoginSessionManager sessionManager;

    private RecyclerView recyclerViewReport;
    private RecyclerView.Adapter adapterViewReport;
    private FrameLayout car, bike;
    private ImageView car_image, bike_image,img_sign;
    private TextView tvbike, tvcar, document;
    private Button take_sign, btRc, btPuc, btInsurance, btRoadTax, btPassengertax, btPollutionPaper, stepney;
    private TextView tvHeadRest, tvFloorMats, tvMudFlap, tvSeatCover, tvOtherreport, tvBatttery, tvOdometer;

    private Map<String, String> carButton, bikeButton, reportButton;
    private String bookingId, key;
    private List<String> imageStringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer_report);

        try{
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
            getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>View customer report</font>"));
            final Drawable upArrow = getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
            upArrow.setColorFilter(getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().setHomeAsUpIndicator(upArrow);

        }
        catch(Exception e){
            e.printStackTrace();
        }

        Car_view_fragment car_view_fragment = new Car_view_fragment();
        imageStringList = new ArrayList<>();
        sessionManager = new LoginSessionManager(this);
        carButton = new HashMap<>();
        carButton = initCarData();
        bikeButton = new HashMap<>();
        bikeButton = initBikeData();
        reportButton = new HashMap<>();
        reportButton = initReportData();
        car = findViewById(R.id.frame_car);
        bike = findViewById(R.id.frame_bike);
        car_image = findViewById(R.id.car_image);
        bike_image = findViewById(R.id.bike_image);
        tvbike = findViewById(R.id.tvbike);
        tvcar = findViewById(R.id.tvcar);
        document = findViewById(R.id.tvDocument);
        img_sign=findViewById(R.id.image_vsign);
        btRc = findViewById(R.id.bt_vrc);
        btPuc = findViewById(R.id.bt_vpuc);
        btInsurance = findViewById(R.id.bt_vinsurance);
        btPassengertax = findViewById(R.id.bt_vpassengertax);
        btPollutionPaper = findViewById(R.id.bt_vpollutionpaper);
        btRoadTax = findViewById(R.id.bt_vroadtax);
        tvHeadRest = findViewById(R.id.tv_vheadrest);
        tvFloorMats = findViewById(R.id.tv_vfloormats);
        tvMudFlap = findViewById(R.id.tv_vmudflap);
        tvOdometer = findViewById(R.id.tv_vodometer);
        tvSeatCover = findViewById(R.id.tv_vseatcover);
        tvOtherreport = findViewById(R.id.tv_votherReport);
        tvBatttery = findViewById(R.id.tv_vBattery);

        recyclerViewReport = findViewById(R.id.rv_viewimagedocument);
        recyclerViewReport.setHasFixedSize(false);
        recyclerViewReport.setLayoutManager(new LinearLayoutManager(recyclerViewReport.getContext(),
                LinearLayoutManager.HORIZONTAL, false));

        adapterViewReport = new ViewCustomerReportAdapter(imageStringList, recyclerViewReport.getContext());
        recyclerViewReport.setAdapter(adapterViewReport);

        bookingId = getIntent().getStringExtra("bookingId");



        loadCarFragment();
        load_car();

        car.setOnClickListener(view -> {
            loadCarFragment();
            load_car();

        });

        bike.setOnClickListener(view -> {
            loadBikeFragment();
            load_bike();

        });

    }

    private void load_bike() {
        bike.setBackgroundResource(R.color.chart_deep_red);
        tvbike.setTextColor(Color.WHITE);
        bike_image.setImageResource(R.drawable.bike_white);

        car.setBackgroundResource(R.color.white);
        tvcar.setTextColor(Color.BLACK);
        car_image.setImageResource(R.drawable.carblack);
        document.setText("Bike document");
    }

    private void load_car() {
        bike.setBackgroundResource(R.color.white);
        tvbike.setTextColor(Color.BLACK);
        bike_image.setImageResource(R.drawable.bike_black);

        car.setBackgroundResource(R.color.chart_deep_red);
        tvcar.setTextColor(Color.WHITE);
        car_image.setImageResource(R.drawable.car_white);
        document.setText("Car document");
    }

    private void loadCarFragment() {
        Car_view_fragment c_Fragment = new Car_view_fragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout,
                c_Fragment,
                c_Fragment.getTag()).commit();
    }

    private void loadBikeFragment() {
        Bike_view_fragment b_Fragment = new Bike_view_fragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout,
                b_Fragment,
                b_Fragment.getTag()).commit();
    }

    private Map<String, String> initBikeData() {
        Map<String, String> bikeButton = new HashMap<>();
        bikeButton.put("toolkit", "0");
        bikeButton.put("firstadkit", "0");
        bikeButton.put("keychain", "0");
        bikeButton.put("bikecover", "0");
        bikeButton.put("servicebook", "0");
        bikeButton.put("miscellenoustool", "0");
        return bikeButton;
    }

    private Map<String, String> initCarData() {
        Map<String, String> carButton = new HashMap<>();
        carButton.put("stepney", "0");
        carButton.put("toolkit", "0");
        carButton.put("mudguard", "0");
        carButton.put("keychain", "0");
        carButton.put("servicebook", "0");
        carButton.put("mats", "0");
        carButton.put("wheelcover", "0");
        carButton.put("lock", "0");
        carButton.put("jackhandle", "0");
        carButton.put("carpet", "0");
        carButton.put("stereopanel", "0");
        carButton.put("speakers", "0");
        return carButton;
    }

    private Map<String, String> initReportData() {
        Map<String, String> reportData = new HashMap<>();
        reportData.put("rc", "0");
        reportData.put("puc", "0");
        reportData.put("insurance", "0");
        reportData.put("roadtax", "0");
        reportData.put("passengertax", "0");
        reportData.put("pollutionpaper", "0");
        reportData.put("headrest", "0");
        reportData.put("floormats", "0");
        reportData.put("seatcover", "0");
        reportData.put("mudflap", "0");
        reportData.put("odometer", "0");
        reportData.put("otherreport", "0");
        reportData.put("sbrand", "Exide");
        return reportData;
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCarReport();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void getCarReport() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                BASE+"CarRegularServiceReport/"+bookingId,
                response -> {

                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        Log.e("jsonobject", jsonObject.toString());

                        JSONObject data = jsonObject.getJSONObject("data");
                        if (bookingId.equals(data.getString("booking_id"))) {
                            Log.e("response", "booking id matched");

                            Iterator<String> iterator = data.keys();
                            while (iterator.hasNext()) {
                                String key = iterator.next();
                                switch (key) {
                                    case "tool_kit":
                                        onCarFragmentButtonClick("toolkit", data.getString(key));
                                        break;
                                    case "stepney":
                                        onCarFragmentButtonClick("stepney", data.getString(key));
                                        break;
                                    case "mudguard":
                                        onCarFragmentButtonClick("mudguard", data.getString(key));
                                        break;
                                    case "mats":
                                        onCarFragmentButtonClick("mats", data.getString(key));
                                        break;
                                    case "keychain":
                                        onCarFragmentButtonClick("keychain", data.getString(key));
                                        break;
                                    case "service_book":
                                        onCarFragmentButtonClick("servicebook", data.getString(key));
                                        break;
                                    case "wheel_cover":
                                        onCarFragmentButtonClick("wheelcover", data.getString(key));
                                        break;
                                    case "lock":
                                        onCarFragmentButtonClick("lock", data.getString(key));
                                        break;
                                    case "jack_handle":
                                        onCarFragmentButtonClick("jackhandle", data.getString(key));
                                        break;
                                    case "carpet":
                                        onCarFragmentButtonClick("carpet", data.getString(key));
                                        break;
                                    case "stereo_panel":
                                        onCarFragmentButtonClick("stereopanel", data.getString(key));
                                        break;
                                    case "speakers":
                                        onCarFragmentButtonClick("speakers", data.getString(key));
                                        break;
                                    case "head_rest":
                                        tvHeadRest.setText(data.getString(key));
                                        break;
                                    case "floor_mats":
                                        tvFloorMats.setText(data.getString(key));
                                        break;
                                    case "seat_cover":
                                        tvSeatCover.setText(data.getString(key));
                                        break;
                                    case "mud_flap":
                                        tvMudFlap.setText(data.getString(key));
                                        break;
                                    case "description":
                                        tvOtherreport.setText(data.getString(key));
                                        break;
                                    case "battery_info":
                                        tvBatttery.setText(data.getString(key));
                                        break;
                                    case "odometer":
                                        tvOdometer.setText(data.getString(key));
                                        break;
                                    case "rc":
                                        this.key = key;
                                        loadImage(data.getString(key));
                                        break;
                                    case "puc":
                                        this.key = key;
                                        loadImage(data.getString(key));
                                        break;
                                    case "insurance":
                                        this.key = key;
                                        loadImage(data.getString(key));
                                        break;
                                    case "road_tax":
                                        this.key = key;
                                        loadImage(data.getString(key));
                                        break;
                                    case "passenger_tax":
                                        this.key = key;
                                        loadImage(data.getString(key));
                                        break;
                                    case "pollution_paper":
                                        this.key = key;
                                        loadImage(data.getString(key));
                                        break;
                                    case "image":
                                        this.key = key;
                                        loadImage(data.getString(key));
                                        break;
                                    case "signature":
                                        this.key = key;
                                        loadImage(data.getString(key));
                                        break;
                                }
                            }
                        } else {
                            throw new RuntimeException("Invalid Booking Id");
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> {
                    NetworkResponse networkResponse = error.networkResponse;
                    String errorMessage = "Unknown error";
                    if (networkResponse == null) {
                        if (error.getClass().equals(TimeoutError.class)) {
                            errorMessage = "Request timeout";
                        } else if (error.getClass().equals(NoConnectionError.class)) {
                            errorMessage = "Failed to connect server";
                        }
                    } else {
                        String result = new String(networkResponse.data);
                        try {
                            JSONObject response = new JSONObject(result);
                            String status = response.getString("status");
                            String message = response.getString("message");

                            Log.e("Error Status", status);
                            Log.e("Error Message", message);

                            switch (networkResponse.statusCode) {
                                case 404:
                                    errorMessage = "Resource not found";
                                    break;
                                case 401:
                                    errorMessage = message + " Please login again";
                                    break;
                                case 400:
                                    errorMessage = message + " Check your inputs";
                                    break;
                                case 500:
                                    errorMessage = message + " Something is getting wrong";
                                    break;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.i("Error", errorMessage);
                    error.printStackTrace();
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();

                params.put("Accept","application/json");
                params.put("Authorization", sessionManager.getUserDetailsFromSP()
                        .get(LoginSessionManager.TOKEN_TYPE)+" "+sessionManager.getUserDetailsFromSP()
                        .get(LoginSessionManager.ACCESS_TOKEN));
                return params;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

    private void onBikeFragmentButtonClick(String keyId) {
        String bikeButtonId = "bt_bv" + keyId;
        Button btn = findViewById(getResources().getIdentifier(bikeButtonId, "id", getPackageName()));
        bikeButtonId = bikeButtonId.substring(5);
        if (bikeButton.get(bikeButtonId).equals("0")) {
            btn.setBackgroundResource(R.drawable.customer_reprt_bt02);
            btn.setTextColor(getColor(android.R.color.white));
            bikeButton.put(bikeButtonId, "1");
        } else if (carButton.get(bikeButtonId).equals("1")) {
            btn.setBackgroundResource(R.drawable.customer_rprt_bt01);
            btn.setTextColor(getColor(android.R.color.black));
            bikeButton.put(bikeButtonId, "0");
        }
    }

    private void onCarFragmentButtonClick(String keyId, String state) {
        String carButtonId = "bt_cv" + keyId;
        Button btn = findViewById(getResources().getIdentifier(carButtonId, "id", getPackageName()));
        if (state.equals("0")) {
            btn.setBackgroundResource(R.drawable.customer_reprt_bt02);
            btn.setTextColor(getColor(android.R.color.white));
        } else if (state.equals("1")) {
            btn.setBackgroundResource(R.drawable.customer_rprt_bt01);
            btn.setTextColor(getColor(android.R.color.black));
        }
    }

    public void loadImage(String imageString) {
        imageStringList.add(0, imageString);
        adapterViewReport.notifyItemInserted(0);
    }

    @Override
    public void onReportAdapterInteraction(String imageString) {
        if (!imageString.equals("")) {
            String carButtonId = "bt_v" + this.key;
            Button btn = findViewById(getResources().getIdentifier(carButtonId, "id", getPackageName()));
            btn.setBackgroundResource(R.drawable.customer_reprt_bt02);
            btn.setTextColor(getColor(android.R.color.white));
        }
    }

    @Override
    public void onReportAdapterInteraction(int adapterPosition) {
        imageStringList.remove(adapterPosition);
        recyclerViewReport.getRecycledViewPool().clear();
        adapterViewReport.notifyItemRemoved(adapterPosition);
    }
}