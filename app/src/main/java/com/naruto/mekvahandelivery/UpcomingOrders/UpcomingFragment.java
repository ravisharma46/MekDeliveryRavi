package com.naruto.mekvahandelivery.UpcomingOrders;


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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.naruto.mekvahandelivery.CommonFiles.MySingleton;
import com.naruto.mekvahandelivery.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.RETRY_SECONDS;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private static final String myUrl = "https://mekvahan.com/api/delivery/upcoming_booking";


    public UpcomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_upcoming, container, false);


        ArrayList<MyListDataUpcomingBooking> list = initData();
        
        
        recyclerView = v.findViewById(R.id.recyclerView_1);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new UpcomingAdapter(list);
        recyclerView.setAdapter(adapter);

      //getActivity().setTitle("Upcoming booking");
     // getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);



        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        upcoming();
    }

    private void upcoming() {

        StringRequest stringRequest=new StringRequest(Request.Method.POST, myUrl,
                response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);

                        JSONArray responseArray = jsonObject.getJSONArray("response");

                        for(int i=0;i<responseArray.length();i++){

                            JSONObject regularService= responseArray.getJSONObject(0);

                            JSONArray regular_serviceArray= regularService.getJSONArray("regular_service");

                            JSONObject object1 = regular_serviceArray.getJSONObject(0);

                            JSONObject serviceId = object1.getJSONObject("service_id");

                            String serviceName = serviceId.getString("service_name");
                            String serviceDate = object1.getString("service_date");
                            String serviceTime = object1.getString("service_time");
                            String paymentStatus = object1.getString("payment");
                            String bookingId = object1.getString("booking_id");
                            String mobileNo = object1.getString("mobile");

                            JSONObject vehicleDetails = object1.getJSONObject("Vehicle Details");
                            JSONObject vehicleData = vehicleDetails.getJSONObject("data");
                            String licencePlate = vehicleData.getString("license_plate");

                            JSONObject modelId = vehicleData.getJSONObject("model_id");
                            String modelName =modelId.getString("name");

                            JSONArray companyId =modelId.getJSONArray("company_id");

                            JSONObject object2 = companyId.getJSONObject(0);

                            JSONArray logo =object2.getJSONArray("logo");

                            // JSONObject object3 = logo.getJSONObject(1);

//                            Picasso.with()


//                            MyListDataUpcomingBooking myListDataUpcomingBooking=new MyListDataUpcomingBooking()



                        }


                        //For NO Plate




//                        Log.i("tag111",modelName);

//                        String service_type = status.getString("service_type");

//                        if (service_type.equals("1")) {
//                            Log.i("tag111", "true");
//                        } else
//                            Log.i("tag111", "false");

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
                headers.put("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjJjMWE4ZTM5MTc5OTU3ZDE1ZDg4NzI0MDgxZDI4MDY2MzM0MDNlNDEzNDA5NDdlYTRlMzQwYWJkMTdhMjBjODAzOGNmMWM2OWY0ZTI2YTI3In0.eyJhdWQiOiIxIiwianRpIjoiMmMxYThlMzkxNzk5NTdkMTVkODg3MjQwODFkMjgwNjYzMzQwM2U0MTM0MDk0N2VhNGUzNDBhYmQxN2EyMGM4MDM4Y2YxYzY5ZjRlMjZhMjciLCJpYXQiOjE1NjQzMjkwMTcsIm5iZiI6MTU2NDMyOTAxNywiZXhwIjoxNTk1OTUxNDE3LCJzdWIiOiI3Iiwic2NvcGVzIjpbXX0.AeIzLVIDk88_ka6qJ-Ep0GSeBhxTq3yUInU_r_RfbaUJxfRNmhyuUtWoJbl0MFxyhfEHkGOvJ1PDRwkh59LQc5tyk3RT0aByxQkJUx4GKjbivYcF19YPOEqVZG-hnd_aJuh-AyFlDn6Fk2HPLFiFxQoLamsMzzNwhqbOY7ojxtxOQ0m5mCfxmU-Yixp6Q4Hkm9ga6OprGHRuZU5c4WTCXWoTxTtbf1SWwN8lXBkU0hOWc0-vXCmmuzDmVP_l3WM7yCtQTgZfhxXhQwCU3JyZMX0CZZKJ-MDGmVepj-yTNfqRKaDk3IsrxWTYqsvd1FtX3NIjZvNMVGdlUkB6GNQBgj0iqs-h9cHIXMqpPZA7EPieBORyawzkyairPFLi5Tk6uh7QJmJLFBvdUjxPcm3NpxOYaADt-RK7o_ojyi-VdhyUA_IsFD6H2Hs79piad0TNi2xaj0rf2rGQVVdS3baTtmugqpsO_Fm1T56Dq93y92VoWugrvEA3oB3IhSCHR8Nw5mPOpZx19F6mnyU2tVVNttDqEdBI-aEi_C2oZDVBNU_Wa2nvUV0Gv1qwAuPk2vBY5ncOxeRu-J2V22TGgHznUOuLSt6bExmDkhx1UP-RZfUfjHHVVXV6y1PVqjvEUjViVM1AUvFvyINtB3LahqfYj_1CcjybiCzyCyQizorbB88");
                return headers;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
                NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);
    }

    private ArrayList<MyListDataUpcomingBooking> initData() {

        ArrayList<MyListDataUpcomingBooking> list = new ArrayList<>();
//        list.add(new MyListDataUpcomingBooking("Awaiting vendor pickup"));
//        list.add(new MyListDataUpcomingBooking("Awaiting customer pickup"));
//        list.add(new MyListDataUpcomingBooking("Awaiting vendor pickup"));
//        list.add(new MyListDataUpcomingBooking("Awaiting customer pickup"));
        return list;
    }

}
