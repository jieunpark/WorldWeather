package com.example.jepark.worldweather;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewParent;

import java.util.List;

/**
 * Created by jepark on 2018. 8. 2..
 */

public class DataBindingUtil {

    @BindingAdapter("bind:adapter")
    public static void setMainViewPager(ViewPager viewPager, List<String> list) {
        MainViewPagerAdapter adapter = (MainViewPagerAdapter) viewPager.getAdapter();
        adapter.setCityDataList(list);
        adapter.notifyDataSetChanged();

    }
}
