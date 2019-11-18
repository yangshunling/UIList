package com.yangsl.uilist.application;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.mmkv.MMKV;
import com.yangsl.uilist.rxhttp.retrofit.RxHttp;

/**
 * @Description: AppApplication
 * @Author: Anonymous
 * @Time: 2019/11/15 15:00
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        MMKV.initialize(this);
        RxHttp.getInstance().init();
    }
}
