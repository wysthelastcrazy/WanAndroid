package com.wys.wanandroid.activity.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wys.wanandroid.contract.base.BasePresenter;
import com.wys.wanandroid.contract.base.IBasePresenter;


/**
 * Created by yas on 2018/5/2.
 * 需要网络请求的fragment
 */

public abstract class BaseNetFragment<P extends IBasePresenter> extends BaseFragment{
    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=initPresenter();
        if (mPresenter!=null) {
            mPresenter.attach(this);
        }
    }
    protected abstract P initPresenter();
    @Override
    public void onDestroy() {
        super.onDestroy();
        hideLoading();
        if (mPresenter!=null)
            mPresenter.deAttach();
    }
}
