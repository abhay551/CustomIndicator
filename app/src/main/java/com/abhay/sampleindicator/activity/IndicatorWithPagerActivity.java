package com.abhay.sampleindicator.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.abhay.customindicator.CustomIndicatorView;
import com.abhay.sampleindicator.R;
import com.abhay.sampleindicator.adapter.IndicatorWithPagerAdapter;

import java.util.ArrayList;

public class IndicatorWithPagerActivity extends AppCompatActivity {

    private Context mContext;
    private ViewPager mViewPager;
    private CustomIndicatorView mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator_with_pager);
        mContext = this;
        mViewPager = findViewById(R.id.view_pager);
        mIndicator = findViewById(R.id.indicator);
        setPagerAdapter();
    }

    private ArrayList<String> getDummyList(){
        ArrayList<String> strings = new ArrayList<>();
        for (int i=1;i<=10;i++){
            strings.add("Item "+i);
        }
        return strings;
    }

    private void setPagerAdapter(){
        IndicatorWithPagerAdapter indicatorWithPagerAdapter = new IndicatorWithPagerAdapter(mContext,getDummyList());
        mViewPager.setAdapter(indicatorWithPagerAdapter);
        mIndicator.setIndicatorWithViewPager(mViewPager);
    }


}