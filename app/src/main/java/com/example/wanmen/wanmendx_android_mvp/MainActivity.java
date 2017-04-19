package com.example.wanmen.wanmendx_android_mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.wanmen.wanmendx_android_mvp.main.MainAllActivity;
import com.example.wanmen.wanmendx_android_mvp.show.ShowActivity;
import com.example.wanmen.wanmendx_android_mvp.view.ErrorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yangyi on 2017/4/12.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.errorView)
    ErrorView errorView;

    @OnClick(R.id.mvp_button)
    void gotoMvpActivity() {
        startActivity(new Intent(this, ShowActivity.class));
    }

    @OnClick(R.id.goto_main_button)
    void gotoMainPager() {
        startActivity(new Intent(this, MainAllActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        errorView.setOnRefreshDataListener(new ErrorView.OnRefreshDataListener() {
            @Override
            public void onRefreshData() {
                Toast.makeText(getApplicationContext(), "可以更新了", Toast.LENGTH_SHORT).show();
                errorView.getErrorSwipe().setRefreshing(false);
            }
        });

    }

}
