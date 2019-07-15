package com.abhay.customindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class IndicatorAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private List<Boolean> mItems;
    private int mFilledSrc, mUnFilledSrc, mWidth, mHeight, mMargin;

    IndicatorAdapter(Context context) {
        this.mContext = context;
        this.mItems = new ArrayList<Boolean>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                      int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_indicator, parent, false);
        return new IndicatorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        boolean isHighlighted = mItems.get(position);
        IndicatorViewHolder indicatorViewHolder = (IndicatorViewHolder) holder;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(mWidth, mHeight);
        layoutParams.setMargins(mMargin, mMargin, mMargin, mMargin);
        indicatorViewHolder.ivIndicator.setLayoutParams(layoutParams);
        indicatorViewHolder.ivIndicator.setLayoutParams(layoutParams);
        if (isHighlighted) {
            indicatorViewHolder.ivIndicator.setImageResource(mFilledSrc);
        } else {
            indicatorViewHolder.ivIndicator.setImageResource(mUnFilledSrc);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class IndicatorViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIndicator;

        IndicatorViewHolder(View itemView) {
            super(itemView);
            ivIndicator = itemView.findViewById(R.id.ivIndicator);
        }
    }

    void setIndicators(int totalIndicatorCount, int highLightedPosition) {
        mItems.clear();
        for (int i = 0; i < totalIndicatorCount; i++) {
            if (i == highLightedPosition)
                mItems.add(true);
            else
                mItems.add(false);
        }
        notifyDataSetChanged();
    }

    void setFilledSrc(int filledSrc) {
        this.mFilledSrc = filledSrc;
    }

    void setUnFilledSrc(int unFilledSrc) {
        this.mUnFilledSrc = unFilledSrc;
    }

    void setWidth(int width) {
        this.mWidth = width;
    }

    void setHeight(int height) {
        this.mHeight = height;
    }

    void setMargin(int margin) {
        this.mMargin = margin;
    }

}