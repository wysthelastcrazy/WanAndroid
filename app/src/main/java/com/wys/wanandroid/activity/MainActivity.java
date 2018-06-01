package com.wys.wanandroid.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.wys.wanandroid.R;
import com.wys.wanandroid.activity.base.BaseActivity;
import com.wys.wanandroid.activity.fragment.HomeFragment;
import com.wys.wanandroid.activity.fragment.KnowledgeFragment;
import com.wys.wanandroid.activity.fragment.NavigationFragment;
import com.wys.wanandroid.activity.fragment.ProjectFragment;


public class MainActivity extends BaseActivity {


    private FrameLayout content;
    private BottomNavigationBar mBottomView;

    private Fragment mHomeFragment;
    private Fragment mKonwledgeFragment;
    private Fragment mNavigationFregment;
    private Fragment mProjectFragment;

    private Fragment currFragment;
    private FragmentManager manager;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initLayout() {
        mBottomView=this.findViewById(R.id.mBottomView);

        mBottomView.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomView.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomView.setBarBackgroundColor(R.color.colorAccent);
        mBottomView.addItem(new BottomNavigationItem(R.mipmap.icon_home_pager_not_selected, "首页").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.icon_knowledge_hierarchy_not_selected, "知识体系").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.icon_navigation_not_selected, "导航").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.icon_project_not_selected, "项目").setActiveColorResource(R.color.colorPrimary))
                .initialise();
        mBottomView.setTabSelectedListener(mTabChangeListener);

        initFragments();
    }

    private void initFragments() {
        mHomeFragment=new HomeFragment();
        mKonwledgeFragment=new KnowledgeFragment();
        mNavigationFregment=new NavigationFragment();
        mProjectFragment=new ProjectFragment();

        manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.content, mHomeFragment, "flag1").commitAllowingStateLoss();
        currFragment = mHomeFragment;
    }

    private BottomNavigationBar.OnTabSelectedListener mTabChangeListener=new BottomNavigationBar.OnTabSelectedListener() {
        @Override
        public void onTabSelected(int position) {
            switch (position){
                case 0:
                    switchContent(currFragment,mHomeFragment);
                    break;
                case 1:
                    switchContent(currFragment,mKonwledgeFragment);
                    break;
                case 2:
                    switchContent(currFragment,mNavigationFregment);
                    break;
                case 3:
                    switchContent(currFragment,mProjectFragment);
                    break;
            }
        }

        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {

        }
    };
    public void switchContent(Fragment from, Fragment to) {
        if (currFragment != to) {
            currFragment = to;
            FragmentTransaction transaction = manager.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                String flag = "";
                if (to instanceof HomeFragment)
                    flag = "flag1";
                if (to instanceof KnowledgeFragment)
                    flag = "flag2";
                if (to instanceof NavigationFragment)
                    flag="flag3";
                if (to instanceof ProjectFragment){
                    flag="flag4";
                }
                transaction.hide(from).add(R.id.content, to, flag).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
        }
    }
}
