package com.yangsl.uilist.rxhttp.rxjava;

import android.content.Context;
import android.util.Log;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.yangsl.uilist.view.RxProgress;

import io.reactivex.observers.DefaultObserver;


/**
 * RxSubscriber的封装
 */
public abstract class RxSubscriber<T> extends DefaultObserver<T> {

    private KProgressHUD mProgress;
    private boolean isShow = true;

    /**
     * 不带有进度条
     */
    public RxSubscriber() {
        isShow = false;
    }

    /**
     * 带有进度条
     */
    public RxSubscriber(Context context) {
        mProgress = RxProgress.getInstance().create(context);
    }

    /**
     * 带有进度条，自定义title内容
     */
    public RxSubscriber(Context mContext, String msg) {
        mProgress = RxProgress.getInstance().create(mContext, msg);
    }

    @Override
    protected void onStart() {
        if (isShow) {
            mProgress.show();
        }
    }

    @Override
    public void onError(Throwable t) {
        mProgress.dismiss();
        Log.v("TAG", "出现了错误:" + t.getMessage());
    }

    @Override
    public void onComplete() {
        mProgress.dismiss();
    }

    @Override
    public abstract void onNext(T t);

}
