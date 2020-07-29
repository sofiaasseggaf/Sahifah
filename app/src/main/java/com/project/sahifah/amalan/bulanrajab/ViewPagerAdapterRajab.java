package com.project.sahifah.amalan.bulanrajab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapterRajab extends FragmentPagerAdapter {

    private final List<Fragment> listFragment = new ArrayList<>();
    private final List<String> listTitles = new ArrayList<>();

    public ViewPagerAdapterRajab(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }

    @Override
    public int getCount() {
        return listTitles.size();
    }

    public void addFragment (Fragment fragment, String title){
        listFragment.add(fragment);
        listTitles.add(title);
    }
}
