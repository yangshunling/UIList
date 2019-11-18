package com.yangsl.uilist.view;

import android.app.ProgressDialog;
import android.content.Context;

import com.kaopiz.kprogresshud.KProgressHUD;

/**
 * @Description: RxProgress
 * @Author: Anonymous
 * @Time: 2019/11/16 20:04
 */
public class RxProgress {

    private RxProgress(){}

    private static class SingleTon{
        private static final RxProgress instance = new RxProgress();
    }

    public static RxProgress getInstance(){
        return SingleTon.instance;
    }

    public KProgressHUD create(Context mContext) {
        return create(mContext, "正在获取数据...");
    }

    public KProgressHUD create(Context mContext, String msg) {
        return KProgressHUD.create(mContext)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(msg)
                .setCancellable(true)
                .setAnimationSpeed(1)
                .setDimAmount(0.3f);
    }
}
