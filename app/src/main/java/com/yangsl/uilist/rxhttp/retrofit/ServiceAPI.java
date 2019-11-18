package com.yangsl.uilist.rxhttp.retrofit;


import com.yangsl.uilist.entity.LoginEntity;
import com.yangsl.uilist.rxhttp.rxjava.RxMoudle;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * RxHttp API接口
 */

public interface ServiceAPI {

    /**
     * 用户登录
     */
    @GET("getJoke")
    Observable<RxMoudle<List<LoginEntity>>> userLogin(@QueryMap Map<String, String> params);
}
