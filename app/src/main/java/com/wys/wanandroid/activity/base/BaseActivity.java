package com.wys.wanandroid.activity.base;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.wys.wanandroid.contract.base.IBaseView;



/**
 * Created by yas on 2018/4/26.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    protected final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        initExtras();
        initLayout();
    }
    /**
     * 获取布局
     * @return
     */
    protected abstract int getLayoutRes();
    /**
     * 初始化布局view，做一些控件初始设置等操作
     */
    protected abstract void initLayout();
    /**
     *  获取上一页面传值
     */
    protected void  initExtras(){}



    private Runnable rTimeout = new Runnable() {
        @Override
        public void run() {
            hideLoading();
        }
    };
    @Override
    public void showLoading(){
        showLoading("数据正在加载中。。。");
    }
    @Override
    public void showLoading(String msg){
        showLoading(msg,true,false);
    }
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
        hideLoading();
    }

    @Override
    public void hideLoading(){
    }
    @Override
    public void showToast(String str){
        showToast(str,500);
    }

    protected void showToast(String str,int duration){
       Toast.makeText(this,str,duration).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hideLoading();
    }
}
