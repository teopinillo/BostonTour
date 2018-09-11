package com.me.theofrancisco.BostonTour;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by admin on 26-06-2016.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "City", "Boston Common", "Boston Tea Party", "Harvard","MIT"};

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position){
            case 0: return new CityFragment();
            case 1: return new BostonCommonFragment();
            case 2: return new BostonTeaPartyFragment();
            case 3: return new HarvardFragment();
            case 4: return new MitFragment();
            default: return new CityFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
