package com.wys.wanandroid.pic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by yas on 2018/5/30.
 */

public class PicLoadManager {

    /**
     * 网络图片加载
     * @param mContext
     * @param imgView
     * @param picUrl
     */
    public static void loadNetImg(Context mContext, ImageView imgView, String picUrl){
        loadNetImg(mContext,imgView,picUrl,null);
    }
    /**
     * 网络图片加载
     * @param mContext
     * @param imgView
     * @param picUrl
     * @param drawable
     */
    public static void loadNetImg(Context mContext, ImageView imgView, String picUrl, Drawable drawable){
        DrawableRequestBuilder builder = Glide.with(mContext).load(picUrl);
        builder.centerCrop();
        if(drawable != null){
            builder.placeholder(drawable).crossFade().centerCrop();
        }
        builder.into(imgView);
    }

    /**
     * glide加载本地图片
     * @param mContext
     * @param imageView
     * @param picPath
     */
    public static void loadLocImg(Context mContext,ImageView imageView,String picPath){
        File file=new File(picPath);
        DrawableTypeRequest builder=Glide.with(mContext).load(file);
        builder.centerCrop();
        builder.into(imageView);
    }
}
