package com.example.wanmen.wanmendx_android_mvp.main;

import android.support.v4.view.ViewPager;

import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.base.BaseFragment;
import com.example.wanmen.wanmendx_android_mvp.base.BaseViewPagerAdapter;
import com.example.wanmen.wanmendx_android_mvp.data.tab.TitleTabEntity;
import com.example.wanmen.wanmendx_android_mvp.dowload.AlreadyDownloadFragment;
import com.example.wanmen.wanmendx_android_mvp.dowload.NoDownloadFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yangyi on 2017/4/17.
 */

public class DownFragment extends BaseFragment {

    @BindView(R.id.downloadCommonTabLayout)
    CommonTabLayout downloadCommonTabLayout;
    @BindView(R.id.downloadViewPager)
    ViewPager downloadViewPager;

    @Override
    public void initFragmentData() {

    }

    @Override
    public void initFragmentView() {
        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(AlreadyDownloadFragment.newInstance());
        fragmentList.add(NoDownloadFragment.newInstance());

        ArrayList<CustomTabEntity> tabEntitys = new ArrayList<>();
        tabEntitys.add(new TitleTabEntity("已下载"));
        tabEntitys.add(new TitleTabEntity("未下载"));
        downloadCommonTabLayout.setTabData(tabEntitys);

        downloadViewPager.setAdapter(new BaseViewPagerAdapter(getChildFragmentManager(),
                fragmentList));

        downloadViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                downloadCommonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        downloadCommonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                downloadViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

    }

    @Override
    public int getFragmentViewId() {
        return R.layout.fragment_download;
    }

    public static DownFragment newInstance(){
        return new DownFragment();
    }
}
