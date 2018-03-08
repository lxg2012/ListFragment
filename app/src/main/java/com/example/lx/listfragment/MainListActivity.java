package com.example.lx.listfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainListActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        editText = (EditText) findViewById(R.id.edt_view);
    }

    public void clickBtn(View view) {
        editText.setText("测试完毕");
    }
}