package com.example.lx.listfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private String path;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_sevven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        webView = (WebView) findViewById(R.id.web);
        //  webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
    }

    public void clicks(View view) {
        path = getExternalFilesDir(null).getAbsolutePath();
        try {
            unZip(Main2Activity.this, "organization.z", path, true);
            String url = "file://" + path + "/lian/demo.html";
            webView.loadUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unZip(Context mContext, String packageName,
                      String outputDirectory, boolean isReWrite) throws IOException {
        /**
         * 文件路径
         */
        File file = new File(outputDirectory);
        /**
         * 判断是否存在 不存在创建
         */
        if (!file.exists()) {
            file.mkdirs();
        }
        /**
         * 获取assets中的文件流
         */
        InputStream inputStream = mContext.getApplicationContext().getResources().getAssets().open(packageName);
        /**
         * 获取zipInputStream
         */
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        /**
         * 字节数
         */
        byte[] buffer = new byte[1024 * 1024];
        int count = 0;
        /**
         * 循环判断是否存在
         */
        while (zipEntry != null) {
            if (zipEntry.isDirectory()) {
                file = new File(outputDirectory + File.separator + zipEntry.getName());
                if (isReWrite || !file.exists()) {
                    file.mkdir();
                }
            } else {
                /**
                 * 进行循环判断
                 */
                file = new File(outputDirectory + File.separator
                        + zipEntry.getName());
                if (isReWrite || !file.exists()) {
                    /**
                     * 创建压缩包下的文件夹
                     */
                    file.createNewFile();
                    /**
                     * 读取流
                     */
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    while ((count = zipInputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, count);
                    }
                    /**
                     * 关闭流
                     */
                    fileOutputStream.close();
                }
            }
            /**
             * 指向下一个目录
             */
            zipEntry = zipInputStream.getNextEntry();
        }
        /**
         * 关闭所有的流
         */
        zipInputStream.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                clicks(v);
                break;
            case R.id.btn_two:
                startActivity(new Intent(Main2Activity.this, ThreadRunActivity.class));
                break;
            case R.id.btn_three:
                startActivity(new Intent(Main2Activity.this, AnimationActivity.class));
                break;
            case R.id.btn_four:
                startActivity(new Intent(Main2Activity.this, ComPlicatedLvActivity.class));
                break;
            case R.id.btn_five:
                startActivity(new Intent(Main2Activity.this, DataOptimizeLvActivity.class));
                break;
            case R.id.btn_six:
                startActivity(new Intent(Main2Activity.this, GlideDemoActivity.class));
                break;
            case R.id.btn_sevven:
                startActivity(new Intent(Main2Activity.this,TouchActivity.class));
                break;
            case R.id.btn_eight:
                startActivity(new Intent(Main2Activity.this,MainListActivity.class));
                break;
            default:
                break;
        }
    }
}