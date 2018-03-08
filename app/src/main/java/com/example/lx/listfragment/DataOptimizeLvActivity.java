package com.example.lx.listfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.ScaleModifier;

/**
 * @author LX
 *         复杂数据流在ListView中的应用
 */
public class DataOptimizeLvActivity extends AppCompatActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_optimize_lv);
        imageView = (ImageView) findViewById(R.id.imageView);
        //  listView = (ListView) findViewById(R.id.listview);
        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                new ParticleSystem(DataOptimizeLvActivity.this, 500, R.mipmap.bg_demo, 5000)
                        .setAcceleration(0.00003f, 270)
                        .addModifier(new ScaleModifier(0, 1.2f, 1000, 4000))
                        .setFadeOut(5000)
                        .setRotationSpeedRange(0, 180)
                        .emit(imageView, 50);
            }
        }, 2000);
    }

    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

    }
}