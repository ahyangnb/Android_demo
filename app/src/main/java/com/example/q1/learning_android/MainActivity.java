package com.example.q1.learning_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String TAG = "Q1";

    private Button bt1;
    private Button bt_web;
    private Button bt_constraint;
    private Button bt_dialog;
    private Button bt_this_dialog;
    private Button bt_listView;
    private Button bt_progress;
    private Button bt_net;
    private Button bt_timer;
    private Button bt_async;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyClerView.class);
                startActivityForResult(intent, 1000);

            }
        });
        bt_web.setOnClickListener(new ClickHandle());
        bt_constraint.setOnClickListener(new ClickHandle());
        bt_dialog.setOnClickListener(new ClickHandle());
        bt_this_dialog.setOnClickListener(new ClickHandle());
        bt_listView.setOnClickListener(new ClickHandle());
        bt_progress.setOnClickListener(new ClickHandle());
        bt_net.setOnClickListener(new ClickHandle());
        bt_timer.setOnClickListener(new ClickHandle());
        bt_async.setOnClickListener(new ClickHandle());

    }

    private class ClickHandle implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.bt1:
                    intent = new Intent(MainActivity.this, RecyClerView.class);
                    startActivityForResult(intent, 1000);
                    break;
                case R.id.bt_web:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.bt_constraint:
                    intent = new Intent(MainActivity.this, Constraint.class);
                    break;
                case R.id.bt_dialog:
                    intent = new Intent(MainActivity.this, DialogActivati.class);
                    break;
                case R.id.bt_this_dialog:
                    intent = new Intent(MainActivity.this, ThisDialog.class);
                    break;
                case R.id.bt_progress:
                    intent = new Intent(MainActivity.this, Progress.class);
                    break;
                case R.id.bt_listView:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.bt_net:
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            getNet();
                        }
                    }.start();
                    break;
                case R.id.bt_timer:
                    intent = new Intent(MainActivity.this, TimerActivity.class);
                    break;
                case R.id.bt_async:
                    intent = new Intent(MainActivity.this, AsyncActivity.class);
                    break;
            }
            if (v.getId() != R.id.bt_net && v.getId() != R.id.bt1) {
                startActivity(intent);
            }

        }
    }

    void getNet() {
        try {
            URL url = new URL("https://wanandroid.com/wxarticle/chapters/json");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(3000);

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
                byte[] b = new byte[1024];
                int len = 0;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (((len = in.read(b)) > -1)) {
                    byteArrayOutputStream.write(b, 0, len);
                }

                final String msg = new String(byteArrayOutputStream.toByteArray());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "成功" + msg, Toast.LENGTH_SHORT).show();
                    }
                });
                Log.d(TAG, "成功" + msg);
            } else {
                Log.e(TAG, "失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findId() {
        bt1 = findViewById(R.id.bt1);
        bt_web = findViewById(R.id.bt_web);
        bt_constraint = findViewById(R.id.bt_constraint);
        bt_dialog = findViewById(R.id.bt_dialog);
        bt_this_dialog = findViewById(R.id.bt_this_dialog);
        bt_listView = findViewById(R.id.bt_listView);
        bt_progress = findViewById(R.id.bt_progress);
        bt_net = findViewById(R.id.bt_net);
        bt_timer = findViewById(R.id.bt_timer);
        bt_async = findViewById(R.id.bt_async);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "返回的Result：：" + resultCode, Toast.LENGTH_SHORT).show();
        Log.e("CrazyQ1", "Code::" + resultCode);
    }
}
