package com.wys.wanandroid.utils;

import android.util.Log;

import com.wys.wanandroid.common.MConfiger;


/***
 * 日志类
 */
public class MyLog {

    private static final String DEFAULT_TAG = "wanAndroid";

    public static final void info(String msg) {
        info(DEFAULT_TAG, msg);
    }

    public static final void info(String TAG, String msg) {
        if (!MConfiger.isDebug) {
            return;
        }
        Log.i(TAG, msg);
    }

    public static final void warning(String msg) {
        warning(DEFAULT_TAG, msg);
    }

    public static final void warning(String TAG, String msg) {
        if (!MConfiger.isDebug) {
            return;
        }
        Log.w(TAG, msg);
    }

    public static final void debug(String msg) {
        debug(DEFAULT_TAG, msg);
    }

    public static final void debug(String TAG, String msg) {
        if (!MConfiger.isDebug) {
            return;
        }
        Log.d(TAG, msg);
    }

    public static final void error(String msg) {
        error(DEFAULT_TAG, msg);
    }

    public static final void error(String TAG, String msg, Throwable throwable) {
        if (!MConfiger.isDebug) {
            return;
        }
        Log.e(TAG, msg, throwable);
    }

    public static final void error(String TAG, String msg) {
        if (!MConfiger.isDebug) {
            return;
        }
        Log.e(TAG, msg);
    }

    public static final void error(String TAG, Throwable throwable) {
        if (!MConfiger.isDebug) {
            return;
        }
        Log.e(TAG, "", throwable);
    }
}
