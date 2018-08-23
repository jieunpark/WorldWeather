package com.example.jepark.worldweather.retrofit;

import com.example.jepark.worldweather.config.Config;
import com.example.jepark.worldweather.vo.CurrentWeatherVO;

import io.reactivex.Observable;
import retrofit2.Call;

/**
 * Created by jepark on 2018. 8. 2..
 */

public class WeatherApiManager extends RetrofitManager {

    public WeatherApiManager(String baseUrl) {
        super(baseUrl);
    }

    /**
     * 현재 날씨
     * @param cityName
     * @return
     */
    public Call<CurrentWeatherVO> requestCurrentWeather(String cityName) {
        return createApi(ApiService.class).requestCurrentWeather(Config.APP_KEY, cityName);
    }

    /**
     * 현재 날씨
     * @param cityName
     * @return
     */
    public Observable<CurrentWeatherVO> requestCurrentWeather2(String cityName) {
        return createApi(ApiService.class).requestCurrentWeather2(Config.APP_KEY, cityName);
    }

    /**
     * 현재 날씨 (위도,경도)
     * @param lat
     * @param lon
     * @return
     */
    public Observable<CurrentWeatherVO> requestCurrentWeatherByGeo(double lat, double lon) {
        return createApi(ApiService.class).requestCurrentWeatherByGeo(Config.APP_KEY, lat, lon);
    }
}
