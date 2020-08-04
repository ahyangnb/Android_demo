package com.example.q1.learning_android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {
    String TAG = "Q1";

    private ListView list1;

    final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(ListViewActivity.this, "HandleMsg", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        list1 = findViewById(R.id.list1);

        Button bt_param = findViewById(R.id.bt_param);
        bt_param.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        starParam();
                    }
                }
        );
    }

    void starParam() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                getNet();
            }
        }.start();
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
                int len;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (((len = in.read(b)) > -1)) {
                    byteArrayOutputStream.write(b, 0, len);
                }

                final String msg = new String(byteArrayOutputStream.toByteArray());
                JSONObject jsonObject = new JSONObject(msg);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                List<Map<String, Object>> data = jsonArrayToList(jsonArray);

                String[] from = {"id", "name"};
                int[] to = {R.id.id, R.id.name};
                final SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, R.layout.item, from, to);

                // 调用主线程刷新UI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list1.setAdapter(simpleAdapter);
                    }
                });

                Log.d(TAG, "完整：" + msg);
//                handler.sendEmptyMessage(1);
                Message msgOne = new Message();
                msgOne.what = 1;
                msgOne.setData(new Bundle());
                // 调用Handle刷新UI，无需管理线程，分开逻辑
                handler.sendMessage(msgOne);
            } else {
                Log.e(TAG, "失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    List<Map<String, Object>> jsonArrayToList(JSONArray jsonArray) throws JSONException {
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = null;
            try {
                obj = (JSONObject) jsonArray.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            assert obj != null;
            String name = obj.getString("name");
            int id = obj.getInt("id");
            Map<String, Object> inMap = new HashMap<>();
            inMap.put("name", name);
            inMap.put("id", id);
            data.add(inMap);
        }
        return data;
    }
}
