package com.example.jepark.worldweather.retrofit;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jepark on 2018. 8. 2..
 */

public class RetrofitManager {

    public static final int CONNECT_TIMEOUT = 5000;
    public static final int WRITE_TIMEOUT = 5000;
    public static final int READ_TIMEOUT = 5000;

    private Retrofit.Builder mBuilder;

    public RetrofitManager(String baseUrl) {
        init(baseUrl);
    }

    private void init(String baseURl) {
        mBuilder = new Retrofit.Builder()
                .baseUrl(baseURl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()); // retrofit + rxjava2
    }

    /**
     * Client 생성
     * @return
     */
    private OkHttpClient.Builder createClientBuilder() {
        // 통신 로그를 확인하기 위한 코드
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS) // 연결 타임아웃
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS) // 읽기 타임아웃
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS) // 쓰기 타임아웃
                .addNetworkInterceptor(new StethoInterceptor()) // 모니터링
                .addInterceptor(interceptor); // 로그

    }

    /**
     * Retrofit Builder 생성
     * @param apiInterface
     * @param <T>
     * @return
     */
    public <T> T createApi(Class<T> apiInterface) {
        mBuilder.client(createClientBuilder().build());
        return (T) mBuilder.build().create(apiInterface);
    }
}
