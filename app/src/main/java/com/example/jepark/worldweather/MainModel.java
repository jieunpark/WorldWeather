package com.example.jepark.worldweather;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jepark on 2018. 8. 1..
 */

public class MainModel {

    private Context mContext;

    public MainModel(Context context) {
        mContext = context;
    }

    /**
     * 데이터 반환
     * @return
     */
    public List<String> getCityList() {
        List<String> list = new ArrayList<>();
        list.add("런던");
        list.add("서울");
        return list;
    }
}
