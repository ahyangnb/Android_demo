package com.example.q1.learning_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class TimerActivity extends AppCompatActivity {
    private boolean flag = false;

    private Button start_bt;
    private TextView cont;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (!flag) {
                start_bt.setText("开始");
                return;
            }

            int arg1 = msg.arg1;

            int secondInt = arg1 % 60;
            String second = secondInt > 9 ? String.valueOf(secondInt) : "0" + secondInt;

            int minInt = arg1 / 60;
            String min = minInt > 9 ? String.valueOf(minInt) : "0" + minInt;

            int hourInt = minInt / 60;
            String hour = hourInt > 9 ? String.valueOf(hourInt) : "0" + hourInt;

            String result = hour + ":" + min + ":" + second;
            cont.setText(result);
            start_bt.setText("暂停");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        start_bt = findViewById(R.id.start_bt);
        cont = findViewById(R.id.cont);

        start_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHandle();
            }
        });
    }

    void startHandle() {
        flag = !flag;
        new Thread() {
            @Override
            public void run() {
                super.run();
                int i = -1;
                while (flag) {
                    try {
                        i++;
                        Message msg = new Message();
                        msg.arg1 = i;
                        handler.sendMessage(msg);
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
