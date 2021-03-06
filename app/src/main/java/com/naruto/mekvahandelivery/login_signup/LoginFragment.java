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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.naruto.mekvahandelivery.common_files.LoginSessionManager;
import com.naruto.mekvahandelivery.common_files.MySingleton;
import com.naruto.mekvahandelivery.help_and_support.Faq_activity;
import com.naruto.mekvahandelivery.NavActivity;
import com.naruto.mekvahandelivery.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.NO_OF_RETRY;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.RETRY_SECONDS;
import static com.naruto.mekvahandelivery.common_files.CommonVaribalesFunctions.sendEmailIntent;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.ACCESS_TOKEN;
import static com.naruto.mekvahandelivery.common_files.LoginSessionManager.TOKEN_TYPE;

public class LoginFragment extends Fragment {

	private View mRootView;
	private static final String myUrl = "https://mekvahan.com/api/delivery/login";
	private static final String myUrlForgot = "https://mekvahan.com/api/delivery/forgotPassword";
	private LoginSessionManager mSession;
	private String  tokenType,accessToken,profile_id,name,mobile,email,type,latitude,longitude,partner_id,active,pan_number,account_number,ifsc_code,
			         cancelled_check_number,cancelled_check;

	private EditText et_mobile,et_password;

	public LoginFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		mRootView= inflater.inflate(R.layout.fragment_login, container, false);

		TextView faq = mRootView.findViewById(R.id.btv_faqs);
		et_mobile = mRootView.findViewById(R.id.emp_id);
		et_password = mRootView.findViewById(R.id.emp_psw);

		faq.setOnClickListener(view -> {
			Intent faqIntent = new Intent(getActivity(), Faq_activity.class);
			startActivity(faqIntent);
		});
		mSession=new LoginSessionManager(getContext());

		clickListener();
		return mRootView;
	}

	private void clickListener() {

		mRootView.findViewById(R.id.tv_forgot_password).setOnClickListener(v -> {

			forgotPassword();


		});

		mRootView.findViewById(R.id.btn_login).setOnClickListener(view -> {
			userLogin();
			//Intent intent = new Intent(getActivity(), NavActivity.class);
			//startActivity(intent);
		});

		mRootView.findViewById(R.id.btv_feedback).setOnClickListener(view ->
				sendEmailIntent(Objects.requireNonNull(getActivity())));

	}

	private void userLogin() {


		final String mobileNo = et_mobile.getText().toString();
		final String password = et_password.getText().toString();

		//----- validating inputs-----
		if (mobileNo.isEmpty()) {
			et_mobile.setError("Please enter your valid mobile number");
			et_mobile.requestFocus();
			return;
		}
		if(mobileNo.length()<10) {
			et_mobile.setError("Please enter 10 digit mobile number");
			et_mobile.requestFocus();
			return;
		}

		if (password.isEmpty()) {
			et_password.setError("Please enter your password");
			et_password.requestFocus();
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
						if(status!=1) {
							Toast.makeText(getActivity(),"fail to login",Toast.LENGTH_SHORT).show();
							return;
						}

						JSONObject resp=jsonObject.getJSONObject("response");

						 tokenType   = resp.getString("token_type");
						accessToken = resp.getString("access_token");

						JSONObject user = resp.getJSONObject("user");

						Log.e("TAG", user.toString());

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
						pan_number=user.getString("pan_number");
						account_number=user.getString("account_number");
						ifsc_code=user.getString("IFSC_code");
						cancelled_check_number=user.getString("cancelled_check_number");
						cancelled_check=user.getString("cancelled_check");

						mSession.createLoginSession(tokenType,accessToken,String.valueOf(userId),profile_id,
								name,mobile,email,type,latitude,longitude,partner_id,active,pan_number,account_number,ifsc_code,cancelled_check_number,cancelled_check );

						Intent intent = new Intent(getContext(), NavActivity.class);
						intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
						getContext().startActivity(intent);
						//finish();

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
				params.put("password", password);
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

		MySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);

	}

	private void forgotPassword(){


		final String mobileNo = et_mobile.getText().toString();


		//----- validating inputs-----
		if (mobileNo.isEmpty()) {
			et_mobile.setError("Please enter valid mobile number");
			et_mobile.requestFocus();
			return;
		}

		if(mobileNo.length()<10) {
			et_mobile.setError("Please enter 10 digit mobile number");
			et_mobile.requestFocus();
			return;
		}

		final ProgressDialog progressDialog = new ProgressDialog(getContext());
		progressDialog.setMessage("Loading....");
		progressDialog.show();

		//----if everything is fine-----
		StringRequest stringRequest = new StringRequest(Request.Method.POST, myUrlForgot,
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


						replaceFragment(new FragmentOTP(),mobileNo);



					} catch (JSONException e) {

						e.printStackTrace();
					}
				},
				error -> {
					progressDialog.dismiss();
					Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
					Log.e("TAGR", error.toString());

				}) {
			@Override
			protected Map<String, String> getParams() {
				Map<String, String> params = new HashMap<>();

				// params.put("delivery_boy_id","1");
				params.put("mobile", mobileNo);

				return params;
			}

			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				Map<String,String> headers=new HashMap<>();
				headers.put("Accept","application/json");

				return headers;
			}
		};

		stringRequest.setRetryPolicy(new DefaultRetryPolicy((RETRY_SECONDS*1000),
				NO_OF_RETRY,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

		MySingleton.getInstance(getContext()).addToRequestQueue(stringRequest);

	}

	private void replaceFragment(Fragment fragment,String mobile){

		Bundle bundle = new Bundle();
		bundle.putString("phoneNumber",mobile);
		fragment.setArguments(bundle);


		FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.replace(R.id.fragment_container, fragment);
		ft.addToBackStack(null);
		ft.commit();

	}

}
