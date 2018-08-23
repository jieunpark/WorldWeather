package com.example.jepark.worldweather.model;

import android.content.Context;
import android.util.Log;

import com.example.jepark.worldweather.config.Config;
import com.example.jepark.worldweather.retrofit.WeatherApiManager;
import com.example.jepark.worldweather.util.Utility;
import com.example.jepark.worldweather.vo.CurrentWeatherVO;
import com.example.jepark.worldweather.vo.ForecastVO;
import com.example.jepark.worldweather.vo.MainVO;
import com.example.jepark.worldweather.vo.WeatherVO;

import io.reactivex.Observable;

/**
 * Created by jepark on 2018. 8. 2..
 */

public class ForecastModel {

    private static final String TAG = "ForecastModel";

    private Context mContext;
    private WeatherApiManager mWeatherManager;
    private String mCity;

    public ForecastModel(Context context) {
        mContext = context;
        init();
    }

    private void init() {
        mWeatherManager = new WeatherApiManager(Config.BASE_URL);
    }

    public Observable<ForecastVO> getCurrentWeather(String city) {
        return mWeatherManager.requestCurrentWeather2(city)
                .flatMap(cWeatherVO -> convertTempData(cWeatherVO));


    }

    public Observable<ForecastVO> getCurrentWeatherByGeo(double lat, double lon) {
        return mWeatherManager.requestCurrentWeatherByGeo(lat, lon)
                .flatMap(cWeatherVO -> convertTempData(cWeatherVO));
    }

    private Observable<ForecastVO> convertTempData(CurrentWeatherVO currentWeatherVO) {

        MainVO mainVO = currentWeatherVO.getMain();

        ForecastVO forecastVO = new ForecastVO();
        forecastVO.setCityName(currentWeatherVO.getName());
        forecastVO.setDesc(currentWeatherVO.getWeather().get(0).getDescription());
        forecastVO.setTemp(Utility.getFormatTemp(mainVO.getTemp() - Config.TEMP_DIFF));
        forecastVO.setTempMin(Utility.getFormatTemp(mainVO.getTemp_min() - Config.TEMP_DIFF));
        forecastVO.setTempMax(Utility.getFormatTemp(mainVO.getTemp_max() - Config.TEMP_DIFF));

        return Observable.just(forecastVO);
    }
}
//    public void requestCurrentWeather() {
//        mWeatherManager.requestCurrentWeather(mCity).enqueue(new Callback<CurrentWeatherVO>() {
//            @Override
//            public void onResponse(Call<CurrentWeatherVO> call, Response<CurrentWeatherVO> response) {
//                Log.d(TAG,"@@@ onResponse " + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<CurrentWeatherVO> call, Throwable t) {
//                Log.e(TAG,"@@@ onFailure " + t.getMessage());
//            }
//        });
//    }