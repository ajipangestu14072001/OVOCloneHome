package com.example.ovo.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.ovo.view.fragment.FragmentSlider;

import java.util.List;


public class SliderPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> mFrags;

    public SliderPagerAdapter(FragmentManager fm, List<Fragment> frags) {
        super(fm);
        mFrags = frags;
    }

    @Override
    public Fragment getItem(int position) {
        int index = position % mFrags.size();
        return FragmentSlider.newInstance(mFrags.get(index).getArguments().getString("imgSlider"));
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}