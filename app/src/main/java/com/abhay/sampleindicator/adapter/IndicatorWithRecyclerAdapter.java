package com.abhay.sampleindicator.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhay.sampleindicator.R;

import java.util.List;

public class IndicatorWithRecyclerAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private List<String> mStringList;

    public IndicatorWithRecyclerAdapter(Context context, List<String> stringList) {
        this.mContext = context;
        this.mStringList = stringList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                      int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.row_pager, parent, false);
        return new IndicatorWithRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String item = mStringList.get(position);
        if (item != null) {
            IndicatorWithRecyclerViewHolder viewHolder = (IndicatorWithRecyclerViewHolder) holder;
            viewHolder.title.setText(item);
        }
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    public static class IndicatorWithRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        IndicatorWithRecyclerViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}