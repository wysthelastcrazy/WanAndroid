package com.wys.wanandroid.widget.banner;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.wys.wanandroid.R;
import com.wys.wanandroid.entity.PBannerItemEntity;
import com.wys.wanandroid.pic.PicLoadManager;
import com.wys.wanandroid.utils.IntentUtils;

/**
 * Created by yas on 2018/6/4.
 */

public class BannerItemView extends FrameLayout implements View.OnClickListener {
    private ImageView img;
    private PBannerItemEntity mEntity;
    public BannerItemView(@NonNull Context context) {
        super(context);
        init();
    }

    public BannerItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BannerItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater li= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.banner_item_view,this,true);
        img=findViewById(R.id.img_banner);
        img.setOnClickListener(this);
    }
    public void setBannerItemData(PBannerItemEntity entity){
        mEntity=entity;
        if (entity!=null){
            PicLoadManager.loadNetImg(getContext(),img,entity.imagePath);
        }
    }

    @Override
    public void onClick(View v) {
        IntentUtils.startWebViewActivity((Activity) getContext(),mEntity.url);
    }
}
