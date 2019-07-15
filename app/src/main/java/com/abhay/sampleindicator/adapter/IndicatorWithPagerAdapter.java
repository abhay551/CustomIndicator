package com.abhay.sampleindicator.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.abhay.sampleindicator.R;

import java.util.List;

public class IndicatorWithPagerAdapter extends PagerAdapter {

    private Context mContext;
    private List<String> mStringList;
    private LayoutInflater mLayoutInflator;

    public IndicatorWithPagerAdapter(Context context, List<String> stringList) {
        this.mContext = context;
        this.mStringList = stringList;
        mLayoutInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        View itemView = mLayoutInflator.inflate(R.layout.row_pager, container, false);
        TextView title = itemView.findViewById(R.id.title);
        title.setText(mStringList.get(position));
        container.addView(itemView);
        return itemView;
    }

    @Override
    public int getCount() {
        return mStringList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((View) object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}