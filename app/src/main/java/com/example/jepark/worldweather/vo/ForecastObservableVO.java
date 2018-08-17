package com.example.jepark.worldweather.vo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.jepark.worldweather.BR;


public class ForecastObservableVO extends BaseObservable {

    private String cityName;
    private String desc;
    private String temp;
    private String tempMinMax;

    @Bindable
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
        notifyPropertyChanged(BR.cityName);
    }

    @Bindable
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
        notifyPropertyChanged(BR.desc);
    }

    @Bindable
    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
        notifyPropertyChanged(BR.temp);
    }


    @Bindable
    public String getTempMinMax() {
        return tempMinMax;
    }

    public void setTempMinMax(String tempMinMax) {
        this.tempMinMax = tempMinMax;
        notifyPropertyChanged(BR.tempMinMax);
    }
}
