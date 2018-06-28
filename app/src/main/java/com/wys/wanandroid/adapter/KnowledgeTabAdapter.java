package com.wys.wanandroid.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.wys.wanandroid.activity.fragment.KnowledgeItemFragment;
import com.wys.wanandroid.entity.PKnowledgeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yas on 2018/6/7.
 */

public class KnowledgeTabAdapter extends FragmentStatePagerAdapter{
    private List<Fragment> fragments;
    private List<PKnowledgeEntity> mList;
    public KnowledgeTabAdapter(FragmentManager fm,List<PKnowledgeEntity> mList) {
        super(fm);
        this.mList=mList;
        initFragment();
    }

    private void initFragment() {
        fragments=new ArrayList<>();
        for (int i=0;i<mList.size();i++){
            PKnowledgeEntity itemEntity= mList.get(i);
            Bundle bundle=new Bundle();
            bundle.putInt("cid",itemEntity.id);
            Fragment fragment=new KnowledgeItemFragment();
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).name;
    }
}
