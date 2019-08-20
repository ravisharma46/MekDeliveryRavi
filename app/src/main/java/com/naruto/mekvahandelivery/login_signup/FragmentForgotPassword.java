package com.naruto.mekvahandelivery.login_signup;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.common_files.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;

public class FragmentForgotPassword extends Fragment {

	private View mRootView;
	private static final String myUrl = "https://mekvahan.com/api/delivery/resetPassword";
	private EditText et_newpass,et_confirmpass;
	private String mobileNo="",otp="";

	public FragmentForgotPassword() {}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		mRootView = inflater.inflate(R.layout.fragment_forgot_password, container, false);

		et_newpass=mRootView.findViewById(R.id.new_password);
		et_confirmpass=mRootView.findViewById(R.id.confirm_password);

		Bundle bundle = getArguments();
		mobileNo = bundle.getString("phoneNumber");
		otp = bundle.getString("otp");


		clickListener();
		return mRootView;

	}


	private void clickListener() {
//		mRootView.findViewById(R.id.back_btn).setOnClickListener(view -> {
//			if (getFragmentManager() != null) {
//				getFragmentManager().popBackStack();
//			}
//		});

		mRootView.findViewById(R.id.proceed).setOnClickListener(view -> {
			resetPassword();
		});

	}


	private void resetPassword() {

		final String newpass = et_newpass.getText().toString();
		final String confirmpass = et_confirmpass.getText().toString();

		//----- validating inputs-----
		if (newpass.isEmpty()) {
			et_newpass.setError("New password can't empty");
			et_newpass.requestFocus();
			return;
		}
		if(confirmpass.isEmpty()  ) {
			et_confirmpass.setError("confirm password can't empty");
			et_confirmpass.requestFocus();
			return;
		}

		if (!newpass.contains(confirmpass)) {
			et_confirmpass.setError("Password not matched");
			et_confirmpass.requestFocus();
			return;
		}


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

						replaceFragment(new LoginFragment());





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
				params.put("otp", otp);
				params.put("newPassword", newpass);
				params.put("confirmPassword", confirmpass);
				params.put("mobile", mobileNo);



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


	private void replaceFragment(Fragment fragment){

		FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.replace(R.id.fragment_container, fragment);
		ft.addToBackStack(null);
		ft.commit();



	}





}
