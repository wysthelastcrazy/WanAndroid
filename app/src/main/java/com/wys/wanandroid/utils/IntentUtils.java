package com.wys.wanandroid.utils;

import android.app.Activity;
import android.content.Intent;

import com.wys.wanandroid.activity.KnowledgeTabActivity;
import com.wys.wanandroid.activity.WebViewActivity;
import com.wys.wanandroid.entity.PKnowledgeEntity;

/**
 * Created by yas on 2018/6/15.
 */

public class IntentUtils {
    /**
     * 跳转KnowledgeActivity
     * @param mActivity
     * @param entity
     */
    public static final void startKnowledgeActivity(Activity mActivity,PKnowledgeEntity entity){
        Intent intent=new Intent(mActivity, KnowledgeTabActivity.class);
        intent.putExtra("knowledge_entity",entity);
        mActivity.startActivity(intent);
    }

    /**
     * 跳转webView展示页
     * @param mActivity
     * @param url
     */
    public static final void startWebViewActivity(Activity mActivity,String url){
        Intent intent=new Intent(mActivity, WebViewActivity.class);
        intent.putExtra("Link",url);
        mActivity.startActivity(intent);
    }
}
