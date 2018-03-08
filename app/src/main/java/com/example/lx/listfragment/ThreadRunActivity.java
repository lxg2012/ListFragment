package com.example.lx.listfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.annotation.Target;

/**
 * @author lxgang
 *         {@link com.example.lx.listfragment.note #MutiThreadNote}
 */
public class ThreadRunActivity extends AppCompatActivity {

    private volatile String names = "线程B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_run);
        MyThread myThread = new MyThread("线程A");
        myThread.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(names + "...." + i);
                }
            }
        }).start();
    }

    protected class MyThread extends Thread {

        private String name;

        protected MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + "...." + i);

            }
        }
    }

}