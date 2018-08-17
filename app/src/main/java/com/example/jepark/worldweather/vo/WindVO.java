package com.example.jepark.worldweather.vo;

/**
 * Created by jepark on 2018. 8. 3..
 */

public class WindVO {
    private float speed; // 바람 스피드 Unit Default: meter/sec, Metric: meter/sec, Imperial: miles/hour.
    private int deg; // 바람 방향

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }
}
