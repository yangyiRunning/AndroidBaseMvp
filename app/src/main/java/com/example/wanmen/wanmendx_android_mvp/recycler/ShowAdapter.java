package com.example.wanmen.wanmendx_android_mvp.recycler;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.data.WanmenData;

import java.util.List;

/**
 * Created by yangyi on 2017/4/13.
 */

public class ShowAdapter extends BaseQuickAdapter<WanmenData, BaseViewHolder> {

    public ShowAdapter(int layoutResId, List<WanmenData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WanmenData item) {
        helper.setText(R.id.showText, item.getCourse().getName());
    }
}
