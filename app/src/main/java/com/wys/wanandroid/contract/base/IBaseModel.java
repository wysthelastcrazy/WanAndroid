package com.wys.wanandroid.contract.base;


import com.wys.wanandroid.http.callback.ApiCallBack;

import rx.Observable;

/**
 * Created by yas on 2018/5/23.
 */

public interface IBaseModel {
    void addSubscription(Observable observable, ApiCallBack callBack);
    void onUnsubscribe();
}
