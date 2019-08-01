package com.naruto.mekvahandelivery.login_signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.naruto.mekvahandelivery.R;

public class FragmentForgotPassword extends Fragment {

	private View mRootView;

	public FragmentForgotPassword() {}

	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		mRootView = inflater.inflate(R.layout.fragment_forgot_password, container, false);

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
			if (getFragmentManager() != null) {
				getFragmentManager().popBackStack();
			}
		});

	}

}
