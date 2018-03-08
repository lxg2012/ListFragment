package com.example.lx.listfragment;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

public class TouchActivity extends AppCompatActivity {


    private TouchImageView img_home_qucik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        img_home_qucik = (TouchImageView) findViewById(R.id.img_home_qucik);
        img_home_qucik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(img_home_qucik.getState()==-1){
                    ObjectAnimator.ofFloat(img_home_qucik,"translationX",0,-60).setDuration(1000).start();
                    img_home_qucik.restore();
                }else{
                    Toast.makeText(TouchActivity.this,"點擊啦",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}