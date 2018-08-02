package com.example.jepark.worldweather.model;

import android.content.Context;
import android.util.Log;

import com.example.jepark.worldweather.config.Config;
import com.example.jepark.worldweather.retrofit.WeatherApiManager;
import com.example.jepark.worldweather.vo.CurrentWeatherVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    public void requestCurrentWeather() {
        mWeatherManager.requestCurrentWeather(mCity).enqueue(new Callback<CurrentWeatherVO>() {
            @Override
            public void onResponse(Call<CurrentWeatherVO> call, Response<CurrentWeatherVO> response) {
                Log.d(TAG,"@@@ onResponse " + response.body());
            }

            @Override
            public void onFailure(Call<CurrentWeatherVO> call, Throwable t) {
                Log.e(TAG,"@@@ onFailure " + t.getMessage());
            }
        });
    }

    public void setCity(String cityName) {
        mCity = cityName;
    }
}
