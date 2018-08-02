package com.example.jepark.worldweather;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.jepark.worldweather.config.Config;
import com.example.jepark.worldweather.fragment.ForecastFragment;

import java.util.List;

/**
 * Created by jepark on 2018. 8. 1..
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<String> mCityDataList;

    public MainViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    public void setCityDataList(List<String> mCityDataList) {
        this.mCityDataList = mCityDataList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new ForecastFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Config.BundleData.DATA_CITY_NAME, mCityDataList.get(position));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        if (mCityDataList == null) {
            return 0;
        }
        return mCityDataList.size();
    }
}
