package com.naruto.mekvahandelivery.login_signup;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.naruto.mekvahandelivery.Help_And_Support.Faq_activity;
import com.naruto.mekvahandelivery.NavActivity;
import com.naruto.mekvahandelivery.R;

import java.util.Objects;

import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.sendEmailIntent;

public class LoginFragment extends Fragment {

	private View mRootView;

	public LoginFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		mRootView= inflater.inflate(R.layout.fragment_login, container, false);

		TextView faq = mRootView.findViewById(R.id.btv_faqs);

		faq.setOnClickListener(view -> {

			Intent faqIntent = new Intent(getActivity(), Faq_activity.class);
			startActivity(faqIntent);
		});


		clickListener();
		return mRootView;
	}

	private void clickListener() {

		mRootView.findViewById(R.id.tv_forgot_password).setOnClickListener(v -> {

			Fragment fragment = new FragmentOTP();
			FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
			FragmentTransaction ft = fragmentManager.beginTransaction();
			ft.replace(R.id.fragment_container, fragment);
			ft.addToBackStack(null);
			ft.commit();
		});

		mRootView.findViewById(R.id.btn_login).setOnClickListener(view -> {
			Intent intent = new Intent(getActivity(), NavActivity.class);
			startActivity(intent);
		});

		mRootView.findViewById(R.id.btv_feedback).setOnClickListener(view ->
				sendEmailIntent(Objects.requireNonNull(getActivity())));

	}

}
