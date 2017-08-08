package com.vishal.recyclerviewtest;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.vishal.recyclerviewtest.adapter.MyRecyclerViewAdapter;
import com.vishal.recyclerviewtest.listener.MyCustomClickListener;
import com.vishal.recyclerviewtest.listener.RecyclerTouchListner;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    RecyclerView recyclerView;
    RadioGroup containerRadioGroup;
    RadioButton linearRadioButton, gridRadioButton;

    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        containerRadioGroup = (RadioGroup) findViewById(R.id.container_rg);
        linearRadioButton = (RadioButton) findViewById(R.id.list_rb);
        gridRadioButton = (RadioButton) findViewById(R.id.grid_rb);

        containerRadioGroup.setOnCheckedChangeListener(this);

        linearRadioButton.setChecked(true);
        gridRadioButton.setChecked(false);

        linearLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        String[] countryList = getResources().getStringArray(R.array.countries);
        String[] countryFlag = getResources().getStringArray(R.array.country_codes);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, countryList, countryFlag);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListner(this, recyclerView, new MyCustomClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Single Click on position : " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Long Click on position : " + position, Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        if(linearRadioButton.isChecked()) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        else if(gridRadioButton.isChecked()) {
            recyclerView.setLayoutManager(gridLayoutManager);
        }
    }

//    public static interface ClickListener {
//
//        void onClick(View view, int position);
//        void onLongClick(View view, int position);
//    }
}
