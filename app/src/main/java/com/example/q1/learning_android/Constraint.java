package com.example.q1.learning_android;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.q1.learning_android.model.Food;
import com.example.q1.learning_android.model.FoodType;
import com.example.q1.learning_android.model.Person;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Constraint extends AppCompatActivity {

    private EditText name_edit;
    private RadioGroup sexRadioGroup;
    private CheckBox fish;
    private CheckBox sauerkraut;
    private CheckBox hot;
    private SeekBar seek;
    private ToggleButton find;
    private ToggleButton next;

    private int currentIndex;

    List<Food> dataList;
    List<Food> foodResult;

    Person mPerson;
    FoodType type;
    int pricePro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        // 初始化控件
        findViews();

        // 初始化数据
        initData();

        // 为控件添加监听器
        setListeners();

        // 自测
    }

    private void setListeners() {
        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.male:
                        mPerson.setSex("男");
                        break;
                    case R.id.feMale:
                        mPerson.setSex("女");
                        break;
                }
            }
        });

        fish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                type = FoodType.fish;
            }
        });

        hot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                type = FoodType.hot;
            }
        });

        sauerkraut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                type = FoodType.sour;
            }
        });

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                pricePro = seekBar.getProgress();
                Toast.makeText(Constraint.this, "价格" + pricePro, Toast.LENGTH_SHORT).show();
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (next.isChecked()) {
                    currentIndex++;
                } else {
                    if (currentIndex < foodResult.size()) {
                        Toast.makeText(Constraint.this, "你选择的菜品是：" + foodResult.get(currentIndex).getName(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Constraint.this, "没有啦", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void search() {
        // 如果符合条件则加入到我们的列表中

        // 如果为空，则初始化
        if (foodResult == null) {
            foodResult = new ArrayList<>();
        }

        // 结果列表每次都清空
        foodResult.clear();
        currentIndex = 0;

        // 遍历所有菜
        for (int i = 0; i < dataList.size(); i++) {
            Food food = dataList.get(i);
            if (food.getPrice() < pricePro && food.getType() == type) {
                foodResult.add(food);
            }
        }


    }

    private void initData() {
        dataList = new ArrayList<>();
        dataList.add(new Food("菜名231", 100, R.drawable.ic_launcher_foreground, FoodType.fish));
        dataList.add(new Food("菜3名2", 10, R.drawable.ic_launcher_foreground, FoodType.hot));
        dataList.add(new Food("菜232名3", 30, R.drawable.ic_launcher_foreground, FoodType.sour));
        dataList.add(new Food("菜名32234", 60, R.drawable.ic_launcher_foreground, FoodType.fish));
        dataList.add(new Food("菜名s6", 80, R.drawable.ic_launcher_foreground, FoodType.hot));
        dataList.add(new Food("菜名w8", 1200, R.drawable.ic_launcher_foreground, FoodType.fish));
        dataList.add(new Food("菜d名1", 100, R.drawable.ic_launcher_foreground, FoodType.fish));
        dataList.add(new Food("菜d名223", 10, R.drawable.ic_launcher_foreground, FoodType.hot));
        dataList.add(new Food("菜d名43", 30, R.drawable.ic_launcher_foreground, FoodType.sour));
        dataList.add(new Food("菜d名4", 60, R.drawable.ic_launcher_foreground, FoodType.fish));
        dataList.add(new Food("菜23名6", 80, R.drawable.ic_launcher_foreground, FoodType.hot));
        dataList.add(new Food("菜w3名8", 1200, R.drawable.ic_launcher_foreground, FoodType.fish));

        mPerson = new Person();
        foodResult = new ArrayList<>();
    }

    private void findViews() {
        name_edit = findViewById(R.id.name_edit);
        sexRadioGroup = findViewById(R.id.sexRadioGroup);
        fish = findViewById(R.id.fish);
        sauerkraut = findViewById(R.id.sauerkraut);
        hot = findViewById(R.id.hot);
        seek = findViewById(R.id.seek);
        seek.setProgress(30);
        find = findViewById(R.id.find);
        find.setChecked(true);
        next = findViewById(R.id.next);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.option, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
