package com.example.wanmen.wanmendx_android_mvp.util;

import java.util.List;

/**
 * Created by yangyi on 2017/4/17.
 */

public class ListUtil {

    public static boolean isEmpty(List list) {
        if (list == null && list.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isInList(List list, int postion) {

        if (isEmpty(list)) {
            return false;
        }
        if (list.size() > postion) {
            return true;
        }
        return false;
    }

    public static int getListSize(List list) {

        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
