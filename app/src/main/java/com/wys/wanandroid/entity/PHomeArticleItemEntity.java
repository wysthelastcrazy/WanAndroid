package com.wys.wanandroid.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by yas on 2018/6/4.
 */

public class PHomeArticleItemEntity implements Serializable{
    public String apkLink;
    public String author;
    public int chapyerId;
    public String chapterName;
    public boolean collect;
    public int courseId;
    public String desc;
    public String envelopePic;
    public boolean fresh;
    public int id;
    public String link;
    public String niceDate;
    public String origin;
    public String projectLink;
    public long publishTime;
    public int superChapterId;
    public String superChapterName;

    public ArrayList<Tag> tags;

    public String title;
    public int type;
    public int userId;
    public int visible;
    public int zan;

    public class Tag implements Serializable{
        public String name;
        public String url;
    }
}
