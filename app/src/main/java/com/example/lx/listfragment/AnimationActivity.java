package com.example.lx.listfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.UUID;

/**
 * @author LX
 *         蒙层测试
 */
public class AnimationActivity extends AppCompatActivity {

    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.layout_mengceng, null, false);
        addWindow(view);
    }

    private void addWindow(final View view) {
        final ViewGroup viewGroup = getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        if (view.getParent() == null) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            TextView textView = view.findViewById(R.id.tv_click);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewGroup.removeView(view);
                }
            });
        } else {
            throw new IllegalStateException("view already has parent,please remove it first");
        }
    }
}