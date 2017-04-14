package com.example.wanmen.wanmendx_android_mvp.show;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RelativeLayout;

import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.data.source.WanmenRepository;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yangyi on 2017/4/12.
 */

public class ShowActivity extends RxAppCompatActivity {

    @BindView(R.id.container_layout)
    RelativeLayout containerLayout;

    private ShowPresenter showPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mvp_root_show);
        ButterKnife.bind(this);

        initFragment();
    }

    private void initFragment() {
        ShowFragment showFragment = ShowFragment.newInstance("这是传递的参数");
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_layout, showFragment, "ShowFragment")
                .commit();

        showPresenter = new ShowPresenter(showFragment,
                WanmenRepository.getInstance());
    }

}
