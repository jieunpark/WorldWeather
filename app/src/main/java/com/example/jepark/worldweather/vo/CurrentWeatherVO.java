package com.example.jepark.worldweather.vo;

/**
 * Created by jepark on 2018. 8. 2..
 */

public class CurrentWeatherVO {

    private CoordVO coord;
    private WeatherVO weather;
    private MainVO main;
    private WindVO wind;
    private CloudVO clouds;
    private Long dt;
    private SysVO sys;
    private String name;

    public CoordVO getCoord() {
        return coord;
    }

    public void setCoord(CoordVO coord) {
        this.coord = coord;
    }

    public WeatherVO getWeather() {
        return weather;
    }

    public void setWeather(WeatherVO weather) {
        this.weather = weather;
    }

    public MainVO getMain() {
        return main;
    }

    public void setMain(MainVO main) {
        this.main = main;
    }

    public WindVO getWind() {
        return wind;
    }

    public void setWind(WindVO wind) {
        this.wind = wind;
    }

    public CloudVO getClouds() {
        return clouds;
    }

    public void setClouds(CloudVO clouds) {
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public SysVO getSys() {
        return sys;
    }

    public void setSys(SysVO sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
