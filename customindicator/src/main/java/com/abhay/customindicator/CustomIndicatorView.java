package com.abhay.customindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

public class CustomIndicatorView extends LinearLayout {

    private final static int DEFAULT_INDICATOR_WIDTH = 10;
    private final static int DEFAULT_INDICATOR_HEIGHT = 10;
    private final static int DEFAULT_INDICATOR_MARGIN = 5;

    private Context mContext;
    private IndicatorAdapter mIndicatorAdapter;
    private int mBgColor, mFilledSrc, mUnFilledSrc, mWidth, mHeight, mMargin, mOrientation = 0;

    private ViewPager mViewPager;
    private RecyclerView mRecyclerView;
    private SnapHelper mSnapHelper;

    private int mDefaultPosition = 0;


    public CustomIndicatorView(Context context) {
        this(context, null);
    }

    public CustomIndicatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readAttrs(attrs);
        init(context);
    }

    private void readAttrs(AttributeSet attrs) {
        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.CustomIndicatorView);
        mBgColor = array.getColor(R.styleable.CustomIndicatorView_indicator_bg_color, Color.TRANSPARENT);
        mFilledSrc = array.getResourceId(R.styleable.CustomIndicatorView_indicator_filled_src, R.drawable.filled_indicator);
        mUnFilledSrc = array.getResourceId(R.styleable.CustomIndicatorView_indicator_unfilled_src, R.drawable.unfilled_indicator);
        mWidth = array.getDimensionPixelSize(R.styleable.CustomIndicatorView_indicator_width, getScaledSize(DEFAULT_INDICATOR_WIDTH));
        mHeight = array.getDimensionPixelSize(R.styleable.CustomIndicatorView_indicator_height, getScaledSize(DEFAULT_INDICATOR_HEIGHT));
        mMargin = array.getDimensionPixelSize(R.styleable.CustomIndicatorView_indicator_margin, getScaledSize(DEFAULT_INDICATOR_MARGIN));
        mOrientation = array.getInt(R.styleable.CustomIndicatorView_indicator_orientation, mOrientation);
        array.recycle();
    }

    private void init(Context context) {
        this.mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.custom_indicator_view, this, true);
        RecyclerView rvIndicator = view.findViewById(R.id.indicator_list);
        view.setBackgroundColor(mBgColor);
        setIndicatorAdapter(rvIndicator);
    }

    private void setIndicatorAdapter(RecyclerView rvIndicator) {
        mIndicatorAdapter = new IndicatorAdapter(mContext);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext, mOrientation, false);
        mIndicatorAdapter.setFilledSrc(mFilledSrc);
        mIndicatorAdapter.setUnFilledSrc(mUnFilledSrc);
        mIndicatorAdapter.setHeight(mHeight);
        mIndicatorAdapter.setWidth(mWidth);
        mIndicatorAdapter.setMargin(mMargin);
        rvIndicator.setLayoutManager(layoutManager);
        rvIndicator.setAdapter(mIndicatorAdapter);
    }

    public void setIndicatorWithViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        if (viewPager != null && viewPager.getAdapter() != null) {
            viewPager.removeOnPageChangeListener(mPageChangeListener);
            viewPager.addOnPageChangeListener(mPageChangeListener);
            mPageChangeListener.onPageSelected(viewPager.getCurrentItem());
        }

    }

    public void setIndicatorWithSnappyRecyclerView(RecyclerView recyclerView, SnapHelper snapHelper) {
        mRecyclerView = recyclerView;
        mSnapHelper = snapHelper;
        if (mRecyclerView != null && mSnapHelper != null) {
            recyclerView.removeOnScrollListener(mOnScrollListener);
            recyclerView.addOnScrollListener(mOnScrollListener);
            if (mRecyclerView.getAdapter() != null) {
                mIndicatorAdapter.setIndicators(mRecyclerView.getAdapter().getItemCount(), mDefaultPosition);
            }
        }
    }

    private final ViewPager.OnPageChangeListener mPageChangeListener =
            new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    if (mViewPager.getAdapter() != null)
                        mIndicatorAdapter.setIndicators(mViewPager.getAdapter().getCount(), position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            };

    private final RecyclerView.OnScrollListener mOnScrollListener =
            new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    int position = getCurrentPosition(recyclerView.getLayoutManager());
                    if (position == RecyclerView.NO_POSITION) {
                        return;
                    }

                    if (mRecyclerView.getAdapter() != null) {
                        mIndicatorAdapter.setIndicators(mRecyclerView.getAdapter().getItemCount(), position);
                    }
                }
            };

    public int getCurrentPosition(@Nullable RecyclerView.LayoutManager layoutManager) {
        if (layoutManager == null) {
            return RecyclerView.NO_POSITION;
        }
        View snapView = mSnapHelper.findSnapView(layoutManager);
        if (snapView == null) {
            return RecyclerView.NO_POSITION;
        }
        return layoutManager.getPosition(snapView);
    }

    private int getScaledSize(int size) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                size, getResources().getDisplayMetrics()));
    }

}
