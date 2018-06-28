package com.wys.wanandroid.activity.fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.wys.wanandroid.R;
import com.wys.wanandroid.activity.base.BaseNetFragment;
import com.wys.wanandroid.adapter.ArticleAdapter;
import com.wys.wanandroid.adapter.HomeAdapter;
import com.wys.wanandroid.contract.KnowledgeArticleContract;
import com.wys.wanandroid.entity.PHomeArticleItemEntity;
import com.wys.wanandroid.presenter.ArticlePresenter;
import com.wys.wanandroid.utils.MyLog;
import com.wys.wanandroid.widget.recycler.ExtendRecyclerView;

import java.util.ArrayList;


/**
 * Created by yas on 2018/6/15.
 */

public class KnowledgeItemFragment extends BaseNetFragment<KnowledgeArticleContract.IArticlePresenter> implements KnowledgeArticleContract.IArticleView{
    private ExtendRecyclerView mRecyclerView;
    private ArticleAdapter mAdapter;
    private int cid;
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_knowledge_item;
    }

    @Override
    public void initViews(View rootView) {
        mRecyclerView=rootView.findViewById(R.id.knowledge_recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setOnRefreshLoadmoreListener(refreshLoadmoreListener);
        Bundle arguments = getArguments();
        cid=arguments.getInt("cid");
        MyLog.debug(TAG,"[initViews]  cid:"+cid);
        mPresenter.getArticleList(cid);
    }
    private OnRefreshLoadmoreListener refreshLoadmoreListener=new OnRefreshLoadmoreListener() {
        @Override
        public void onLoadmore(RefreshLayout refreshlayout) {
            mPresenter.loadMore(cid);
        }

        @Override
        public void onRefresh(RefreshLayout refreshlayout) {
            mPresenter.refresh(cid);
        }
    };
    @Override
    public void refreshList(ArrayList<PHomeArticleItemEntity> mList, boolean isSucc) {
        mRecyclerView.finishRefresh(isSucc);
        if (isSucc) {
            if (mAdapter == null) {
                mAdapter = new ArticleAdapter(getActivity(), mList);
                mRecyclerView.setAdapter(mAdapter);
            } else {
                mAdapter.reSetList(mList);
            }
        }
    }

    @Override
    public void loadMore(ArrayList<PHomeArticleItemEntity> mList, boolean isSucc) {
        mRecyclerView.finishLoadmore(isSucc);
        if (isSucc){
            mAdapter.appendList(mList);
        }
    }

    @Override
    protected KnowledgeArticleContract.IArticlePresenter initPresenter() {
        return new ArticlePresenter();
    }
}
