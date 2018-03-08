package com.example.lx.listfragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

/**
 * @author LX
 * @date 2018/1/17
 */

public class DecorViewHelper {

    private Activity context;
    private View view;

    public DecorViewHelper init(@NonNull Activity context, @NonNull View view) {
        this.context = context;
        this.view = view;
        return new DecorViewHelper();
    }

    @SuppressWarnings("unchecked")
    public void addListenner(@IdRes int resourceId) {
        // View view  = view.findViewById(resourceId);
    }

    public void addViewAtWindow(ViewGroup.LayoutParams layoutParams) {
        //FrameLayout.LayoutParams layoutParams1= new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup viewGroup = context.getWindow().getDecorView().findViewById(Window.ID_ANDROID_CONTENT);
        viewGroup.addView(view, layoutParams);
    }

    public void addViewAtWindow() {
        ViewGroup viewGroup = context.getWindow().getDecorView().findViewById(Window.ID_ANDROID_CONTENT);
        viewGroup.addView(view);
    }

}