package com.wys.wanandroid.contract.base;

/**
 * Created by yas on 2017/11/30.
 */

public interface IBaseView {
    void showLoading(); //loading
    void showLoading(String tips); //loading
    void hideLoading();
    void showToast(String tips);
}
