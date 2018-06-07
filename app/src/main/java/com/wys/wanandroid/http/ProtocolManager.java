package com.wys.wanandroid.http;


import com.wys.wanandroid.entity.PBannerItemEntity;
import com.wys.wanandroid.entity.PHomeArticleListEntity;
import com.wys.wanandroid.entity.PKnowledgeEntity;
import com.wys.wanandroid.http.callback.HttpBaseResult;
import com.wys.wanandroid.http.utils.RetrofitUtils;

import java.util.ArrayList;

import rx.Observable;


/**
 * Created by yas on 2018/4/27.
 * 统一的网络请求管理类，负责参数格式的组织
 */

public class ProtocolManager {
    private final String TAG = "ProtocolManager";

    private volatile static ProtocolManager instance;
    public static APIService apiStores;
    private ProtocolManager() {
        apiStores = RetrofitUtils.newInstance().create(APIService.class);
    }

    public  static final ProtocolManager getInstance() {
        if (instance == null) {
            synchronized(ProtocolManager.class){
                if (instance==null)
                    instance = new ProtocolManager();
            }

        }
        return instance;
    }
    public static Observable<HttpBaseResult<PHomeArticleListEntity>> getHomeArticleList(int num){
        return apiStores.getHomeArticleList(num);
    }

    public static Observable<HttpBaseResult<ArrayList<PBannerItemEntity>>> getBanner(){
        return apiStores.getBanner();
    }
    public static Observable<HttpBaseResult<ArrayList<PKnowledgeEntity>>> getKnowledgeTree(){
        return apiStores.getKnowledgeTree();
    }
}
