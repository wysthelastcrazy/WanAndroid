package com.wys.wanandroid.activity.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wys.wanandroid.R;
import com.wys.wanandroid.activity.base.BaseFragment;
import com.wys.wanandroid.activity.base.BaseNetFragment;
import com.wys.wanandroid.adapter.KnowledgeAdapter;
import com.wys.wanandroid.adapter.base.OnItemClickListener;
import com.wys.wanandroid.contract.KnowledgeContract;
import com.wys.wanandroid.entity.PKnowledgeEntity;
import com.wys.wanandroid.presenter.KnowledgePresenter;
import com.wys.wanandroid.utils.IntentUtils;
import com.wys.wanandroid.widget.recycler.ExtendRecyclerView;

import java.util.ArrayList;


/**
 * Created by yas on 2018/6/1.
 */

public class KnowledgeFragment extends BaseNetFragment<KnowledgeContract.IKnowledgePresenter> implements KnowledgeContract.IKnowledgeView{
    private ExtendRecyclerView mRecyclerView;
    private KnowledgeAdapter mAdapter;
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_konwlege;
    }

    @Override
    public void initViews(View rootView) {
        mRecyclerView=rootView.findViewById(R.id.mRecyclerView_knowledge);

        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setEnableAutoLoadmore(false);
        mRecyclerView.setOnRefreshListener(mRefreshListener);
        mPresenter.getKnowledgeTree();

    }
    private OnRefreshListener mRefreshListener=new OnRefreshListener() {
        @Override
        public void onRefresh(RefreshLayout refreshlayout) {
            mPresenter.refresh();
        }
    };
    @Override
    public void showListInfo(ArrayList<PKnowledgeEntity> mList) {
        if (mAdapter==null){
            mAdapter=new KnowledgeAdapter(getActivity(),mList);
            mAdapter.setOnItemClickListener(itemClickListener);
            mRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.reSetList(mList);
        }
    }
    private OnItemClickListener itemClickListener=new OnItemClickListener<PKnowledgeEntity>() {

        @Override
        public void onItemClick(View itemView, PKnowledgeEntity entity, int position) {
            if (entity!=null){
                IntentUtils.startKnowledgeActivity(getActivity(),entity);
            }
        }
    };
    @Override
    public void refresh(ArrayList<PKnowledgeEntity> mList, boolean isSucc) {
        mRecyclerView.finishRefresh(isSucc);
        if (isSucc) mAdapter.reSetList(mList);
    }


    @Override
    protected KnowledgeContract.IKnowledgePresenter initPresenter() {
        return new KnowledgePresenter();
    }
}
