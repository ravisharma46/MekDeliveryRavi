package com.naruto.mekvahandelivery.login_signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.broooapps.otpedittext2.OtpEditText;
import com.naruto.mekvahandelivery.NavActivity;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.common_files.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;

public class FragmentOTP extends Fragment {

	private View inflate;
	private OtpEditText otpEditText;
	private String otp_input="",mobileNo="";
	private static final String myUrl = "https://mekvahan.com/api/delivery/verifyOtp";

	public FragmentOTP() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		inflate = inflater.inflate(R.layout.fragment_otp, container, false);

		otpEditText=inflate.findViewById(R.id.et_otp);
		otpEditText.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				otp_input = String.valueOf(otpEditText.getText());
				Log.e("TAG",otp_input);
			}
		});

		Bundle bundle = getArguments();
		mobileNo = bundle.getString("phoneNumber");
		onClickLinstener();
		return inflate;
	}

	private void onClickLinstener() {
//		inflate.findViewById(R.id.back_btn).setOnClickListener(v ->
//				Objects.requireNonNull(getActivity()).onBackPressed());



		inflate.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				verifyOtp();
			}
		});
	}

	private void verifyOtp() {

		final ProgressDialog progressDialog = new ProgressDialog(getContext());
		progressDialog.setMessage("Loading....");
		progressDialog.show();

		//----if everything is fine-----
		StringRequest stringRequest = new StringRequest(Request.Method.POST, myUrl,
				response -> {
					progressDialog.dismiss();

					try {

						JSONObject jsonObject = new JSONObject(response);

						int status = jsonObject.getInt("status");
						String resp=jsonObject.getString("response");
						if(status!=1) {
							Toast.makeText(getActivity(),resp,Toast.LENGTH_SHORT).show();
							return;
						}
						if(status==1) {
							Toast.makeText(getActivity(),resp,Toast.LENGTH_SHORT).show();
						}

						replaceFragment(new FragmentForgotPassword(),otp_input,mobileNo);






					} catch (JSONException e) {
						e.printStackTrace();
					}
				},
				error -> {
					Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
					Log.e("TAGR", error.toString());

				}) {
			@Override
			protected Map<String, String> getParams() {
				Map<String, String> params = new HashMap<>();

				// params.put("delivery_boy_id","1");
				params.put("mobile", mobileNo);
				params.put("otp", otp_input);



				return params;
			}

			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {

				return super.getHeaders();
			}
		};

		stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
				NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

		MySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);

	}







	private void replaceFragment(Fragment fragment,String otp_input,String mobileNo){
		Bundle bundle = new Bundle();
		bundle.putString("phoneNumber",mobileNo);
		bundle.putString("otp",otp_input);
		fragment.setArguments(bundle);

		FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.replace(R.id.fragment_container, fragment);
		//ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.commit();

	}



}
