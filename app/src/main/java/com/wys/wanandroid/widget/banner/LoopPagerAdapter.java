package com.wys.wanandroid.widget.banner;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.wys.wanandroid.entity.PBannerItemEntity;

import java.util.List;

/**
 * Created by yas on 2018/6/4.
 */

public class LoopPagerAdapter extends PagerAdapter {
    private List<PBannerItemEntity> mDatas;
    private Context mContext;
    public LoopPagerAdapter(Context mContext,List<PBannerItemEntity> mList){
        this.mContext=mContext;
        this.mDatas=mList;
    }

    @Override
    public int getCount() {
        return mDatas!=null?mDatas.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BannerItemView view = new BannerItemView(this.mContext);
        PBannerItemEntity itemEntity = mDatas.get(position);
        view.setBannerItemData(itemEntity);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
