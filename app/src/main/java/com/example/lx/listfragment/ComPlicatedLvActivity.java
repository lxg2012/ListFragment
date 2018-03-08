package com.example.lx.listfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @author LX
 *         屏幕截图测试
 */
public class ComPlicatedLvActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com_plicated_lv);
        imageView = (ImageView) findViewById(R.id.img_view);
        ScreenShotListenManager.newInstance(this).setListener(new ScreenShotListenManager.OnScreenShotListener() {
            @Override
            public void onShot(final String imagePath) {
                if (!TextUtils.isEmpty(imagePath)) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView.removeCallbacks(dissMissRunable);
                    imageView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(ComPlicatedLvActivity.this).load(imagePath).into(imageView);
                        }
                    }, 600);
                    imageView.postDelayed(dissMissRunable, 8000);
                }
            }
        }).startListen();
    }

    private Runnable dissMissRunable = new Runnable() {
        @Override
        public void run() {
            imageView.setVisibility(View.GONE);
        }
    };
}