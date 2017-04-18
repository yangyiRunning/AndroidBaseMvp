package com.example.wanmen.wanmendx_android_mvp.show;

import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.base.BaseFragment;

import butterknife.OnClick;

/**
 * Created by yangyi on 2017/4/17.
 */

public class OtherFragment extends BaseFragment {

    @OnClick(R.id.backLast)
    public void backLast(){
        popFragment();
    }

    public static OtherFragment newInstance(){
        return new OtherFragment();
    }

    @Override
    public void initFragmentData() {

    }

    @Override
    public void initFragmentView() {

    }

    @Override
    public int getFragmentViewId() {
        return R.layout.fragment_other;
    }
}
