package com.wys.wanandroid

import android.app.Application
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.wys.baselibrary.BaseLibrary
import com.wys.wanandroid.widget.recycler.RefreshTopView

/**
 * Created by yas on 2018/6/1.
 */
class WanApp : Application() {
    companion object {
        init {
            SmartRefreshLayout.setDefaultRefreshHeaderCreater { context, layout -> RefreshTopView(context) }
        }
    }

    override fun onCreate() {
        super.onCreate()
        BaseLibrary.init()
    }
}