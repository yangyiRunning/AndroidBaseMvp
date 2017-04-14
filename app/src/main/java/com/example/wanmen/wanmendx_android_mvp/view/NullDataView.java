package com.example.wanmen.wanmendx_android_mvp.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wanmen.wanmendx_android_mvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/** Created by yangyi on 2017/4/13. */
public class NullDataView extends LinearLayout {

    @BindView(R.id.nullDataSwipe)
    SwipeRefreshLayout nullDataSwipe;

    @BindView(R.id.nullDataImg)
    ImageView nullDataImg;

    @BindView(R.id.nullDataText)
    TextView nullDataText;

    @OnClick(R.id.nullDataLayout)
    void refresh() {
        onNullDataLayoutClickListener.onNullDataLayoutClickListener();
    }

    private OnRefreshDataListener onRefreshDataListener;
    private OnNullDataLayoutClickListener onNullDataLayoutClickListener;

    public interface OnRefreshDataListener {
        void onRefreshData();
    }

    public interface OnNullDataLayoutClickListener {
        void onNullDataLayoutClickListener();
    }

    public void setOnRefreshDataListener(@NonNull OnRefreshDataListener onRefreshDataListener) {
        this.onRefreshDataListener = onRefreshDataListener;
    }

    public void setOnNullDataLayoutClickListener(
            @NonNull OnNullDataLayoutClickListener onNullDataLayoutClickListener) {
        this.onNullDataLayoutClickListener = onNullDataLayoutClickListener;
    }

    private Unbinder unbinder;

    public NullDataView(Context context) {
        super(context);
        initView();
    }

    public NullDataView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public NullDataView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_null_data, this, true);
        unbinder = ButterKnife.bind(this, view);

        nullDataSwipe.setColorSchemeColors(Color.BLACK);
        nullDataSwipe.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        if (onRefreshDataListener != null) {
                            onRefreshDataListener.onRefreshData();
                        }
                    }
                });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unbinder.unbind();
    }

    public SwipeRefreshLayout getNullDataSwipe() {
        return nullDataSwipe;
    }

    public TextView getNullDataText() {
        return nullDataText;
    }

    public ImageView getNullDataImg() {
        return nullDataImg;
    }

}
