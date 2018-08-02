package com.example.jepark.worldweather.retrofit;

import com.example.jepark.worldweather.vo.CurrentWeatherVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jepark on 2018. 8. 2..
 */

public interface ApiService {

    @GET("weather")
    Call<CurrentWeatherVO> requestCurrentWeather(@Query("APPID") String appId,
                                                 @Query("q") String cityName);

}
