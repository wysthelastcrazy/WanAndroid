package com.wys.wanandroid.contract;

import com.wys.wanandroid.contract.base.IBaseModel;
import com.wys.wanandroid.contract.base.IBasePresenter;
import com.wys.wanandroid.contract.base.IBaseView;
import com.wys.wanandroid.entity.PHomeArticleItemEntity;
import com.wys.wanandroid.http.callback.ApiCallBack;

import java.util.ArrayList;

/**
 * Created by yas on 2018/6/28.
 */

public interface KnowledgeArticleContract {
    interface IArticleView extends IBaseView {
        void refreshList(ArrayList<PHomeArticleItemEntity> mList, boolean isSucc);
        void loadMore(ArrayList<PHomeArticleItemEntity> mList,boolean isSucc);
    }
    interface IArticlePresenter extends IBasePresenter<IArticleView> {
        void getArticleList(int cid);
        void refresh(int cid);
        void loadMore(int cid);
    }
    interface IArticleModel extends IBaseModel {
        void getArticleList(int pageNum, int cid,ApiCallBack callBack);
    }
}
