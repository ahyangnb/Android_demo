package com.example.q1.learning_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LinerAdapter extends RecyclerView.Adapter<LinerAdapter.LinearViewHolder> {

    private Context mContext;

    public LinerAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.linear_item, parent));
    }

    @Override
    public void onBindViewHolder(LinearViewHolder holder, int position) {
        holder.textView.setText("id:::"+position);
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.bt1);
        }
    }
}
