package com.wys.wanandroid.activity.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.wys.wanandroid.R;
import com.wys.wanandroid.activity.base.BaseFragment;
import com.wys.wanandroid.adapter.SlideAdapter;
import com.wys.wanandroid.entity.PSlideEntity;
import com.wys.wanandroid.widget.recycler.XRecyclerView;
import com.wys.wanandroid.widget.recycler.customLayoutManager.slide.ItemTouchHelperCallback;
import com.wys.wanandroid.widget.recycler.customLayoutManager.slide.SlideLayoutManager;

import java.util.ArrayList;

/**
 * Created by yas on 2018/6/1.
 */

public class KnowledgeFragment extends BaseFragment {
    private XRecyclerView mRecyclerView;
    private SlideAdapter mAdapter;
    private ArrayList<PSlideEntity> mList = new ArrayList<>();
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_konwlege;
    }

    @Override
    public void initViews(View rootView) {
        mRecyclerView=rootView.findViewById(R.id.mRecyclerView_knowledge);


        mAdapter=new SlideAdapter(getActivity(),mList);
        mRecyclerView.setAdapter(mAdapter);
        addData();

        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ItemTouchHelperCallback(mRecyclerView.getAdapter(),mList));

        SlideLayoutManager manager=new SlideLayoutManager(mRecyclerView,itemTouchHelper);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(manager);

    }
    /**
     * 向集合中添加数据
     */
    private void addData(){
        int[] icons = {R.mipmap.header_icon_1, R.mipmap.header_icon_2, R.mipmap.header_icon_3,
                R.mipmap.header_icon_4, R.mipmap.header_icon_1, R.mipmap.header_icon_2};
        String[] titles = {"Acknowledging", "Belief", "Confidence", "Dreaming", "Happiness", "Confidence"};
        String[] says = {
                "Do one thing at a time, and do well.",
                "Keep on going never give up.",
                "Whatever is worth doing is worth doing well.",
                "I can because i think i can.",
                "Jack of all trades and master of none.",
                "Keep on going never give up.",
                "Whatever is worth doing is worth doing well.",
        };
        int[] bgs = {
                R.mipmap.img_slide_1,
                R.mipmap.img_slide_2,
                R.mipmap.img_slide_3,
                R.mipmap.img_slide_4,
                R.mipmap.img_slide_5,
                R.mipmap.img_slide_6
        };

        for (int i = 0; i < 6; i++) {
            mList.add(new PSlideEntity(bgs[i],titles[i],icons[i],says[i]));
        }
    }
}
