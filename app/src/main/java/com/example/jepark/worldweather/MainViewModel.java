package com.example.jepark.worldweather;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;

/**
 * Created by jepark on 2018. 8. 1..
 */

public class MainViewModel extends BaseObservable {

    private static final String TAG = "MainViewModel";


    private MainModel mMainModel;


    public final ObservableArrayList<String> mCityListObservable = new ObservableArrayList<>();

    public MainViewModel(Context context) {
        mMainModel = new MainModel(context);
        initViewModel();

    }

    private void init() {

    }

    /**
     * 초기화 작업
     */
    private void initViewModel() {

        mCityListObservable.addAll(mMainModel.getCityList());

    }

}
