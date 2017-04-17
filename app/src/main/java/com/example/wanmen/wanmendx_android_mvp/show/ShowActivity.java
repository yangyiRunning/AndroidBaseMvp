package com.example.wanmen.wanmendx_android_mvp.show;

import android.widget.RelativeLayout;

import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.base.BaseActivity;
import com.example.wanmen.wanmendx_android_mvp.base.BaseFragment;
import com.example.wanmen.wanmendx_android_mvp.data.source.WanmenRepository;

import butterknife.BindView;

/**
 * Created by yangyi on 2017/4/12.
 */

public class ShowActivity extends BaseActivity {

    private ShowFragment showFragment;

    @BindView(R.id.container_layout)
    RelativeLayout containerLayout;

    @Override
    protected int getContentViewId() {
        return R.layout.mvp_root_show;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.container_layout;
    }

    @Override
    protected BaseFragment getTopFragment() {
        showFragment = ShowFragment.newInstance("这是传递的参数");
        return showFragment;
    }

    @Override
    protected void initActivityView() {
        new ShowPresenter(showFragment,
                WanmenRepository.getInstance());
    }

}
