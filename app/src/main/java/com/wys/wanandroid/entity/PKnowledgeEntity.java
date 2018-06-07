package com.wys.wanandroid.entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by yas on 2018/6/7.
 */

public class PKnowledgeEntity implements Serializable{
    public int courseId;
    public int id;
    public String name;
    public int order;
    public int parentChapterId;
    public int visible;
    public ArrayList<PKnowledgeEntity> children;
}
