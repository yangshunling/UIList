package com.yangsl.uilist.rxhttp.okhttp;

import android.util.Log;

import com.yangsl.uilist.utils.SpUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http2.Header;

/**
 * OkHttp Token拦截器
 */

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        String token = SpUtil.getString("token");
        Log.v("token", token);
        if (token.equals("")) {
            return chain.proceed(original);
        }
        Request request = original.newBuilder()
                .header("Authorization", "Bearer " + token)
                .build();
        return chain.proceed(request);
    }
}
