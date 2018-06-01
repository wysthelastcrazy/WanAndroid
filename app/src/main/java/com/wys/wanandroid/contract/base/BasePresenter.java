package com.wys.wanandroid.contract.base;


import com.wys.wanandroid.http.APIService;
import com.wys.wanandroid.http.ProtocolManager;

/**
 * ============================================================
 * 作 者 : yas
 * 版 本 ： 1.0
 * 创建日期 ： 2017/11/30 22:20
 * 描 述 ：Presenter通用配置类，所有Presenter继承该类,MVP的P层，负责数据交互
 * ============================================================
 **/
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {
    public V mView;
    public APIService apiStores= ProtocolManager.getInstance().apiStores;

    /**
     * 初始化所需model
     */
    public abstract void initModel();
    @Override
    public void attach(V v) {
        this.mView = v;
        initModel();
    }

    @Override
    public void deAttach() {
        this.mView = null;
        unBindModel();
    }

    /**
     * 解绑model
     */
    public abstract void unBindModel();
}
