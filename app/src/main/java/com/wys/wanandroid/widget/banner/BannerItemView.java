package com.wys.wanandroid.widget.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.wys.wanandroid.R;
import com.wys.wanandroid.entity.PBannerItemEntity;
import com.wys.wanandroid.pic.PicLoadManager;

/**
 * Created by yas on 2018/6/4.
 */

public class BannerItemView extends FrameLayout{
    private ImageView img;
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
    }
    public void setBannerItemData(PBannerItemEntity entity){
        if (entity!=null){
            PicLoadManager.loadNetImg(getContext(),img,entity.imagePath);
        }
    }
}
