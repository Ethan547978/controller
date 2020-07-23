package com.app.controller.utils;

import com.app.controller.exception.ClientException;
import com.app.library.utils.BuglyLogUtils;
import com.app.library.utils.LogUtils;

/**
 * Created by Jackie on 23,八月,2017
 */

public class ExceptionLogUtils {
    
    public static void postCatchedException(String tag, String log, Throwable throwable) {
        LogUtils.e(tag,log);
        BuglyLogUtils.postCatchedException(throwable);
    }

    public static void postCatchedException(String tag, String log) {
        BuglyLogUtils.postCatchedException(new ClientException(log));
        LogUtils.e(tag,log);
    }
}
