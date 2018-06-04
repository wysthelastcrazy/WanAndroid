package com.wys.wanandroid.utils;

import android.support.v4.view.ViewPager;
import android.view.animation.AccelerateInterpolator;

import com.wys.wanandroid.common.MConfiger;
import com.wys.wanandroid.widget.FixedSpeedScroller;

import java.lang.reflect.Field;

/***
 * 反射工具类
 * @date 2015/09/16
 */
public class ReflectUtils {
	private static final String TAG = "ReflectUtils";
	
	/***
	 * 减慢viewpager的滑动速度
	 * @param viewPager
	 */
	public static final void viewPagerSlowDown(ViewPager viewPager){
		try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(viewPager.getContext(),new AccelerateInterpolator());
            field.set(viewPager,scroller);
            scroller.setmDuration(MConfiger.VIEWPAGER_SPEED);
        } catch (Exception e) {
        	MyLog.error(TAG,e);
        }
	}
}
