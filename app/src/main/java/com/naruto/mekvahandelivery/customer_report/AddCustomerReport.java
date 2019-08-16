package com.naruto.mekvahandelivery.customer_report;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;
import com.naruto.mekvahandelivery.signature.SignatureActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;

@SuppressLint("SetTextI18n")
public class AddCustomerReport extends AppCompatActivity implements Car_Add_fragment.OnFragmentInteractionListener,
        Bike_Add_fragment.OnFragmentInteractionListener, AddCustomerReportAdapter.OnAdapterClickListener {
    private FrameLayout car, bike;
    private Button btn, addDetails;
    private ImageView car_image, bike_image, img_sign;
    private TextView tvbike, tvcar, document;
    RecyclerView.Adapter imageDocumentAdapter;
    RecyclerView imageDocumentView;
    File mPhotoFile;
    private LoginSessionManager sessionManager;

    private String addCarReportapiUrl = "https://mekvahan.com/api/CarRegularServiceReport",
            bookingId, buttonId;
    static final int REQUEST_TAKE_PHOTO = 1;
    private int rv_index = 6;
    private Uri photoURI = null, prevPhotoUri = null;
    private Map<String, String> carButton, bikeButton, reportButton;
    private Map<String, Integer> dataIndex;
    private List<AddCustomerReportData> reportDocument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer_report);

        carButton = new HashMap<>();
        carButton = initCarData();
        bikeButton = new HashMap<>();
        bikeButton = initBikeData();
        reportButton = new HashMap<>();
        reportButton = initReportData();
        dataIndex = new HashMap<>();
        dataIndex = initIndex();
        reportDocument = new ArrayList<>();
        reportDocument = initDocumentData();

        bookingId = getIntent().getStringExtra("bookingId");

        try{
            final Drawable upArrow = getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
            if (getSupportActionBar() != null && upArrow != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
                getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Customer report</font>"));
                upArrow.setColorFilter(getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
                getSupportActionBar().setHomeAsUpIndicator(upArrow);
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        addDetails = findViewById(R.id.bt_done);
        car = findViewById(R.id.frame_2);
        bike = findViewById(R.id.frame_1);
        car_image = findViewById(R.id.car_image);
        bike_image = findViewById(R.id.bike_image);
        tvbike = findViewById(R.id.tvbike);
        tvcar = findViewById(R.id.tvcar);
        document = findViewById(R.id.tvDocument);
        img_sign=findViewById(R.id.image_sign);
        sessionManager = new LoginSessionManager(this);
        Button take_sign = findViewById(R.id.bt_sign);
        ImageView img_cancel = findViewById(R.id.image_cross);
        imageDocumentView = findViewById(R.id.rv_imagedocument);
        imageDocumentView.setHasFixedSize(false);
        imageDocumentView.setLayoutManager(new LinearLayoutManager(imageDocumentView.getContext(), LinearLayoutManager.HORIZONTAL, false));

        imageDocumentAdapter = new AddCustomerReportAdapter(reportDocument, imageDocumentView.getContext());
        imageDocumentView.setAdapter(imageDocumentAdapter);

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
        take_sign.setOnClickListener(view -> {
            Intent i=new Intent(AddCustomerReport.this, SignatureActivity.class);
            startActivityForResult(i,2);

        });
        img_cancel.setOnClickListener(view -> img_sign.setImageResource(R.drawable.image_svg));

        addDetails.setOnClickListener(this::sendUserDetails);

    }

    private void sendUserDetails(View view) {
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, addCarReportapiUrl, response -> {
                try {
    //                JSONObject jsonObject = new JSONObject(response);
    //                JSONObject dataObject = jsonObject.getJSONObject("data");
    //                JSONArray documentDataArray = dataObject.getJSONArray("rc");
                    Log.e("response report", "null 123");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, volleyError -> {
                Log.e("volleyerror", "api not responding");
                volleyError.printStackTrace();
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> bodyparams = new HashMap<>();
                    //TODO add all body parameters
                    bodyparams.put("booking_id", bookingId);
                    bodyparams.put("tool_kit", carButton.get("toolkit"));
                    bodyparams.put("stepney", carButton.get("stepney"));
                    bodyparams.put("mudguard", carButton.get("mudguard"));
                    bodyparams.put("mats", carButton.get("mats"));
                    bodyparams.put("keychain", carButton.get("keychain"));
                    bodyparams.put("service_book", carButton.get("servicebook"));
                    bodyparams.put("wheel_cover", carButton.get("wheelcover"));
                    bodyparams.put("lock", carButton.get("lock"));
                    bodyparams.put("jack_handle", carButton.get("jackhandle"));
                    bodyparams.put("carpet", carButton.get("carpet"));
                    bodyparams.put("stereo_panel", carButton.get("stereopanel"));
                    bodyparams.put("speakers", carButton.get("speakers"));
                    bodyparams.put("car_cover", "null");    //?????
                    bodyparams.put("seat_cover", "null");   //????
                    bodyparams.put("meter_percentage", "null"); //?????
                    bodyparams.put("odometer", reportButton.get("odometer"));
                    bodyparams.put("description", reportButton.get("otherreport"));
                    bodyparams.put("battery_info", reportButton.get("sbrand"));
                    bodyparams.put("miscellaneous", "null");    //??????
                    bodyparams.put("head_rest", reportButton.get("headrest"));
                    bodyparams.put("floor_mats", reportButton.get("floormats"));
                    bodyparams.put("wheel_cap", reportButton.get("wheelcap"));
                    bodyparams.put("mud_flap", reportButton.get("mudflap"));
                    bodyparams.put("rc", "null");   //reportDocument.get(0).getPhotoUri().toString());
                    bodyparams.put("puc", "null");
                    bodyparams.put("insurance", "null");
                    bodyparams.put("road_tax", "null");
                    bodyparams.put("passenger_tax", "null");
                    bodyparams.put("pollution_paper", "null");
                    bodyparams.put("image", "null");
                    bodyparams.put("signature", "null");

                    return bodyparams;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headerParams = new HashMap<>();
                    headerParams.put("Accept", "application/json");
                    headerParams.put("Authorization", sessionManager.getUserDetailsFromSP()
                            .get(LoginSessionManager.TOKEN_TYPE)+" "+sessionManager.getUserDetailsFromSP()
                            .get(LoginSessionManager.ACCESS_TOKEN));
                    return headerParams;
                }

//                @Override
//                public byte[] getBody() throws AuthFailureError {
//                    try {
//                        InputStream iStream =   getContentResolver().openInputStream(reportDocument.get(0).getPhotoUri());
//                        byte[] inputData;
//                        inputData = getBytes(iStream);
//                        return inputData;
//                    } catch (IOException e) {
//                        Log.e("byte param", "getbytes");
//                        e.printStackTrace();
//                    }
//                    return super.getBody();
//                }

            };

            stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                    NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            MySingleton.getInstance(this.getApplicationContext()).addToRequestQueue(stringRequest);
        } catch (Exception e) {
            Log.e("try failed", "no connection");
            e.printStackTrace();
        }
    }

    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    // storing the index of all buttons passed in the list sequentially
    private Map<String, Integer> initIndex() {
        Map<String, Integer> dataIndex = new HashMap<>();
        dataIndex.put("bt_rc", 0);
        dataIndex.put("bt_puc", 1);
        dataIndex.put("bt_insurance", 2);
        dataIndex.put("bt_roadtax", 3);
        dataIndex.put("bt_passengertax", 4);
        dataIndex.put("bt_pollutionpaper", 5);
        return dataIndex;
    }

    private List<AddCustomerReportData> initDocumentData() {
        List<AddCustomerReportData> reportDocument = new ArrayList<>();
        reportDocument.add(new AddCustomerReportData("bt_rc", null, "0"));
        reportDocument.add(new AddCustomerReportData("bt_puc", null,"0"));
        reportDocument.add(new AddCustomerReportData("bt_insurance", null, "0"));
        reportDocument.add(new AddCustomerReportData("bt_roadtax", null, "0"));
        reportDocument.add(new AddCustomerReportData("bt_passengertax", null, "0"));
        reportDocument.add(new AddCustomerReportData("bt_pollutionpaper", null, "0"));
        return reportDocument;
    }

    private Map<String, String> initReportData() {
        Map<String, String> reportData = new HashMap<>();
        reportData.put("headrest", "0");
        reportData.put("floormats", "0");
        reportData.put("wheelcap", "0");
        reportData.put("mudflap", "0");
        reportData.put("odometer", "0");
        reportData.put("otherreport", "0");
        reportData.put("sbrand", "null");
        return reportData;
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
        Car_Add_fragment c_Fragment = new Car_Add_fragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout,
                c_Fragment,
                c_Fragment.getTag()).commit();
    }

    private void loadBikeFragment() {
        Bike_Add_fragment b_Fragment = new Bike_Add_fragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frameLayout,
                b_Fragment,
                b_Fragment.getTag()).commit();
    }

    private void dispatchTakePictureIntent(int requestCode) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                ex.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this,
                        "com.naruto.mekvahandelivery",
                        photoFile);

                mPhotoFile = photoFile;
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, requestCode);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        // Save a file: path for use with ACTION_VIEW intents
//        File image = File.createTempFile(
//                imageFileName,  /* prefix */
//                ".jpg",         /* suffix */
//                storageDir      /* directory */
//        );
//        String currentPhotoPath = image.getAbsolutePath();
        return File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==2 && data!=null){
            byte[] bytes = data.getByteArrayExtra("image");
            Bitmap bmp = null;
            if (bytes != null) {
                bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            }
            img_sign.setImageBitmap(bmp);
        } else if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            int dIndex = dataIndex.get(buttonId);
            reportDocument.set(dIndex, new AddCustomerReportData(buttonId, photoURI, "1"));
            imageDocumentAdapter.notifyItemChanged(dIndex);
            imageDocumentView.scrollToPosition(dIndex);
            prevPhotoUri = photoURI;
            btn.setBackgroundResource(R.drawable.customer_reprt_bt02);
            btn.setTextColor(getColor(android.R.color.white));
        } else if (requestCode == REQUEST_TAKE_PHOTO) {
            prevPhotoUri = null;
        } else if (requestCode == 3 && resultCode == RESULT_OK) {
            reportDocument.add(rv_index, new AddCustomerReportData("bt_rvcamera", photoURI, "3"));
            imageDocumentAdapter.notifyItemInserted(rv_index++);
            imageDocumentView.scrollToPosition(rv_index-1);
            prevPhotoUri = photoURI;
        } else if (requestCode == 3) {
            prevPhotoUri = null;
        }
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
    public void onFragmentInteraction(View view) {
        if (getSupportFragmentManager().findFragmentById(R.id.frameLayout) instanceof Car_Add_fragment) {
            onCarFragmentButtonClick(view);
        } else if (getSupportFragmentManager().findFragmentById(R.id.frameLayout) instanceof Bike_Add_fragment) {
            onBikeFragmentButtonClick(view);
        }
    }

    private void onBikeFragmentButtonClick(View view) {
        String bikeButtonId = getResources().getResourceEntryName(view.getId());
        Button btn = findViewById(view.getId());
        bikeButtonId = bikeButtonId.substring(3);
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

    private void onCarFragmentButtonClick(View view) {
        String carButtonId = getResources().getResourceEntryName(view.getId());
        Button btn = findViewById(view.getId());
        carButtonId = carButtonId.substring(3);
        if (carButton.get(carButtonId).equals("0")) {
            btn.setBackgroundResource(R.drawable.customer_reprt_bt02);
            btn.setTextColor(getColor(android.R.color.white));
            carButton.put(carButtonId, "1");
        } else if (carButton.get(carButtonId).equals("1")) {
            btn.setBackgroundResource(R.drawable.customer_rprt_bt01);
            btn.setTextColor(getColor(android.R.color.black));
            carButton.put(carButtonId, "0");
        }
    }

    public void onAddReportButton(View view) {
        buttonId = getResources().getResourceEntryName(view.getId());

        if (!buttonId.equals("bt_rvcamera")) {
            btn = findViewById(view.getId());
            if (reportDocument.get(dataIndex.get(buttonId)).getBtnstate().equals("0")) {
                dispatchTakePictureIntent(REQUEST_TAKE_PHOTO);
            } else if (reportDocument.get(dataIndex.get(buttonId)).getBtnstate().equals("1")) {
                reportDocument.set(dataIndex.get(buttonId), new AddCustomerReportData(buttonId, null, "0"));
                imageDocumentAdapter.notifyItemChanged(dataIndex.get(buttonId));
                prevPhotoUri = null;
                btn.setBackgroundResource(R.drawable.customer_rprt_bt01);
                btn.setTextColor(getColor(android.R.color.black));
            }
        } else {
            dispatchTakePictureIntent(3);
        }
    }

    public void onAddReportButton(String buttonId) {
        this.buttonId = buttonId;
        if (!buttonId.endsWith("z")) {
            btn = findViewById(getResources().getIdentifier(buttonId, "id", getApplicationContext().getPackageName()));

            reportDocument.set(dataIndex.get(buttonId), new AddCustomerReportData(buttonId, null, "0"));
            imageDocumentAdapter.notifyItemChanged(dataIndex.get(buttonId));
            prevPhotoUri = null;
            btn.setBackgroundResource(R.drawable.customer_rprt_bt01);
            btn.setTextColor(getColor(android.R.color.black));
        } else {
            buttonId = buttonId.substring(0, buttonId.length()-1);
            int final_index = Integer.parseInt(buttonId);
            reportDocument.remove(final_index);
            imageDocumentView.getRecycledViewPool().clear();
            imageDocumentAdapter.notifyItemRemoved(final_index);

            // use below code only in case of crash due to position issue
//            imageDocumentAdapter.notifyDataSetChanged();

            rv_index--;
        }
    }

    @Override
    public void onAdapterInteraction(String buttonId) {
        onAddReportButton(buttonId);
    }
}