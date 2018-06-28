package com.wys.wanandroid.model;

import com.wys.wanandroid.contract.KnowledgeArticleContract;
import com.wys.wanandroid.contract.base.BaseModel;
import com.wys.wanandroid.http.ProtocolManager;
import com.wys.wanandroid.http.callback.ApiCallBack;

/**
 * Created by yas on 2018/6/28.
 */

public class ArticleModel extends BaseModel implements KnowledgeArticleContract.IArticleModel{
    @Override
    public void getArticleList(int pageNum,int cid, ApiCallBack callBack) {
        addSubscription(ProtocolManager.getKnowledgeArticleList(pageNum,cid),callBack);
    }
}
