package com.example.jepark.worldweather.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.example.jepark.worldweather.config.Config;
import com.example.jepark.worldweather.model.ForecastModel;
import com.example.jepark.worldweather.vo.CurrentWeatherVO;
import com.example.jepark.worldweather.vo.ForecastObservableVO;
import com.example.jepark.worldweather.vo.ForecastVO;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jepark on 2018. 8. 2..
 */

public class ForecastViewModel extends DisposableViewModel {

    private ForecastModel mModel;

//    public final ObservableField<String> textCityName = new ObservableField<>();
//    public final ObservableField<String> textDesc = new ObservableField<>();
//    public final ObservableField<String> textTemp = new ObservableField<>();
//    public final ObservableField<String> textTempMinMax = new ObservableField<>();

    public final ForecastObservableVO forecastObservable = new ForecastObservableVO();

    public ForecastViewModel(Context context) {
        mModel = new ForecastModel(context);
    }


    public Observable<ForecastVO> getCurrentWeather(String city) {
        return mModel.getCurrentWeather(city);
    }

    public void getCurrentWeatherByGeo(double lat, double lon) {
        addDisposable(mModel.getCurrentWeatherByGeo(lat, lon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableObserver<ForecastVO>() {

            @Override
            public void onNext(ForecastVO forecastVO) {
                setForecastData(forecastVO);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }));
    }

    private void setForecastData(ForecastVO forecastVO) {
        forecastObservable.setCityName(forecastVO.getCityName());
        forecastObservable.setDesc(forecastVO.getDesc());
        forecastObservable.setTemp(forecastVO.getTemp() + Config.TEMP_UNIT);
        forecastObservable.setTempMinMax(forecastVO.getTempMin() + Config.TEMP_UNIT
                + "/"
                + forecastVO.getTempMax() + Config.TEMP_UNIT);
    }

//    public void setForecastData(ForecastVO forecastVO) {
//        textCityName.set(forecastVO.getCityName());
//        textDesc.set(forecastVO.getDesc());
//        textTemp.set(forecastVO.getTemp() + Config.TEMP_UNIT);
//        textTempMinMax.set(forecastVO.getTempMin() + Config.TEMP_UNIT
//        + "/"
//        + forecastVO.getTempMax() + Config.TEMP_UNIT);
//    }
}
