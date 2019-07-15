package com.abhay.sampleindicator.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.abhay.sampleindicator.R;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    private Button btIndicatorWithPager, btIndicatorWithRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        btIndicatorWithPager = findViewById(R.id.indicator_with_pager);
        btIndicatorWithRecyclerView = findViewById(R.id.indicator_with_recyclerview);
        btIndicatorWithPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, IndicatorWithPagerActivity.class));
            }
        });
        btIndicatorWithRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, IndicatorWithRecyclerActivity.class));
            }
        });

    }
}
