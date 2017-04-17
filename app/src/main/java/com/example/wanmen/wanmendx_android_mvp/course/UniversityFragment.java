package com.example.wanmen.wanmendx_android_mvp.course;

import com.example.wanmen.wanmendx_android_mvp.R;
import com.example.wanmen.wanmendx_android_mvp.base.BaseFragment;

/**
 * Created by yangyi on 2017/4/17.
 */

public class UniversityFragment extends BaseFragment {

    @Override
    public void initFragmentView() {

    }

    @Override
    public int getFragmentViewId() {
        return R.layout.fragment_university;
    }

    public static UniversityFragment newInstance(){
        return new UniversityFragment();
    }
}
