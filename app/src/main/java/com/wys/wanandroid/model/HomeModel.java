package com.wys.wanandroid.model;

import com.wys.wanandroid.contract.HomeContract;
import com.wys.wanandroid.contract.base.BaseModel;
import com.wys.wanandroid.http.callback.ApiCallBack;
import com.wys.wanandroid.utils.MyLog;

/**
 * Created by yas on 2018/6/4.
 */

public class HomeModel extends BaseModel implements HomeContract.IHomeModel{
    @Override
    public void getArticleList(int pageNum, ApiCallBack callBack) {
        MyLog.debug("[getArticleList]  pageNum:"+pageNum);
        addSubscription(apiStores.getHomeArticleList(pageNum),callBack);
    }

    @Override
    public void getBanner(ApiCallBack callBack) {
        addSubscription(apiStores.getBanner(),callBack);
    }
}
