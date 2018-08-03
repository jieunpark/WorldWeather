package com.example.jepark.worldweather.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.example.jepark.worldweather.model.ForecastModel;
import com.example.jepark.worldweather.vo.CurrentWeatherVO;

import io.reactivex.Observable;

/**
 * Created by jepark on 2018. 8. 2..
 */

public class ForecastViewModel extends BaseObservable {

    private ForecastModel mModel;

    public final ObservableField<String> textCityName = new ObservableField<>();
    public final ObservableField<String> textDesc = new ObservableField<>();
    public final ObservableField<String> textTemp = new ObservableField<>();
    public final ObservableField<String> textTempMinMax = new ObservableField<>();

    public ForecastViewModel(Context context) {
        mModel = new ForecastModel(context);
    }


    public Observable<CurrentWeatherVO> getCurrentWeather(String city) {
        return mModel.getCurrentWeather(city);
    }
}
