package com.example.lx.listfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class GlideDemoActivity extends AppCompatActivity {

    private GifImageView ll_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_demo);
        ll_bg = (GifImageView) findViewById(R.id.ll_bg);
        try {
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.mipmap.newyear_bg);
            gifDrawable.setSpeed(0.5f);
            ll_bg.setImageDrawable(gifDrawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Glide.with(this).load(R.mipmap.newyear_bg).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(ll_bg);
    }
}