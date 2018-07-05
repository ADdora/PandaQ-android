package com.mohamedmorsi.pandaq.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed Morsi on 7/5/2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> myfragments = new ArrayList<>();




    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment){
        myfragments.add(fragment);


    }
    @Override
    public Fragment getItem(int position) {
        return myfragments.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
