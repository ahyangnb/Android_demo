package com.example.q1.learning_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static java.lang.Thread.sleep;

public class AsyncActivity extends AppCompatActivity {

    private TextView txt;
    private Button start;
    private Button end;
    private ProgressBar progress;
    private ProgressTask pTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        //寻找id
        findId();

        //按钮监听
        start.setOnClickListener(new MyOnClickListener());
        end.setOnClickListener(new MyOnClickListener());

        pTask = new ProgressTask();
    }

    /*
     * 按钮监听类
     *
     * */
    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            try {
                switch (v.getId()) {
                    case R.id.start:
                        pTask.execute();
                        break;
                    case R.id.end:
                        pTask.cancel(true);
                        break;
                }
            } catch (Exception ignored) {
            }
        }
    }

    /*
     * 寻找Id
     *
     * */
    void findId() {
        txt = findViewById(R.id.txt);
        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        progress = findViewById(R.id.progress);
    }

    /*
     * Params：execute方法的参数类型，doInBackground方法的参数类型
     * Progress：进度，Integer
     * Result
     * */
    @SuppressLint("StaticFieldLeak")
    class ProgressTask extends AsyncTask<Void, Integer, String> {

        //执行线程任务之前的操作
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txt.setText("等待开始");
        }

        //作用：接收输入的参数，执行任务中的耗时操作，返回线程任务的执行结果
        @Override
        protected String doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 100; i++) {
                    sleep(50);
                    publishProgress(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        //在主线程中显示任务进度，在doInBackground调用publishProgress触发
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Integer progressValue = values[0];
            txt.setText("加载" + progressValue);
            progress.setProgress(progressValue);
        }

        //接受线程任务的执行结果，将执行结果显示在界面上
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txt.setText("加载完成");
        }

        //取消异步时触发
        @Override
        protected void onCancelled() {
            super.onCancelled();
            txt.setText("操作取消");
        }
    }
}
