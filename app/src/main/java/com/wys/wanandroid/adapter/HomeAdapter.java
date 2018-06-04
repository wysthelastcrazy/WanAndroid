package com.wys.wanandroid.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.wys.wanandroid.R;
import com.wys.wanandroid.adapter.base.BaseRecyclerAdapter;
import com.wys.wanandroid.adapter.base.BaseViewHolder;
import com.wys.wanandroid.entity.PHomeArticleItemEntity;

import java.util.ArrayList;

/**
 * Created by yas on 2018/6/4.
 */

public class HomeAdapter extends BaseRecyclerAdapter<HomeAdapter.HomeViewHolder,PHomeArticleItemEntity>{
    public HomeAdapter(Context mContext, ArrayList<PHomeArticleItemEntity> mList) {
        super(mContext, mList);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.item_home;
    }

    @Override
    protected HomeViewHolder getViewHolder(View itemView) {
        return new HomeViewHolder(itemView);
    }

    class HomeViewHolder extends BaseViewHolder<PHomeArticleItemEntity>{
        private TextView txtTitle;
        public HomeViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initView() {
            txtTitle=itemView.findViewById(R.id.txt_title);
        }

        @Override
        public void setValues(PHomeArticleItemEntity pHomeArticleItemEntity) {
            txtTitle.setText(pHomeArticleItemEntity.title);
        }
    }
}
