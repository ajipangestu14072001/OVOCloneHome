package com.example.ovo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.ovo.view.MainActivity;
import com.example.ovo.view.fragment.FavoritFragment;
import com.example.ovo.view.fragment.FinansialFragment;
import com.example.ovo.view.fragment.GrabFragment;
import com.example.ovo.view.fragment.PilihanLainFragment;

public class FragmentAdapter extends FragmentStateAdapter {
    private final int numTabs;

    public FragmentAdapter(@NonNull MainActivity fragment, int numTabs) {
        super(fragment);
        this.numTabs = numTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FavoritFragment();
            case 1:
                return new PilihanLainFragment();
            case 2:
                return new GrabFragment();
            case 3:
                return new FinansialFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return numTabs;
    }
}








