package com.example.q1.learning_android;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ThisDialog extends AppCompatActivity {

    private Button oneDialog;
    private Button tow_dialog;
    private Button three_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_this_dialog);
        oneDialog = findViewById(R.id.one_dialog);
        tow_dialog = findViewById(R.id.tow_dialog);
        three_dialog = findViewById(R.id.three_dialog);

        oneDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ThisDialog.this);
                builder.setNegativeButton("取消", null);
                builder.setTitle("这是标题");
                builder.setMessage("你确定到推出程序吗");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
            }
        });

        tow_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog myDialog = new MyDialog(ThisDialog.this);
                myDialog.show();
            }
        });

        three_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow(findViewById(R.id.three_dialog));
            }
        });
    }

    private void showPopWindow(View view) {
        View v = LayoutInflater.from(this).inflate(R.layout.activity_my_dialog,null);

        PopupWindow window = new PopupWindow(v,290,155,true);

        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        window.setOutsideTouchable(true);

//        window.setAnimationStyle();

        window.showAsDropDown(view,100,20);
    }


}
