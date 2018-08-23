package com.example.jepark.worldweather.viewmodel;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import com.example.jepark.worldweather.model.MainModel;
import com.example.jepark.worldweather.vo.LocationVO;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by jepark on 2018. 8. 1..
 */

public class MainViewModel extends DisposableViewModel  {

    private static final String TAG = "MainViewModel";

    private MainModel mMainModel;

    public final ObservableArrayList<String> mCityListObservable = new ObservableArrayList<>();

//    public final ObservableField<Double> mLat = new ObservableField<>();
//    public final ObservableField<Double> mLon = new ObservableField<>();

    private BehaviorSubject<LocationVO> mLocationVOSubject = BehaviorSubject.create();

    public MainViewModel(Context context) {
        mMainModel = new MainModel(context);
        initViewModel();

    }

    @Override
    public void clearDisposable() {
        super.clearDisposable();
        if (mLocationVOSubject != null) {
            mLocationVOSubject = null;
        }
    }

    /**
     * 초기화 작업
     */
    private void initViewModel() {
        mCityListObservable.addAll(mMainModel.getCityList());
    }


    /**
     * 위치정보 세팅
     */
    public void setLocation(LocationVO location) {
        mLocationVOSubject.onNext(location);
    }

    /**
     * 위치 데이터 발행
     * @return
     */
    public Observable<LocationVO> getCurrentLocation() {
        return mLocationVOSubject;
    }

}
