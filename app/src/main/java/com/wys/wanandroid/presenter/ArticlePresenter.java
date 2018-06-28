package com.wys.wanandroid.presenter;

import com.wys.wanandroid.contract.KnowledgeArticleContract;
import com.wys.wanandroid.contract.base.BasePresenter;
import com.wys.wanandroid.entity.PHomeArticleListEntity;
import com.wys.wanandroid.http.callback.ApiCallBack;
import com.wys.wanandroid.model.ArticleModel;

/**
 * Created by yas on 2018/6/28.
 */

public class ArticlePresenter extends BasePresenter<KnowledgeArticleContract.IArticleView> implements KnowledgeArticleContract.IArticlePresenter{
    private int curPage=0;
    private boolean over;
    private KnowledgeArticleContract.IArticleModel mModel;
    @Override
    public void initModel() {
        mModel=new ArticleModel();
    }

    @Override
    public void unBindModel() {
        mModel.onUnsubscribe();
    }

    @Override
    public void getArticleList(int cid) {
        mView.showLoading();
        mModel.getArticleList(curPage,cid, new ApiCallBack<PHomeArticleListEntity>() {

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
    public void refresh(int cid) {
        curPage=0;
        mModel.getArticleList(curPage,cid, new ApiCallBack<PHomeArticleListEntity>() {

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
    public void loadMore(int cid) {
        if (!over) {
            curPage += 1;
            mModel.getArticleList(curPage,cid,new ApiCallBack<PHomeArticleListEntity>() {

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
