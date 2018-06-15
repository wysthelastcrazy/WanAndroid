package com.wys.wanandroid.activity.fragment;

import android.view.View;

import com.wys.wanandroid.R;
import com.wys.wanandroid.activity.base.BaseFragment;
import com.wys.wanandroid.widget.recycler.ExtendRecyclerView;


/**
 * Created by yas on 2018/6/15.
 */

public class KnowledgeItemFragment extends BaseFragment {
    private ExtendRecyclerView mRecyclerView;
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_knowledge_item;
    }

    @Override
    public void initViews(View rootView) {
        mRecyclerView=rootView.findViewById(R.id.knowledge_recyclerView);
    }

}
