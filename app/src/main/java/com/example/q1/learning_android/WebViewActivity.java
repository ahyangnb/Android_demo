package com.example.q1.learning_android;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    private WebView webId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webId = findViewById(R.id.webId);

        webId.getSettings().setJavaScriptEnabled(true);
        webId.loadUrl("https://m.baidu.com/");
    }
}
