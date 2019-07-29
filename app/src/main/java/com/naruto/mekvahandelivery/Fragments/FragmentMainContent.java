package com.naruto.mekvahandelivery.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.naruto.mekvahandelivery.R;

public class FragmentMainContent extends Fragment {

    private final String TAG = "FragMainContent";
    private View mRootView;

    public FragmentMainContent() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView =  inflater.inflate(R.layout.home_page_content, container, false);

        return mRootView;
    }

}