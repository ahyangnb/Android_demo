package com.example.q1.learning_android.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.q1.learning_android.R;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ChatListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Map<String, Object>> mData;

    public ChatListAdapter(Context mContext, List<Map<String, Object>> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);

            TextView txtId = view.findViewById(R.id.id);
            TextView txtName = view.findViewById(R.id.name);

            /// 获取实际数据
            String idValue = (String) mData.get(position).get("id");
            String nameValue = (String) mData.get(position).get("name");

            /// 赋值内容
            txtId.setText("哈" + idValue);
            txtName.setText(nameValue);
        } else {
            view = convertView;
        }


        return view;
    }
}