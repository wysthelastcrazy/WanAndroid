package com.wys.wanandroid.contract;

import com.wys.wanandroid.contract.base.IBaseModel;
import com.wys.wanandroid.contract.base.IBasePresenter;
import com.wys.wanandroid.contract.base.IBaseView;
import com.wys.wanandroid.entity.PBannerItemEntity;
import com.wys.wanandroid.entity.PHomeArticleItemEntity;
import com.wys.wanandroid.http.callback.ApiCallBack;

import java.util.ArrayList;

/**
 * Created by yas on 2018/6/4.
 */

public interface HomeContract {
    interface IHomeView extends IBaseView{
        void refreshList(ArrayList<PHomeArticleItemEntity> mList,boolean isSucc);
        void loadMore(ArrayList<PHomeArticleItemEntity> mList,boolean isSucc);
        void showBanner(ArrayList<PBannerItemEntity> mBanners);
    }
    interface IHomePresenter extends IBasePresenter<IHomeView>{
        void getArticleList();
        void refresh();
        void loadMore();
        void getBanner();
    }
    interface IHomeModel extends IBaseModel{
        void getArticleList(int pageNum, ApiCallBack callBack);
        void getBanner(ApiCallBack callBack);
    }
}
