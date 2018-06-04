package com.wys.wanandroid.widget.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.wys.wanandroid.R;
import com.wys.wanandroid.entity.PBannerItemEntity;

import java.util.List;

/**
 * Created by yas on 2018/6/4.
 */

public class BannerView extends FrameLayout{
    private ViewPager mBannerViewPager;
    private LoopPagerAdapter mAdapter;
    public BannerView(Context context) {
        super(context);
        init();
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater li= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.banner_view_layout,this,true);

        mBannerViewPager=findViewById(R.id.vp_banner);
    }
    public void setBannerList(List<PBannerItemEntity> mList){
        mAdapter=new LoopPagerAdapter(getContext(),mList);
        mBannerViewPager.setAdapter(mAdapter);
    }
}
