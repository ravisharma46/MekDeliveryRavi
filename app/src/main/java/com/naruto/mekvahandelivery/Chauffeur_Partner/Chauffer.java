package com.naruto.mekvahandelivery.Chauffeur_Partner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.naruto.mekvahandelivery.Chauffeur_Partner.NewBooking.NewBookingFragmentChauffer;
import com.naruto.mekvahandelivery.Chauffeur_Partner.OngoingBooking.OngoingBookingFragmentChauffer;
import com.naruto.mekvahandelivery.Chauffeur_Partner.UpcomingBooking.UpcomingBookingFragmentChauffer;
import com.naruto.mekvahandelivery.NavActivity;
import com.naruto.mekvahandelivery.OngoingOrders.OngoingFragment;
import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.UpcomingOrders.UpcomingFragment;
import com.naruto.mekvahandelivery.history.BookingHistoryFragment;

import java.util.ArrayList;
import java.util.List;

public class Chauffer extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chauffer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Chauffeur services</font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        setTabLayout();
    }


    private void setTabLayout(){

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        NavActivity.ViewPagerAdapter adapter = new NavActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewBookingFragmentChauffer(), "New");
        adapter.addFragment(new UpcomingBookingFragmentChauffer(), "Upcoming");
        adapter.addFragment(new OngoingBookingFragmentChauffer(), "Ongoing");
        adapter.addFragment(new BookingHistoryFragment(), "History");
        viewPager.setAdapter(adapter);
    }

    private static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
