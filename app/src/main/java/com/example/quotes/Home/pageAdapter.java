package com.example.quotes.Home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.quotes.Home.slidetabs.ImageStatus;
import com.example.quotes.Home.slidetabs.QuotesGenre;

public class pageAdapter extends FragmentPagerAdapter {
    int tabcount;
    public pageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new QuotesGenre();
            case 1: return new ImageStatus();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
