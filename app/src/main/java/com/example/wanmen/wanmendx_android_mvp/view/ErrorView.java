package com.example.wanmen.wanmendx_android_mvp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wanmen.wanmendx_android_mvp.R;

/**
 * Created by yangyi on 2017/4/13.
 * <p>
 * //library中不能用butterKnife注入，注入时的ID必须为常量，library的ID为变量
 */
public class ErrorView extends LinearLayout {

    private SwipeRefreshLayout errorSwipe;

    private ImageView errorImg;

    private TextView errorText;

    private LinearLayout errorLayout;

    private Integer netErrorImgResource, nullDataImgResource;

    private String netErrorText, nullDataText;

    private OnRefreshDataListener onRefreshDataListener;

    public interface OnRefreshDataListener {
        void onRefreshData();
    }

    public void setOnRefreshDataListener(@NonNull OnRefreshDataListener onRefreshDataListener) {
        this.onRefreshDataListener = onRefreshDataListener;
    }

    public ErrorView(Context context) {
        super(context);
        initView();
        initClick();
    }

    public ErrorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
        initView();
        initClick();
    }

    public ErrorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
        initView();
        initClick();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray as = getContext().obtainStyledAttributes(attrs, R.styleable.error);
        netErrorImgResource = as.getResourceId(R.styleable.error_netErrorImgResource, -1);
        netErrorText = as.getString(R.styleable.error_netErrorText);
        nullDataImgResource = as.getResourceId(R.styleable.error_nullDataImgResource, -1);
        nullDataText = as.getString(R.styleable.error_nullDataText);
        as.recycle();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_error, this, true);
        errorSwipe = (SwipeRefreshLayout) view.findViewById(R.id.errorSwipe);
        errorImg = (ImageView) view.findViewById(R.id.errorImg);
        errorText = (TextView) view.findViewById(R.id.errorText);
        errorLayout = (LinearLayout) view.findViewById(R.id.errorLayout);

        if (nullDataImgResource != -1) {
            errorImg.setImageResource(nullDataImgResource);
        }
        if (!"".equals(nullDataText)) {
            errorText.setText(nullDataText);
        }
        if (netErrorImgResource != -1) {
            errorImg.setImageResource(netErrorImgResource);
        }
        if (!"".equals(netErrorText)) {
            errorText.setText(netErrorText);
        }
    }

    private void initClick() {
        errorSwipe.setColorSchemeColors(
                ContextCompat.getColor(getContext(), R.color.blue_03A9F4),
                ContextCompat.getColor(getContext(), R.color.gray_85929E),
                ContextCompat.getColor(getContext(), R.color.white_255));
        errorSwipe.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        if (onRefreshDataListener != null) {
                            onRefreshDataListener.onRefreshData();
                        }
                    }
                });

        errorLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onRefreshDataListener != null) {
                    onRefreshDataListener.onRefreshData();
                }
            }
        });
    }

    private void destroyView() {
        errorSwipe = null;
        errorImg = null;
        errorText = null;
        errorLayout = null;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        destroyView();
    }

    public SwipeRefreshLayout getErrorSwipe() {
        return errorSwipe;
    }

    public TextView getErrorText() {
        return errorText;
    }

    public ImageView getErrorImg() {
        return errorImg;
    }

}
