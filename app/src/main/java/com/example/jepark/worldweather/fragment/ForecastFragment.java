package com.example.jepark.worldweather.fragment;

import android.content.Context;
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
import com.example.jepark.worldweather.viewmodel.ForecastViewModel;

/**
 * Created by jepark on 2018. 8. 1..
 */

public class ForecastFragment extends Fragment {

    private static final String TAG = "ForecastFragment";
    private Context mContext;

    private FragmentForecastBinding mBind;
    private String mCity;

    private ForecastViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBind = DataBindingUtil.inflate(inflater, R.layout.fragment_forecast, container, false);
        View view = mBind.getRoot();

        bindViewModel();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            mCity = bundle.getString(Config.BundleData.DATA_CITY_NAME);
            mViewModel.setCity(mCity);
        }

        mViewModel.requestApi();
    }

    /**
     * ViewModel 바인딩
     */
    private void bindViewModel() {
        mViewModel = new ForecastViewModel(mContext);
        mBind.setViewModel(mViewModel);

    }
}
