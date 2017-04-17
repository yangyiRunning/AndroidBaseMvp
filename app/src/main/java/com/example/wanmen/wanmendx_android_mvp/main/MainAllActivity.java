package com.example.wanmen.wanmendx_android_mvp.main;

import android.support.v4.view.ViewPager;

import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.base.BaseActivity;
import com.example.wanmen.wanmendx_android_mvp.base.BaseFragment;
import com.example.wanmen.wanmendx_android_mvp.tab.TabEntity;
import com.example.wanmen.wanmendx_android_mvp.viewpager.MainViewPagerAdapter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yangyi on 2017/4/17.
 */

public class MainAllActivity extends BaseActivity {

    @BindView(R.id.tabLayout)
    CommonTabLayout commonTabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main_page;
    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }

    @Override
    protected BaseFragment getTopFragment() {
        return null;
    }

    @Override
    protected void initActivityView() {
        ArrayList<CustomTabEntity> tabEntities = new ArrayList<>();

        tabEntities.add(new TabEntity(getString(R.string.main), R.mipmap.ic_main_selected, R.mipmap.ic_main_normal));
        tabEntities.add(new TabEntity(getString(R.string.course), R.mipmap.ic_course_selected, R.mipmap.ic_course_normal));
        tabEntities.add(new TabEntity(getString(R.string.search_title), R.mipmap.ic_search_selected, R.mipmap.ic_search_normal));
        tabEntities.add(new TabEntity(getString(R.string.download_title), R.mipmap.ic_down_selected, R.mipmap.ic_down_normal));
        tabEntities.add(new TabEntity(getString(R.string.my_title), R.mipmap.ic_my_selected, R.mipmap.ic_my_normal));

        List<BaseFragment> fragmentList = new ArrayList<>();
        fragmentList.add(MainFragment.newInstance());
        fragmentList.add(CourseFragment.newInstance());
        fragmentList.add(SearchFragment.newInstance());
        fragmentList.add(DownFragment.newInstance());
        fragmentList.add(MyFragment.newInstance());

        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(),fragmentList));
        viewPager.setOffscreenPageLimit(fragmentList.size());

        commonTabLayout.setTabData(tabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPager.setCurrentItem(0);
        commonTabLayout.showDot(4);
    }

    @Override
    protected void initPresenter() {

    }
}
