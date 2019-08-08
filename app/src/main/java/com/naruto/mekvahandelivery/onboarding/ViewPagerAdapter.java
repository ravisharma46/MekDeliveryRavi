package com.naruto.mekvahandelivery.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.naruto.mekvahandelivery.R;

public class ViewPagerAdapter extends PagerAdapter {

    private int[] images = {R.drawable.on_boarding_car, R.drawable.on_boarding_phone, R.drawable.on_boarding_map};
    private String[] titleArray = {"Service with Perfection\n", "Smartest way of Care your Vehicle", "Emanated in India"};
    private String[] descArray =
            {"Mekvahan is a network of technology-enabled car & bike service centres, offering a seamless service experience at the convenience of a tap.",
            "Our vast network of Car & Bike Service Centres uses only OEM/OES spare parts and high-quality consumables which ensures, what goes into your vehicle is nothing but the best.",
            "India’s best automobile service venture that aims at providing its outstanding assistance & services to all the two- & four-wheeler vehicle owners."};
    private Context context;

    ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return titleArray.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.on_boarding_slider, null);
        ImageView imageView = view.findViewById(R.id.im_slider);

        TextView title = view.findViewById(R.id.titles);
        TextView desc = view.findViewById(R.id.desc);

        imageView.setImageResource(images[position]);
        title.setText(titleArray[position]);

        desc.setText(descArray[position]);


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}
