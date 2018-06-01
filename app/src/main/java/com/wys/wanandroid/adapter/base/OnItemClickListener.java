package com.wys.wanandroid.adapter.base;

import android.view.View;

/**
 * Created by yas on 2018/4/27.
 */

public interface OnItemClickListener<E> {
    void onItemClick(View itemView, E entity, int position);
}
