package com.wys.wanandroid.activity.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import com.wys.wanandroid.R;
import com.wys.wanandroid.activity.base.BaseNetFragment;
import com.wys.wanandroid.adapter.HomeAdapter;
import com.wys.wanandroid.contract.HomeContract;
import com.wys.wanandroid.contract.HomeContract.IHomePresenter;
import com.wys.wanandroid.entity.PBannerItemEntity;
import com.wys.wanandroid.entity.PHomeArticleItemEntity;
import com.wys.wanandroid.presenter.HomePresenter;
import com.wys.wanandroid.widget.banner.BannerView;
import com.wys.wanandroid.widget.recycler.ExtendRecyclerView;

import java.util.ArrayList;

/**
 * Created by yas on 2018/6/1.
 */

public class HomeFragment extends BaseNetFragment<IHomePresenter> implements HomeContract.IHomeView{
    private ExtendRecyclerView mRecyclerView;
    private HomeAdapter mAdapter;
    private BannerView mBannerView;
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void initViews(View rootView) {
        mRecyclerView=rootView.findViewById(R.id.home_recycler);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setEnableAutoLoadmore(true);
        mRecyclerView.setOnRefreshLoadmoreListener(refreshLoadmoreListener);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getArticleList();
        mPresenter.getBanner();
    }

    private OnRefreshLoadmoreListener refreshLoadmoreListener=new OnRefreshLoadmoreListener() {
        @Override
        public void onLoadmore(RefreshLayout refreshlayout) {
            mPresenter.loadMore();
        }

        @Override
        public void onRefresh(RefreshLayout refreshlayout) {
            mPresenter.refresh();
        }
    };
    @Override
    protected IHomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    public void refreshList(ArrayList<PHomeArticleItemEntity> mList,boolean isSucc) {
        if (mAdapter==null){
            mAdapter=new HomeAdapter(getActivity(),mList);
            mRecyclerView.setAdapter(mAdapter);
        }else{
            mRecyclerView.finishRefresh(isSucc);
            if (isSucc) {
                mAdapter.reSetList(mList);
            }
        }
    }

    @Override
    public void loadMore(ArrayList<PHomeArticleItemEntity> mList,boolean isSucc) {
        mRecyclerView.finishLoadmore(isSucc);
        if (isSucc){
            mAdapter.appendList(mList);
        }
    }

    @Override
    public void showBanner(ArrayList<PBannerItemEntity> mBanners) {
        mBannerView=new BannerView(getActivity());
        mRecyclerView.addHeaderView(mBannerView);
        mBannerView.setBannerList(mBanners);
    }
}
