package com.example.q1.learning_android.widget;

import static android.view.MotionEvent.ACTION_MOVE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

import androidx.annotation.RequiresApi;

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    //    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return false;
//    }
//
//    @SuppressLint("ClickableViewAccessibility")
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        Log.d("Q1", "evev::" + ev.toString());
////        if (ev.getAction() == ACTION_MOVE) {
////            scrollBy(0, (int) ev.getY());
////        }
//
//        int top = getTop();
//        float y = ev.getY();
//
//        if(y >= top){
//                                            scrollBy(0,(int) y - top);
//        }
//
//        return true;
//
//    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.d("Q1","dispatchTouchEvent:::"+ev.toString());
//        return true;
//    }

//    @Override
//    public boolean onInterceptHoverEvent(MotionEvent event) {
//        return true;
//    }
}
