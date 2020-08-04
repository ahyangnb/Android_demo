package com.example.q1.learning_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RecyClerView extends AppCompatActivity {

    //    private RecyclerView rc1;
    private Button result_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_cler_view);
        result_code = findViewById(R.id.result_code);
        result_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.putExtra("msg","这是带过去的数据");
                String msg = it.getStringExtra("msg");
                Log.e("CrazyQ1",msg);
                setResult(Activity.RESULT_OK, it);
                finish();
            }
        });
//        rc1 = findViewById(R.id.rc1);
//        rc1.setLayoutManager(new LinearLayoutManager(RecyClerView.this));
//        rc1.setAdapter(new LinerAdapter(RecyClerView.this));
    }
}
