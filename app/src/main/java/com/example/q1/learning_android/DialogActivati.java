package com.example.q1.learning_android;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DialogActivati extends AppCompatActivity {

    private Button dialog_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_activati);
        dialog_bt = findViewById(R.id.dialog_bt);

        findViewById(R.id.dialog_bt).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActionMode(cb);
                return false;
            }
        });

        registerForContextMenu(findViewById(R.id.dialog_bt));

        dialog_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContextMenu(v);
            }
        });

    }

    ActionMode.Callback cb = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.option, menu);
            Log.e("CrazyQ1", "create");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            Log.e("CrazyQ1", "create1");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Log.e("CrazyQ1", "create2");
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            Log.e("CrazyQ1", "create3");
        }
    };

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.c:
                Toast.makeText(this, "CC", Toast.LENGTH_SHORT).show();
                break;
            case R.id.save:
                Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "当前ID：：" + item.getItemId(), Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.option, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
