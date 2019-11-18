package com.yangsl.uilist.rxhttp.rxjava;

import io.reactivex.functions.Function;

/**
 * Created by Anonymous on 2017/4/6.
 */

public class RxResultFunc<T> implements Function<RxMoudle<T>, T> {

    @Override
    public T apply(RxMoudle<T> httpResult) throws Exception {
        if (httpResult.getCode() == 200) {
            throw new RxApiException(httpResult.getCode(), httpResult.getMessage());
        }
        return httpResult.getResult();
    }
}

