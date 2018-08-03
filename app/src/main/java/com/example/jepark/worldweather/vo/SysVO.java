package com.example.jepark.worldweather.vo;

/**
 * Created by jepark on 2018. 8. 3..
 */

public class SysVO {
    private String country; // 나라 코드 (GB, JP etc)
    private Long sunrise; // 일출 시간
    private Long sunset; // 일몰 시간

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }
}
