package com.wys.wanandroid.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wys.wanandroid.R;
import com.wys.wanandroid.adapter.base.BaseRecyclerAdapter;
import com.wys.wanandroid.adapter.base.BaseViewHolder;
import com.wys.wanandroid.entity.PKnowledgeEntity;
import com.wys.wanandroid.entity.PSlideEntity;

import java.util.ArrayList;


/**
 * Created by yas on 2018/5/31.
 */

public class KnowledgeAdapter extends BaseRecyclerAdapter<KnowledgeAdapter.MyViewHolder,PKnowledgeEntity> {

    public KnowledgeAdapter(Context mContext, ArrayList<PKnowledgeEntity> mList) {
        super(mContext, mList);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.item_slide;
    }

    @Override
    protected MyViewHolder getViewHolder(View itemView) {
        return new MyViewHolder(itemView);
    }

    class MyViewHolder extends BaseViewHolder<PKnowledgeEntity> {
        private TextView tvTitle;
        private TextView tvSubTitle;
        public MyViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initView() {
            tvTitle = itemView.findViewById(R.id.txt_title);
            tvSubTitle = itemView.findViewById(R.id.txt_subTitle);
        }

        @Override
        public void setValues(PKnowledgeEntity entity) {
            tvTitle.setText(entity.name);
            String subTitle="";
            if (entity.children!=null){
                for (int i=0;i<entity.children.size();i++) {
                    subTitle = subTitle + " " + entity.children.get(i).name;
                }
            }
            tvSubTitle.setText(subTitle);
        }
    }
}
