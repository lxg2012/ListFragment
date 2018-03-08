package com.example.lx.listfragment;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TabHost;

/**
 * @author LX
 * @date 2018/1/23
 */

@SuppressLint("AppCompatCustomView")
public class TouchImageView extends ImageView {

    private final int FLING_MIN_DISTANCE = 80, FLING_MIN_VELOCITY = 200;
    private int state = 1;

    public int getState() {
        return state;
    }

    private GestureDetector gestureListener = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.i("iamgeview", "onSingleTapUp");
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.i("iamgeview", "onDoubleTapEvent");
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float offsetX = e1.getX() - e2.getX();//X 方向偏移量
            float offsetY = e1.getY() - e2.getY();//Y 方向偏移量

            if (Math.abs(offsetX) > Math.abs(offsetY)) {//左滑或者右滑
                if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE) {
                    //Log.e("iamgeview","左滑");
                    // TouchImageView.this.scrollBy((int) offsetX,0);
                } else {
                    Log.e("iamgeview", "右滑");
                    ObjectAnimator.ofFloat(TouchImageView.this, "translationX", 0, 60).setDuration(1000).start();
                    state = -1;  // TouchImageView.this.scrollBy((int) offsetX,0);
                }
            }
            return true;
        }
    });

    public TouchImageView(Context context) {
        super(context);
    }

    public TouchImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
    }

    //初始状态
    public void restore() {
        state = 0;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureListener.onTouchEvent(event);
        return true;
        //return super.onTouchEvent(event);
    }

}