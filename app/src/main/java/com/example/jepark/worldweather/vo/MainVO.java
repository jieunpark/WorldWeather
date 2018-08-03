package com.example.jepark.worldweather.vo;

/**
 * Created by jepark on 2018. 8. 3..
 */

public class MainVO {
    private float temp; // 온도
    private float pressure; // 기압 hpa
    private float humidity; // 습도 %
    private float temp_min; // 최저온도
    private float temp_max; // 최고온도

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }
}
