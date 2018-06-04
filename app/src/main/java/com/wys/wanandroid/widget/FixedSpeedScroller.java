package com.wys.wanandroid.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import com.wys.wanandroid.common.MConfiger;


public class FixedSpeedScroller extends Scroller {
	private int mDuration = MConfiger.VIEWPAGER_SPEED;
	
	public FixedSpeedScroller(Context context, Interpolator interpolator) {
		super(context, interpolator);
		// TODO Auto-generated constructor stub
	}

	public FixedSpeedScroller(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	 
    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
 
    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
	 
    public void setmDuration(int time) {
        mDuration = time;
    }
 
    public int getmDuration() {
        return mDuration;
    }
}
