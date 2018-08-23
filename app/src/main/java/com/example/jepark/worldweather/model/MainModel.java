package com.example.jepark.worldweather.model;

import android.content.Context;

import com.example.jepark.worldweather.viewmodel.DisposableViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jepark on 2018. 8. 1..
 */

public class MainModel extends DisposableViewModel {

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
        list.add("Current");
//        list.add("서울");
        return list;
    }
}
