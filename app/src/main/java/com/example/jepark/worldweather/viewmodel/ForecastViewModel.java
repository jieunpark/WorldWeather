package com.example.jepark.worldweather.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.example.jepark.worldweather.model.ForecastModel;

/**
 * Created by jepark on 2018. 8. 2..
 */

public class ForecastViewModel extends BaseObservable {

    private ForecastModel mModel;


    public ForecastViewModel(Context context) {
        mModel = new ForecastModel(context);
    }

    public void requestApi() {
        mModel.requestCurrentWeather();
    }

    public void setCity(String cityName) {
        mModel.setCity(cityName);
    }
}
