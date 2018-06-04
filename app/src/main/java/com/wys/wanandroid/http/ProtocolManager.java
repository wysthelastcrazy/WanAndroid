package com.wys.wanandroid.http;


import com.wys.wanandroid.http.utils.RetrofitUtils;


/**
 * Created by yas on 2018/4/27.
 * 统一的网络请求管理类，负责参数格式的组织
 */

public class ProtocolManager {
    private final String TAG = "ProtocolManager";

    private volatile static ProtocolManager instance;
    public APIService apiStores;
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
}
