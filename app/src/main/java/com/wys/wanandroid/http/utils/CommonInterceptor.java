package com.wys.wanandroid.http.utils;

import com.wys.wanandroid.BuildConfig;
import com.wys.wanandroid.utils.MyLog;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yas on 2017/11/30.
 * 封装公共参数
 */

public class CommonInterceptor implements Interceptor {

    @Override public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        if (BuildConfig.DEBUG) {
            MyLog.debug("---> " + oldRequest.method() + ' ' + oldRequest.url());
        }
        // 新的请求
        Request.Builder newBuilder = oldRequest.newBuilder();
        // 新的请求
        newBuilder.addHeader("Cookie", getCookie())
                .build();

        Response response = chain.proceed(newBuilder.build());
        return response;
    }
    /***
     * cookie
     * @return
     */
    private final String getCookie(){
        return "";
    }

}
