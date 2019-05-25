package com.mazroid.wedding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mazroid.wedding.fragment.InviteFragment;
import com.mazroid.wedding.fragment.DateFragment;
import com.mazroid.wedding.fragment.MapFragment;
import com.mazroid.wedding.fragment.WelcomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView navigation;
    WelcomeFragment welcomeFragment;
    MapFragment mapFragment;
    InviteFragment inviteFragment;
    DateFragment dateFragment;
    MenuItem prevMenuItem;
    TextView bar_title;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    bar_title.setText("Hearty Welcome");
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    bar_title.setText("Invitation");
                    return true;
                case R.id.navigation_savedate:
                    viewPager.setCurrentItem(2);
                    bar_title.setText("Save the date");
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(3);
                    bar_title.setText("Take me there");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager = findViewById(R.id.viewpager);
        bar_title =findViewById(R.id.bar_title);
        setupViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);
                else
                    navigation.getMenu().getItem(0).setChecked(false);

                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);
                if(position==0)
                {bar_title.setText("Hearty Welcome");}
                else if (position ==1)
                { bar_title.setText("Invitation");}
                else if (position==2)
                {bar_title.setText("Save the date");}
                else if(position==3)
                {bar_title.setText("Take me there");}
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                // do transformation here
//                final float normalizedposition = Math.abs(Math.abs(position) - 1);
//                page.setScaleX(normalizedposition / 2 + 0.5f);
//                page.setScaleY(normalizedposition / 2 + 0.5f);

                page.setRotationY(position * -10);
            }
        });

    }
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        welcomeFragment = new WelcomeFragment();
        mapFragment = new MapFragment();
        dateFragment = new DateFragment();
        inviteFragment = new InviteFragment();
        adapter.addFragment(welcomeFragment);
        adapter.addFragment(inviteFragment);
        adapter.addFragment(dateFragment);
        adapter.addFragment(mapFragment);

        viewPager.setAdapter(adapter);
    }
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

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

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }
}
