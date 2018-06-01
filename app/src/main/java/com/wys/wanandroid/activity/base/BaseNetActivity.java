package com.wys.wanandroid.activity.base;

import android.os.Bundle;

import com.wys.wanandroid.contract.base.IBasePresenter;


/**
 * Created by Administrator on 2016/7/22.
 */
public abstract class BaseNetActivity<P extends IBasePresenter> extends BaseActivity {

    protected P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=initPresenter();
        if (mPresenter!=null) {
            mPresenter.attach(this);
        }
    }
    protected abstract P initPresenter();
    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideLoading();
        if (mPresenter!=null)
            mPresenter.deAttach();
    }
}
