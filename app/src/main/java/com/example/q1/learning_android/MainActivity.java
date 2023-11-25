package com.example.q1.learning_android;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.q1.learning_android.adapter.ChatListAdapter;
import com.example.q1.learning_android.widget.MyListView;
import com.lzf.easyfloat.EasyFloat;
import com.lzf.easyfloat.enums.SidePattern;
import com.lzf.easyfloat.interfaces.OnFloatAnimator;
import com.lzf.easyfloat.interfaces.OnFloatCallbacks;

public class MainActivity extends AppCompatActivity {
    String TAG = "Q1";

    private Button bt1;
    private Button bt2;
    private Button bt_web;
    private Button bt_constraint;
    private Button bt_dialog;
    private Button bt_this_dialog;
    private Button bt_listView;
    private Button bt_progress;
    private Button bt_net;
    private Button bt_timer;
    private Button bt_async;
    private Button bt_theme;
    private Button bt_themeTow;

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
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PackageInfo packageInfo;
                String packageName = "com.xxx.android";
                try {
                    packageInfo = MainActivity.this.getPackageManager().getPackageInfo(packageName, 0);
                } catch (PackageManager.NameNotFoundException e) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    Log.d(TAG, "没有安装");
                } else {
                    Log.d(TAG, "已经安装");
                }

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
        bt_theme.setOnClickListener(new ClickHandle());
        bt_themeTow.setOnClickListener(new ClickHandle());

    }

    class Animator implements OnFloatAnimator {

        @Nullable
        @Override
        public android.animation.Animator enterAnim(@NonNull View view, @NonNull WindowManager.LayoutParams layoutParams, @NonNull WindowManager windowManager, @NonNull SidePattern sidePattern) {
//            layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
//                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE ;//| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE

            layoutParams.flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_SPLIT_TOUCH | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH | WindowManager.LayoutParams.FLAG_DITHER | WindowManager.LayoutParams.FLAG_SECURE;
            layoutParams.setTitle("com.miui.screenrecorder");

            /// 隐藏悬浮窗【小米，绘制伪装悬浮窗防录屏，yumi绘制模板】
//            window.addFlags(WindowManager.LayoutParams.FLAG_SECURE | WindowManager.LayoutParams.FLAG_DITHER);
//            window.setTitle("com.miui.screenrecorder");

//            layoutParams.flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM& WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

            return null;
        }

        @Nullable
        @Override
        public android.animation.Animator exitAnim(@NonNull View view, @NonNull WindowManager.LayoutParams layoutParams, @NonNull WindowManager windowManager, @NonNull SidePattern sidePattern) {
//            layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
//                    | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;//

            layoutParams.flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_SPLIT_TOUCH | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;

//            layoutParams.flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM& WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

            return null;
        }
    }

    private class ClickHandle implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.bt_async) {
                EasyFloat.with(MainActivity.this).setLayout(R.layout.float_layout_item)
                        .setAnimator(new Animator())
                        .registerCallbacks(
                                new OnFloatCallbacks() {
                                    @Override
                                    public void touchEvent(View view, MotionEvent motionEvent) {
//                                        float x = motionEvent.getX();
//                                        motionEvent.getr

//                                        float y = motionEvent.getY();
//                                        int action = motionEvent.getAction();
//                                        if (x == 0 && y != 0) {
//                                            MyListView list1 = view.findViewById(R.id.list1);
//                                            list1.scrollBy(0, (int) motionEvent.getY());
//                                        }else
//
//                                        if (x != 0 && y == 0) {
//                                            drag(view, motionEvent);
//                                        }


//                                        MyListView list1 = view.findViewById(R.id.list1);
//
//                                        int top = list1.getTop();
//                                        float y = motionEvent.getY();
//
//                                        if(y >= top){
//                                            list1.scrollBy(0,(int) y - top);
//                                        }



//                                        list1.getY();

//                                        Log.d("666","list raw y" + list1.getTop());
//                                        Log.d("666","motionEvent raw y" + motionEvent.getY());




//                                        list1.scrollBy(0, (int) motionEvent.getY());
                                    }

                                    @Override
                                    public void show(View view) {

                                    }

                                    @Override
                                    public void hide(View view) {

                                    }

                                    @Override
                                    public void dragEnd(View view) {

                                    }

                                    @Override
                                    public void drag(View view, MotionEvent motionEvent) {

                                    }

                                    @Override
                                    public void dismiss() {

                                    }

                                    @SuppressLint("ClickableViewAccessibility")
                                    @Override
                                    public void createdResult(boolean b, String s, View view) {
                                        MyListView list1 = view.findViewById(R.id.list1);
//                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                            list1.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//                                                @Override
//                                                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                                                    Log.d("Q1", "滑动scrollY:" + scrollY + "，" + "scrollX:" + scrollX + "，" + "oldScrollX:" + oldScrollX + "，" + "oldScrollY:" + oldScrollY);
//                                                }
//                                            });
//                                        }
                                        List<Map<String, Object>> data = new ArrayList<>();
                                        for (int i = 0; i < 10; i++) {
                                            HashMap<String, Object> map = new HashMap<>();
                                            map.put("id", "id" + i);
                                            map.put("name", "name" + i);
                                            data.add(map);
                                        }

                                        /// 自定义适配器

                                        ChatListAdapter chatListAdapter = new ChatListAdapter(MainActivity.this, data);
                                        list1.setAdapter(chatListAdapter);
                                        list1.setOnTouchListener(new View.OnTouchListener() {
                                            @Override
                                            public boolean onTouch(View v, MotionEvent event) {

                                                EasyFloat.dragEnable(event.getAction() == MotionEvent.ACTION_UP);

                                                return false;
                                            }
                                        });

                                        /// 默认适配器
//                                        String[] from = {"id", "name"};
//                                        int[] to = {R.id.id, R.id.name};
//                                        final SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, data, R.layout.item, from, to);
//                                        list1.setAdapter(simpleAdapter);
                                    }
                                }
                        ).show();


                return;
            }

            Intent intent = new Intent();

            //获取窗口区域
            Window window = MainActivity.this.getWindow();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

                /// 隐藏悬浮窗另一种写法
//                window.addFlags( 8192 | 4096);
            }

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
                case R.id.bt_theme:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    }
                    break;
                case R.id.bt_themeTow:
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                    }
                    break;
            }
            if (v.getId() != R.id.bt_net && v.getId() != R.id.bt1 && v.getId() != R.id.bt_theme && v.getId() != R.id.bt_themeTow) {
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
        bt2 = findViewById(R.id.bt2);
        bt_web = findViewById(R.id.bt_web);
        bt_constraint = findViewById(R.id.bt_constraint);
        bt_dialog = findViewById(R.id.bt_dialog);
        bt_this_dialog = findViewById(R.id.bt_this_dialog);
        bt_listView = findViewById(R.id.bt_listView);
        bt_progress = findViewById(R.id.bt_progress);
        bt_net = findViewById(R.id.bt_net);
        bt_timer = findViewById(R.id.bt_timer);
        bt_async = findViewById(R.id.bt_async);
        bt_theme = findViewById(R.id.bt_theme);
        bt_themeTow = findViewById(R.id.bt_themeTow);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "返回的Result：：" + resultCode, Toast.LENGTH_SHORT).show();
        Log.e("CrazyQ1", "Code::" + resultCode);
    }
}
