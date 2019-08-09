package com.naruto.mekvahandelivery.OngoingOrders;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager;
import com.naruto.mekvahandelivery.CommonFiles.MySingleton;
import com.naruto.mekvahandelivery.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.RETRY_SECONDS;
import static com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager.ACCESS_TOKEN;
import static com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager.NAME;
import static com.naruto.mekvahandelivery.CommonFiles.LoginSessionManager.TOKEN_TYPE;

/**
 * A simple {@link Fragment} subclass.
 */
public class OngoingFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private static final String myUrl = "https://mekvahan.com/api/delivery/ongoing_booking";
    private ProgressDialog mProgressDialog;

    private List<MyListDataOngoingBooking> mBookingList;
    public OngoingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_ongoing, container, false);

        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage("Please wait...");

        mBookingList = new ArrayList<>();

        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        upcoming();


        return v;
    }

    private void upcoming() {
        mProgressDialog.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, myUrl,
                response -> {
                    try {

                        JSONObject Object = new JSONObject(response);


                        int status_1 = Object.getInt("status");
                        if(status_1!=1) {
                            Toast.makeText(getActivity(),"There is no data",Toast.LENGTH_SHORT).show();
                            return;
                        }

                        JSONArray jsonArray = Object.getJSONArray("response");


                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);

                             String bookingId = jsonObject.getString("booking_id");
                             String service_type=jsonObject.getString("service_type");
                             JSONObject regular_service=jsonObject.getJSONObject("regular_service");
                             if(service_type.contains("regular_service")){
                                 String serviceName = regular_service.getString("service_name");
                                 Log.e("TAG",serviceName);

                             }



                            JSONArray regular_serviceArray= jsonObject.getJSONArray("regular_service");

                            JSONObject object1 = regular_serviceArray.getJSONObject(0);

                            JSONObject serviceId = object1.getJSONObject("service_id");
                            String serviceName = serviceId.getString("service_name");
                            String serviceDate = object1.getString("service_date");
                            String serviceTime = object1.getString("service_time");
                            String paymentStatus = object1.getString("payment");
                            String status = object1.getString("status");

                            String mobileNo = object1.getString("mobile");

                            JSONObject vehicleDetails = object1.getJSONObject("Vehicle Details");
                            JSONObject vehicleData = vehicleDetails.getJSONObject("data");
                            String licencePlate = vehicleData.getString("license_plate");

                            JSONObject modelId = vehicleData.getJSONObject("model_id");



                            //vehicle_logo
                            JSONArray companyId =modelId.getJSONArray("company_id");
                            JSONObject object2 = companyId.getJSONObject(0);
                            String modelName =object2.getString("name");
                            JSONArray logo =object2.getJSONArray("logo");
                             String logo_url = logo.getString(1);

                           //vehicle_image
                            JSONArray images =modelId.getJSONArray("images");
                            String image_url = images.getString(1);





                            mBookingList.add(new  MyListDataOngoingBooking(status,serviceDate,serviceTime, logo_url,mobileNo,modelName,
                                    licencePlate, bookingId, paymentStatus,serviceName,image_url));



                        }
                        adapter = new OngoingAdapter_1(getActivity(), (ArrayList<MyListDataOngoingBooking>) mBookingList);
                        recyclerView.setAdapter(adapter);

                        mProgressDialog.dismiss();



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            Toast.makeText(getContext(),"Something get wrong",Toast.LENGTH_LONG).show();
            Log.e("TAG", error.toString());
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers=new HashMap<>();
                headers.put("Accept","application/json");
                LoginSessionManager loginSessionManager=new LoginSessionManager(getActivity());
                HashMap<String,String> token=loginSessionManager.getUserDetailsFromSP();
                String token_type=token.get(TOKEN_TYPE);
                String acces_token= token.get(ACCESS_TOKEN);
                headers.put("Authorization",token_type+" "+acces_token);

                return headers;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);
    }






}
