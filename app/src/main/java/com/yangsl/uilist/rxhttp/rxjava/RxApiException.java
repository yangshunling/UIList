package com.yangsl.uilist.rxhttp.rxjava;


import android.util.Log;

/**
 * Created by Anonymous on 17/3/10.
 */
public class RxApiException extends RuntimeException {

    public RxApiException(int resultCode, String message) {
        this(getRxExceptionMessage(resultCode, message));
    }

    public RxApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 对服务器传递过来的特殊信息进行特殊处理
     *
     * @param code
     * @return
     */
    private static String getRxExceptionMessage(int code, String message) {
        if (code == 400) {
            //Token过期，需要重新登录
            Log.v("vage", code + "---");
//            EventBus.getDefault().post(new TokenLose());
        }
        return message;
    }
}

