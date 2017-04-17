package com.example.wanmen.wanmendx_android_mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yangyi on 2017/4/17.
 */

public abstract class BaseFragment extends Fragment {

    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    private BaseActivity baseActivity;
    private Unbinder unbinder;

    public BaseActivity getBaseActivity() {
        return baseActivity;
    }

    /**
     * 初始化Fragment的布局
     */
    public abstract void initFragmentView();

    /**
     * @return fragment的布局视图
     */
    public abstract int getFragmentViewId();

    /**
     * 替换Fragment
     */
    protected void replaceFragment(BaseFragment fragment) {
        if (null != fragment) {
            getBaseActivity().replaceFragment(fragment);
        }
    }

    /**
     * 添加Fragment
     */
    protected void addFragment(BaseFragment fromFragment, BaseFragment toFragment) {
        if (fromFragment != null && toFragment != null) {
            if (!toFragment.isAdded()) {
                getBaseActivity().addFragment(fromFragment, toFragment);
            }
        }
    }

    /**
     * 移除Fragment
     */
    public void popFragment() {
        getBaseActivity().popFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        baseActivity = (BaseActivity) getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            boolean isHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            if (isHidden) {
                fragmentTransaction.hide(BaseFragment.this);
            } else {
                fragmentTransaction.show(BaseFragment.this);
            }
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(getFragmentViewId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initFragmentView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }
}
