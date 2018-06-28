package com.wys.wanandroid.http;


import com.wys.wanandroid.entity.PBannerItemEntity;
import com.wys.wanandroid.entity.PHomeArticleListEntity;
import com.wys.wanandroid.entity.PKnowledgeEntity;
import com.wys.wanandroid.http.callback.HttpBaseResult;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * API--接口  服务[这里处理的是同一的返回格式 resultCode  resultInfo Data<T> --->这里的data才是返回的结果,T就是泛型 具体返回的been对象或集合]
 * Created by yas on 2017/12/14.
 */
public interface APIService {

    /**
     * 获取首页文章列表
     * @param num
     * @return
     */
    @GET("/article/list/{num}/json")
    Observable<HttpBaseResult<PHomeArticleListEntity>>getHomeArticleList(@Path("num") int num);

    @GET("/banner/json")
    Observable<HttpBaseResult<ArrayList<PBannerItemEntity>>> getBanner();
    @GET("/tree/json")
    Observable<HttpBaseResult<ArrayList<PKnowledgeEntity>>>getKnowledgeTree();

    @GET("/article/list/{num}/json")
    Observable<HttpBaseResult<PHomeArticleListEntity>>getKnowledgeArticleList(@Path("num") int num, @Query("cid") int cid);
}

