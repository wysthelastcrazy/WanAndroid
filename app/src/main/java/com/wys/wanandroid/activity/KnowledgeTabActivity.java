package com.wys.wanandroid.activity;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;

import com.wys.wanandroid.R;
import com.wys.wanandroid.activity.base.BaseActivity;
import com.wys.wanandroid.adapter.KnowledgeTabAdapter;
import com.wys.wanandroid.entity.PKnowledgeEntity;


/**
 * Created by yas on 2018/6/7.
 */

public class KnowledgeTabActivity extends BaseActivity{
    private PKnowledgeEntity mEntity;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private KnowledgeTabAdapter mAdapter;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_knowledge_tab;
    }

    @Override
    protected void initLayout() {
        mTabLayout= (TabLayout) this.findViewById(R.id.tabs);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mViewPager= (ViewPager) this.findViewById(R.id.vp_knowledge);
        initTabs();
    }

    private void initTabs() {
        if (mEntity!=null&&mEntity.children!=null){
            mAdapter=new KnowledgeTabAdapter(getSupportFragmentManager(),mEntity.children);
            mViewPager.setAdapter(mAdapter);
            mTabLayout.setupWithViewPager(mViewPager);
        }
    }

    @Override
    protected void initExtras() {
        mEntity= (PKnowledgeEntity) getIntent().getSerializableExtra("knowledge_entity");
    }
}
