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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_this_dialog);

        //寻找组件id并绑定
        Button oneDialog = findViewById(R.id.one_dialog);
        Button tow_dialog = findViewById(R.id.tow_dialog);
        Button three_dialog = findViewById(R.id.three_dialog);

        //注册监听
        oneDialog.setOnClickListener(new InnerOnClickListener());
        tow_dialog.setOnClickListener(new InnerOnClickListener());
        three_dialog.setOnClickListener(new InnerOnClickListener());
    }

    private class InnerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.one_dialog:
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
                    break;
                case R.id.tow_dialog:
                    MyDialog myDialog = new MyDialog(ThisDialog.this);
                    myDialog.show();
                    break;
                case R.id.three_dialog:
                    showPopWindow(findViewById(R.id.three_dialog));
                    break;
            }
        }
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
