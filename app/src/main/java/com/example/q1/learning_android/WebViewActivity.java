package com.example.q1.learning_android;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {

    private WebView webId;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webId = findViewById(R.id.webId);

        webId.getSettings().setJavaScriptEnabled(true);
        webId.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return true;
            }
        });

        webId.loadUrl("http://ip.wfsid.vip/app/index.php?i=2&c=entry&do=index&m=fy_lessonv2&wxref=mp.weixin.qq.com&uid=30979");
//        webId.loadUrl("http://m.jiaoyu.duoweizi.net");
    }

    @Override
    public void onBackPressed() {
        Log.e("Q1", "onBackPressed");
        if (webId.canGoBack()) {
            Log.e("Q1", "canGoBack");
            webId.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
