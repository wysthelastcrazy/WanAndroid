package com.wys.wanandroid.presenter;

import com.wys.wanandroid.contract.HomeContract;
import com.wys.wanandroid.contract.base.BasePresenter;
import com.wys.wanandroid.entity.PHomeArticleListEntity;
import com.wys.wanandroid.http.callback.ApiCallBack;
import com.wys.wanandroid.model.HomeModel;
import com.wys.wanandroid.utils.MyLog;

/**
 * Created by yas on 2018/6/4.
 */

public class HomePresenter extends BasePresenter<HomeContract.IHomeView> implements HomeContract.IHomePresenter{
    private HomeContract.IHomeModel mModel;
    private int curPage=0;
    private boolean over;
    @Override
    public void initModel() {
        mModel=new HomeModel();
    }

    @Override
    public void unBindModel() {
        mModel.onUnsubscribe();
        mModel=null;
    }

    @Override
    public void getArticleList() {
        mView.showLoading();
        mModel.getArticleList(curPage, new ApiCallBack<PHomeArticleListEntity>() {

            @Override
            public void onSuccessful(PHomeArticleListEntity pHomeArticleListEntity) {
                mView.refreshList(pHomeArticleListEntity.datas,true);
                over=pHomeArticleListEntity.over;
            }

            @Override
            public void onFailed(int errorCode, String errorMsg) {
                mView.showToast(errorMsg);
            }

            @Override
            public void onCompleted() {
                mView.hideLoading();
            }
        });
    }

    @Override
    public void refresh() {
        curPage=0;
        mModel.getArticleList(curPage, new ApiCallBack<PHomeArticleListEntity>() {

            @Override
            public void onSuccessful(PHomeArticleListEntity pHomeArticleListEntity) {
                mView.refreshList(pHomeArticleListEntity.datas,true);
                over=pHomeArticleListEntity.over;
            }

            @Override
            public void onFailed(int errorCode, String errorMsg) {
                mView.refreshList(null,false);
            }

            @Override
            public void onCompleted() {
            }
        });
    }

    @Override
    public void loadMore() {
        MyLog.debug("[loadMore] over:"+over);
        if (!over) {
            curPage += 1;
            mModel.getArticleList(curPage, new ApiCallBack<PHomeArticleListEntity>() {

                @Override
                public void onSuccessful(PHomeArticleListEntity pHomeArticleListEntity) {
                    mView.loadMore(pHomeArticleListEntity.datas, true);
                    over = pHomeArticleListEntity.over;
                }

                @Override
                public void onFailed(int errorCode, String errorMsg) {
                    mView.loadMore(null, false);
                }

                @Override
                public void onCompleted() {
                }
            });
        }else{
            mView.loadMore(null, false);
            mView.showToast("没有更多数据！");
        }
    }
}
