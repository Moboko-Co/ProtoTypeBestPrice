package com.example.prototypebestprice.ui;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.prototypebestprice.R;
import com.google.android.material.tabs.TabLayout;

public class itemSearchFragment extends Fragment {
    public itemSearchFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Fragment[] arrFragments = new Fragment[5];
        arrFragments[0] = new AmazonFragment();
        arrFragments[1] = new RakutenFragment();
        arrFragments[2] = new MerukariFragment();
        arrFragments[3] = new RakumaFragment();
        arrFragments[4] = new PaypayFragment();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_itemsearch, container, false);

        TabLayout tabLayout = view.findViewById(R.id.searchViewTabs);
        ViewPager viewPager = view.findViewById(R.id.searchViewPager);

        SearchPagerAdapter adapter = new SearchPagerAdapter(getActivity().getSupportFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
        tabLayout.setSelectedTabIndicatorColor(getActivity().getResources().getColor(R.color.colorPrimary));
        tabLayout.setTabTextColors(getActivity().getResources().getColor(R.color.colorGray),getActivity().getResources().getColor(R.color.colorPrimary));
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private class SearchPagerAdapter extends FragmentStatePagerAdapter {
        private Fragment[] arrFragments;

        public SearchPagerAdapter(@NonNull FragmentManager fm, Fragment[] arrFragments) {
            super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            this.arrFragments = arrFragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch(position) {
                case 0:
                    return getString(R.string.tab_name_amazon);
                case 1:
                    return getString(R.string.tab_name_rakuten);
                case 2:
                    return getString(R.string.tab_name_merukari);
                case 3:
                    return getString(R.string.tab_name_rakuma);
                case 4:
                    return getString(R.string.tab_name_paypay);
                default:
                    return "";
            }
        }
    }
}
