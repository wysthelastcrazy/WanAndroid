package com.wys.wanandroid.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wys.wanandroid.R;
import com.wys.wanandroid.adapter.base.BaseRecyclerAdapter;
import com.wys.wanandroid.adapter.base.BaseViewHolder;
import com.wys.wanandroid.entity.PHomeArticleItemEntity;
import com.wys.wanandroid.utils.DateUtil;
import com.wys.wanandroid.utils.MyLog;

import java.util.ArrayList;

/**
 * Created by yas on 2018/6/28.
 */

public class ArticleAdapter extends BaseRecyclerAdapter<ArticleAdapter.MyViewHold,PHomeArticleItemEntity>{

    public ArticleAdapter(Context mContext, ArrayList<PHomeArticleItemEntity> mList) {
        super(mContext, mList);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.item_home;
    }

    @Override
    protected MyViewHold getViewHolder(View itemView) {
        return new MyViewHold(itemView);
    }

    class MyViewHold extends BaseViewHolder<PHomeArticleItemEntity>{
        private ImageView imgIcon;
        private TextView txtAuthor;
        private TextView txtTime;
        private TextView txtTitle;
        private TextView txtTag;
        private ImageView imgCollect;
        public MyViewHold(View itemView) {
            super(itemView);
        }

        @Override
        public void initView() {
            imgIcon=itemView.findViewById(R.id.img_icon);
            txtAuthor=itemView.findViewById(R.id.txt_author);
            txtTime=itemView.findViewById(R.id.txt_time);
            txtTitle=itemView.findViewById(R.id.txt_title);
            txtTag=itemView.findViewById(R.id.txt_tags);
            imgCollect=itemView.findViewById(R.id.img_collect);
        }

        @Override
        public void setValues(PHomeArticleItemEntity entity) {
            txtAuthor.setText(entity.author);
            txtTime.setText(DateUtil.getCurrentTimeV2(entity.publishTime));
            txtTitle.setText(entity.title);
            txtTag.setText(entity.chapterName);
            if (entity.collect){
                imgCollect.setImageResource(R.mipmap.xq_collect_ok);
            }else{
                imgCollect.setImageResource(R.mipmap.xq_collect);
            }
        }
    }
}
