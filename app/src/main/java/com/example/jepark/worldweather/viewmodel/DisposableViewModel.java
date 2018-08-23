package com.example.jepark.worldweather.viewmodel;

import android.databinding.BaseObservable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DisposableViewModel  extends BaseObservable {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    public void clearDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }
}
