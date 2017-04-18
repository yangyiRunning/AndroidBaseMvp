package com.example.wanmen.wanmendx_android_mvp.main;

import android.support.v4.view.ViewPager;

import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.base.BaseFragment;
import com.example.wanmen.wanmendx_android_mvp.course.HighSchoolFragment;
import com.example.wanmen.wanmendx_android_mvp.course.LanguageFragment;
import com.example.wanmen.wanmendx_android_mvp.course.UniversityFragment;
import com.example.wanmen.wanmendx_android_mvp.data.tab.TitleTabEntity;
import com.example.wanmen.wanmendx_android_mvp.base.BaseViewPagerAdapter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by yangyi on 2017/4/17.
 */

public class CourseFragment extends BaseFragment {

    @BindView(R.id.courseCommonTabLayout)
    CommonTabLayout courseCommonTabLayout;
    @BindView(R.id.courseViewPager)
    ViewPager courseViewPager;

    private List<BaseFragment> baseFragmentList;

    @Override
    public void initFragmentData() {

    }

    @Override
    public void initFragmentView() {
        baseFragmentList = new ArrayList<>();
        baseFragmentList.add(LanguageFragment.newInstance());
        baseFragmentList.add(UniversityFragment.newInstance());
        baseFragmentList.add(HighSchoolFragment.newInstance());
        courseViewPager.setAdapter(new BaseViewPagerAdapter(
                getChildFragmentManager(), baseFragmentList));

        ArrayList<CustomTabEntity> courseTabEntityArrayList = new ArrayList<>();
        courseTabEntityArrayList.add(new TitleTabEntity("语言"));
        courseTabEntityArrayList.add(new TitleTabEntity("大学"));
        courseTabEntityArrayList.add(new TitleTabEntity("高中"));
        courseCommonTabLayout.setTabData(courseTabEntityArrayList);

        courseCommonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                courseViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        courseViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                courseCommonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        courseViewPager.setCurrentItem(0);
    }

    @Override
    public int getFragmentViewId() {
        return R.layout.fragment_course;
    }

    public static CourseFragment newInstance() {
        return new CourseFragment();
    }
}
