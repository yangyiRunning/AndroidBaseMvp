package com.example.wanmen.wanmendx_android_mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;

import com.example.wanmen.wanmendx_android_mvp.manager.ActivityGroupManager;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yangyi on 2017/4/17.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    Unbinder unbinder;

    /**
     * @return activity布局ID
     */
    protected abstract int getContentViewId();

    /**
     * @return activity中装载fragment的布局ID
     */
    protected abstract int getFragmentContainerId();

    /**
     * @return 获取当前的Fragment
     */
    protected abstract BaseFragment getTopFragment();

    /**
     *  初始化View
     */
    protected abstract void initActivityView();

    /**
     * 与P绑定
     */
    protected abstract void initPresenter();

    /**
     * @param baseFragment 替换容器中的Fragment
     */
    public void replaceFragment(BaseFragment baseFragment) {
        if (baseFragment == null) {
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(getFragmentContainerId(),
                        baseFragment,
                        baseFragment.getClass().getSimpleName())
                .addToBackStack(baseFragment.getClass().getSimpleName())
                .commit();
    }

    /**
     * @param fromFragment 从哪里来
     * @param toFragment   跳转至哪里
     *                     添加Fragment到容器中
     */
    public void addFragment(BaseFragment fromFragment, BaseFragment toFragment) {
        if (fromFragment != null && toFragment != null) {
            if (toFragment.isAdded()) {
                getSupportFragmentManager().beginTransaction()
                        .hide(fromFragment)
                        .show(toFragment)
                        .addToBackStack(toFragment.getClass().getSimpleName())
                        .commit();
            } else {
                getSupportFragmentManager().beginTransaction()
                        .hide(fromFragment)
                        .add(getFragmentContainerId(),
                                toFragment,
                                toFragment.getClass().getSimpleName())
                        .addToBackStack(toFragment.getClass().getSimpleName())
                        .commit();
            }
        }
    }

    /**
     * 当Activity中有添加了一个以上Fragment时，返回至上一个Fragment，
     * 当Activity中只有一个Fragment时，结束此activity
     */
    public void popFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentViewId());
        ActivityGroupManager.addActivityToList(this);

        //避免重复添加相同的Fragment
        BaseFragment baseFragment = getTopFragment();
        if (baseFragment != null) {
            replaceFragment(baseFragment);
        }

        unbinder = ButterKnife.bind(this);

        initActivityView();
        initPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ActivityGroupManager.removeActivityFromList(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
