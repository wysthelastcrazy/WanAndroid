package com.wys.wanandroid.model;

import com.wys.wanandroid.contract.KnowledgeContract;
import com.wys.wanandroid.contract.base.BaseModel;
import com.wys.wanandroid.entity.PKnowledgeEntity;
import com.wys.wanandroid.http.ProtocolManager;
import com.wys.wanandroid.http.callback.ApiCallBack;

import java.util.ArrayList;

/**
 * Created by yas on 2018/6/7.
 */

public class KnowledgeModel extends BaseModel implements KnowledgeContract.IKnowledgeModel{
    @Override
    public void getKnowledgeTree(ApiCallBack<ArrayList<PKnowledgeEntity>> callBack) {
        addSubscription(ProtocolManager.getKnowledgeTree(),callBack);
    }
}
