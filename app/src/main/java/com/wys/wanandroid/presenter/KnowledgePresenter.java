package com.wys.wanandroid.presenter;

import com.wys.wanandroid.contract.KnowledgeContract;
import com.wys.wanandroid.contract.base.BasePresenter;
import com.wys.wanandroid.entity.PKnowledgeEntity;
import com.wys.wanandroid.http.callback.ApiCallBack;
import com.wys.wanandroid.model.KnowledgeModel;

import java.util.ArrayList;

/**
 * Created by yas on 2018/6/7.
 */

public class KnowledgePresenter extends BasePresenter<KnowledgeContract.IKnowledgeView> implements KnowledgeContract.IKnowledgePresenter{
    private KnowledgeContract.IKnowledgeModel mModel;
    @Override
    public void initModel() {
        mModel=new KnowledgeModel();
    }

    @Override
    public void unBindModel() {
        mModel.onUnsubscribe();
    }

    @Override
    public void getKnowledgeTree() {
        getData(false);
    }

    @Override
    public void refresh() {
        getData(true);
    }
    private void getData(final boolean isRefresh){
        if (!isRefresh)mView.showLoading();
        mModel.getKnowledgeTree(new ApiCallBack<ArrayList<PKnowledgeEntity>>() {
            @Override
            public void onSuccessful(ArrayList<PKnowledgeEntity> pKnowledgeEntities) {
                if (isRefresh){
                    mView.refresh(pKnowledgeEntities,true);
                }else{
                    mView.showListInfo(pKnowledgeEntities);
                }
            }

            @Override
            public void onFailed(int errorCode, String errorMsg) {
                if (isRefresh){
                    mView.refresh(null,false);
                }
            }

            @Override
            public void onCompleted() {
                if (!isRefresh){
                    mView.hideLoading();
                }
            }
        });
    }
}
