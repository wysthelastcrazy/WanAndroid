package com.wys.wanandroid.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by yas on 2018/6/4.
 */

public class PHomeArticleListEntity implements Serializable{
    public int curPage;
    public ArrayList<PHomeArticleItemEntity> datas;
    public int offset;
    public boolean over;
    public int pageCount;
    public int size;
    public int total;
}
