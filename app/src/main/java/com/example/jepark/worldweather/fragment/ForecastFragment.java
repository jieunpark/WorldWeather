package com.example.jepark.worldweather.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jepark.worldweather.R;
import com.example.jepark.worldweather.config.Config;
import com.example.jepark.worldweather.databinding.FragmentForecastBinding;

/**
 * Created by jepark on 2018. 8. 1..
 */

public class ForecastFragment extends Fragment {

    private static final String TAG = "ForecastFragment";

    private FragmentForecastBinding mBind;
    private String mCity;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.w(TAG, "@@@ onCreateView");
        mBind = DataBindingUtil.inflate(inflater, R.layout.fragment_forecast, container, false);
        View view = mBind.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            mCity = bundle.getString(Config.BundleData.DATA_CITY_NAME);
        }
        Log.e(TAG, "@@@ onActivityCreated : " + mCity);
    }
}
