package fr.soumiabrk.patientapp;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Button;

import  androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Appointment  extends FragmentActivity {


    private static final int NUM_PAGES = 5;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager);

        final  ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new CenterFragment());
        fragments.add(new DoseFragment());
        fragments.add(new Vaccineragment());
        fragments.add(new Dateragment());
        fragments.add(new ResumeFragment());
        pagerAdapter = new ScreenSlidePagerAdapter(this, fragments);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    public void next(){
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
    }

    public void back(){
        viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }



    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        private final ArrayList<Fragment> fragments;

        public ScreenSlidePagerAdapter(FragmentActivity fa, ArrayList<Fragment> fragments) {
            super(fa);
            this.fragments = fragments;
        }

        @Override
        public Fragment createFragment(int position) {

            return fragments.get(position);
        }


        @Override
        public int getItemCount() {
            return fragments.size();
        }
    }





}

