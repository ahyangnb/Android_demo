package com.example.q1.learning_android;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

public class MyDialog extends Dialog {

    public MyDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.activity_my_dialog);
    }
}
