package com.example.wanmen.wanmendx_android_mvp.manager;

import com.example.wanmen.wanmendx_android_mvp.base.BaseActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yangyi on 2017/4/17.
 */

public class ActivityGroupManager {

    private static List<BaseActivity> activityList = new LinkedList<>();

    public static List<BaseActivity> getActivityList() {
        return activityList;
    }

    public static void addActivityToList(BaseActivity baseActivity) {
        activityList.add(baseActivity);
    }

    public static void removeActivityFromList(BaseActivity baseActivity) {
        activityList.remove(baseActivity);
    }

    public static BaseActivity getTopActivityInList() {
        if (!activityList.iterator().hasNext()) {
            return null;
        }
        return activityList.iterator().next();
    }

    public static void exitApp() {
        if (activityList != null && activityList.size() != 0) {
            for (BaseActivity baseActivity : activityList) {
                if (!baseActivity.isFinishing()) {
                    baseActivity.finish();
                }
            }
        }

        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
