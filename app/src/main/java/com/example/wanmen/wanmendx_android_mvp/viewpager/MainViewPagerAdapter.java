package com.example.wanmen.wanmendx_android_mvp.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.wanmen.wanmendx_android_mvp.base.BaseFragment;
import com.example.wanmen.wanmendx_android_mvp.util.ListUtil;

import java.util.List;

/**
 * Created by yangyi on 2017/4/17.
 */

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<BaseFragment> baseFragmentList;

    public MainViewPagerAdapter(FragmentManager fm,
                                List<BaseFragment> baseFragmentList) {
        super(fm);
        this.baseFragmentList = baseFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        if (ListUtil.isInList(baseFragmentList,position)) {
            return baseFragmentList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return ListUtil.getListSize(baseFragmentList);
    }
}
