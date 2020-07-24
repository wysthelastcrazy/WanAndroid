package com.wys.wanandroid;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.wys.wanandroid.widget.recycler.RefreshTopView;

/**
 * Created by yas on 2018/6/1.
 */

public class WanApp extends Application {
    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                return new RefreshTopView(context);
            }
        });
    }
}
