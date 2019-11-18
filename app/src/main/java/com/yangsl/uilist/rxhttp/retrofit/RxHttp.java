package com.yangsl.uilist.rxhttp.retrofit;

import com.yangsl.uilist.rxhttp.https.SSLSocketClient;
import com.yangsl.uilist.rxhttp.okhttp.LogInterceptor;
import com.yangsl.uilist.rxhttp.okhttp.TokenInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.yangsl.uilist.Constants.HOST;

/*
 * APIService接口放置
 */

public class RxHttp {

    private volatile static RxHttp rxHttp;
    private static Retrofit retrofit;
    private volatile static ServiceAPI serviceAPI;

    /**
     * 私有构造
     */
    private RxHttp() {
    }

    private static class Singleton {
        private static final RxHttp instance = new RxHttp();
    }

    /**
     * 获取单例
     */
    public static RxHttp getInstance() {
        return Singleton.instance;
    }

    /**
     * 创建Retrofit
     */
    public void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .client(getOkhttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 创建Okhttp
     */
    public OkHttpClient getOkhttpClient() {
        return new OkHttpClient().newBuilder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(new TokenInterceptor())
                .addInterceptor(new LogInterceptor())
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory(), SSLSocketClient.getTrustManager())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();
    }

    /**
     * 创建ServiceAPI
     */
    public static ServiceAPI Retrifot() {
        if (serviceAPI == null) {
            synchronized (ServiceAPI.class) {
                serviceAPI = retrofit.create(ServiceAPI.class);
            }
        }
        return serviceAPI;
    }
}
