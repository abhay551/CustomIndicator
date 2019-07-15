package com.abhay.sampleindicator.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.abhay.customindicator.CustomIndicatorView;
import com.abhay.sampleindicator.R;
import com.abhay.sampleindicator.adapter.IndicatorWithRecyclerAdapter;

import java.util.ArrayList;

public class IndicatorWithRecyclerActivity extends AppCompatActivity {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private CustomIndicatorView mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_with_recycler);
        mContext = this;
        mRecyclerView = findViewById(R.id.recycler_view);
        mIndicator = findViewById(R.id.indicator);
        setRecyclerView();
    }

    private ArrayList<String> getDummyList() {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            strings.add("Item " + i);
        }
        return strings;
    }

    private void setRecyclerView() {
        IndicatorWithRecyclerAdapter indicatorWithPagerAdapter = new IndicatorWithRecyclerAdapter(mContext, getDummyList());
        SnapHelper snapHelper = new PagerSnapHelper();
        mRecyclerView.setAdapter(indicatorWithPagerAdapter);
        snapHelper.attachToRecyclerView(mRecyclerView);
        mIndicator.setIndicatorWithSnappyRecyclerView(mRecyclerView, snapHelper);
    }

}