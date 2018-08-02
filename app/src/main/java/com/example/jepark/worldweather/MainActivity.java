package com.example.jepark.worldweather;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jepark.worldweather.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBind = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBind = DataBindingUtil.setContentView(this, R.layout.activity_main);

        init();
        initLayout();

    }

    /**
     * 데이터 초기화
     */
    private void init() {

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
}
