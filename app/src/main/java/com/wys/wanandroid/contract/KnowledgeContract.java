package com.wys.wanandroid.contract;

import com.wys.wanandroid.contract.base.IBaseModel;
import com.wys.wanandroid.contract.base.IBasePresenter;
import com.wys.wanandroid.contract.base.IBaseView;
import com.wys.wanandroid.entity.PKnowledgeEntity;
import com.wys.wanandroid.http.callback.ApiCallBack;

import java.util.ArrayList;

/**
 * Created by yas on 2018/6/7.
 */

public interface KnowledgeContract {
    interface IKnowledgeView extends IBaseView{
        void showListInfo(ArrayList<PKnowledgeEntity> mList);
        void refresh(ArrayList<PKnowledgeEntity> mList,boolean isSucc);
    }
    interface IKnowledgePresenter extends IBasePresenter<IKnowledgeView>{
        void getKnowledgeTree();

        /**
         * 刷新操作
         */
        void refresh();
    }

    interface IKnowledgeModel extends IBaseModel{
        /**
         * 获取知识体系树形图数据
         * @param callBack
         */
        void getKnowledgeTree(ApiCallBack<ArrayList<PKnowledgeEntity>> callBack);
    }
}
