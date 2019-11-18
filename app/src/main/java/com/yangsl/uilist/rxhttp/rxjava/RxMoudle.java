package com.yangsl.uilist.rxhttp.rxjava;

/**
 * Created by Anonymous on 18/12/10.
 */
public class RxMoudle<T> {

    /**
     * code : 400
     * message : 404 Not Found
     * result : https://api.apiopen.top/
     */

    private int code;
    private String message;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
