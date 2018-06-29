package com.wys.wanandroid.widget.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.wys.wanandroid.R;
import com.wys.wanandroid.entity.PBannerItemEntity;
import com.wys.wanandroid.utils.ReflectUtils;

import java.util.List;

/**
 * Created by yas on 2018/6/4.
 */

public class BannerView extends FrameLayout{
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 100:
                    int curr=mBannerViewPager.getCurrentItem();
                    if ((curr+1)<mAdapter.getCount()){
                        mBannerViewPager.setCurrentItem(curr+1,true);
                    }else{
                        mBannerViewPager.setCurrentItem(0,true);
                    }
                    mHandler.sendEmptyMessageDelayed(100, 3000);
                    break;
            }
        }
    };
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
        mBannerViewPager.setPageTransformer(true,
                new ZoomOutPageTransformer());
        ReflectUtils.viewPagerSlowDown(mBannerViewPager);

    }
    public void setBannerList(List<PBannerItemEntity> mList){
        mAdapter=new LoopPagerAdapter(getContext(),mList);
        mBannerViewPager.setAdapter(mAdapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessageDelayed(100, 3000);
            }
        }).start();
    }
}
