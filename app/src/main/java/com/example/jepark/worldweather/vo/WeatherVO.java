package com.example.jepark.worldweather.vo;

/**
 * 날씨 데이터
 * Created by jepark on 2018. 8. 3..
 */
public class WeatherVO {
    private int id; //  Weather condition id
    private String main; // Group of weather parameters (Rain, Snow, Extreme etc.)
    private String description; // Weather condition within the group
    private String icon; //  Weather icon id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
