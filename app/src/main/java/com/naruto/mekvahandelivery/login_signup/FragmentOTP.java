package com.naruto.mekvahandelivery.login_signup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.naruto.mekvahandelivery.R;

import java.util.Objects;

public class FragmentOTP extends Fragment {

	private View inflate;

	public FragmentOTP() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		inflate = inflater.inflate(R.layout.fragment_otp, container, false);

		onClickLinstener();
		return inflate;
	}

	private void onClickLinstener() {
//		inflate.findViewById(R.id.back_btn).setOnClickListener(v ->
//				Objects.requireNonNull(getActivity()).onBackPressed());

		inflate.findViewById(R.id.ok).setOnClickListener(view -> replaceFragment(new FragmentForgotPassword()));
	}

	private void replaceFragment(Fragment fragment){

		FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.replace(R.id.fragment_container, fragment);
		//ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		ft.commit();

	}



}
