package com.example.q1.learning_android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Progress extends AppCompatActivity {

    private Button start;
    private Button progressDialog;
    private Button progressDownLoadDialog;
    private ProgressBar p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        start = findViewById(R.id.start);
        progressDialog = findViewById(R.id.progressDialog);
        progressDownLoadDialog = findViewById(R.id.progressDownLoadDialog);
        p2 = findViewById(R.id.p2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        progressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog = new ProgressDialog(Progress.this);
                dialog.setMessage("加载中");
                dialog.setTitle("提示");
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(Progress.this, "Cancel", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.show();
            }
        });
        progressDownLoadDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog = new ProgressDialog(Progress.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setTitle("下载");
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(Progress.this, "取消下载", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.show();
            }
        });

//        final Handler handler = new Handler(){
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                if(p2.getProgress()<100){
//                    handler.postDelayed();
//                }else {
//                    Toast.makeText(this,"",Toast.LENGTH_LONG);
//                }
//            }
//        };
    }
}
