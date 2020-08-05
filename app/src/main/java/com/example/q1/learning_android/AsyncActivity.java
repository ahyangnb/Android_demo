package com.example.q1.learning_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

public class AsyncActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        new ProgressTask();
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
        }

        //作用：接收输入的参数，执行任务中的耗时操作，返回线程任务的执行结果
        @Override
        protected String doInBackground(Void... voids) {
            return null;
        }

        //在主线程中显示任务进度，在doInBackground调用publishProgress触发
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        //接受线程任务的执行结果，将执行结果显示在界面上
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        //取消异步时触发
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}
