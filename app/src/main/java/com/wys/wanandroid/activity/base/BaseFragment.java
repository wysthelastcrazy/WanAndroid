package com.wys.wanandroid.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wys.wanandroid.contract.base.IBaseView;


/**
 * Created by yas on 2017/11/6.
 */

public abstract class BaseFragment extends Fragment implements IBaseView {
    protected final String TAG=getClass().getSimpleName();
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(getLayoutRes(),null);
        initViews(rootView);
        return rootView;
    }
    /**
     * 获取布局文件id
     * @return
     */
    public abstract int getLayoutRes();

    /***
     * 初始化控件
     * @param rootView
     */
    public abstract void initViews(View rootView);

    @Override
    public void showLoading(){
        showLoading("数据正在加载中。。。");
    }
    @Override
    public void showLoading(String msg){
        showLoading(msg,true,false);
    }

    private Runnable rTimeout = new Runnable() {
        @Override
        public void run() {
            hideLoading();
        }
    };
    protected void showLoading(String msg, boolean isCancle){
        showLoading(msg,isCancle,true);
    }
    /**
     * loading弹窗
     * @param msg
     * @param isCancle
     * @param hasTimeOut
     */
    protected void showLoading(String msg, boolean isCancle, boolean hasTimeOut){

    }

    @Override
    public void hideLoading(){

    }

    @Override
    public void showToast(String tips) {
        if (getActivity() instanceof BaseActivity){
            ((BaseActivity) getActivity()).showToast(tips);
        }
    }
}
