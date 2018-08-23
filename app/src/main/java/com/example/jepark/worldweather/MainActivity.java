package com.example.jepark.worldweather;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jepark.worldweather.databinding.ActivityMainBinding;
import com.example.jepark.worldweather.viewmodel.MainViewModel;
import com.example.jepark.worldweather.vo.LocationVO;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int PERMISSION_LOCATION = 2;

    private ActivityMainBinding mBind = null;
    private MainViewModel mMainViewModel;
    private LocationManager mLocationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBind = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();
        initLayout();
        bindViewModel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestLocationUpdateStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        requestLocationUpdateStop();
    }

    /**
     * 데이터 초기화
     */
    private void init() {
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    /**
     * 레이아웃 초기화
     */
    private void initLayout() {
        initViewPager();
    }

    /**
     * 뷰페이저 초기화 
     */
    private void initViewPager() {
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), getApplicationContext());
        mBind.viewPager.setAdapter(adapter);
    }

    /**
     * ViewModel 바인딩
     */
    private void bindViewModel() {
        mMainViewModel = new MainViewModel(getApplicationContext());
        mBind.setViewModel(mMainViewModel);
    }

    public MainViewModel getMainViewModel() {
        return mMainViewModel;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_LOCATION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestLocationUpdateStart();
                }
                break;
        }
    }

    /**
     * 위치정보 탐색 시작
     */
    private void requestLocationUpdateStart() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // 권한없음
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_LOCATION);
            return;
        } else {
            // 권한있음
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 10, mLocationListener);
            mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 100, 10, mLocationListener);
        }
    }

    /**
     * 위치정보 탐색 종료
     */
    private void requestLocationUpdateStop() {
        mLocationManager.removeUpdates(mLocationListener);
    }

    /**
     * GPS 이벤트 리스너
     */
    private LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

            double longitude = location.getLongitude(); // 경도
            double latitude = location.getLatitude(); // 위도

            mMainViewModel.setLocation(new LocationVO(latitude, longitude));

            Log.d(TAG, "@@@ onLocationChanged :  lon, lat : " + longitude + ", " + latitude );
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.w(TAG, "@@@ onStatusChanged ");
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.i(TAG, "@@@ onProviderEnabled " + provider);
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.i(TAG, "@@@ onProviderDisabled " + provider);
        }
    };
}
