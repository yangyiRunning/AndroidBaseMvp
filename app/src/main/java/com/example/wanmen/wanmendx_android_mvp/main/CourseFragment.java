package com.example.wanmen.wanmendx_android_mvp.main;

import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.base.BaseFragment;

/**
 * Created by yangyi on 2017/4/17.
 */

public class CourseFragment extends BaseFragment {
    @Override
    public void initFragmentView() {

    }

    @Override
    public int getFragmentViewId() {
        return R.layout.fragment_course;
    }

    public static CourseFragment newInstance(){
        return new CourseFragment();
    }
}
