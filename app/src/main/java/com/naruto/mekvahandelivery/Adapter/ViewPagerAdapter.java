package com.naruto.mekvahandelivery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.naruto.mekvahandelivery.R;

public class ViewPagerAdapter extends PagerAdapter {

    public int[] images = {R.drawable.on_boarding_car, R.drawable.on_boarding_phone, R.drawable.on_boarding_map};
    public String[] titleArray = {"Service with perfaction", "Smartest way of Care \n your vehicle", "Emanated in India"};
    private Context context;
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return titleArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.on_boarding_slider, null);
        ImageView imageView = view.findViewById(R.id.im_slider);

        TextView title = view.findViewById(R.id.titles);
        TextView desc = view.findViewById(R.id.desc);

        imageView.setImageResource(images[position]);
        title.setText(titleArray[position]);

        desc.setText("Lorem Ipsum is simply dummy text\n of the printing and typesting industry. ");


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }

}
