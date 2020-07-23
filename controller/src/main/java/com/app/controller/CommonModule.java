package com.app.controller;


import android.app.Application;
import android.content.Context;

import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadLog;


public class CommonModule {

    private static Context sAppContext;
    private static Application sApplication;
    public static Boolean isDebug = null;

    public static void init(Application application, boolean isdebug) {
        if (sApplication == null) {
            sApplication = application;
            sAppContext = application.getApplicationContext();
        }
        if (sAppContext == null) {

        }
        isDebug = isdebug;
        initDownloadManager();
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static Application getApplication() {
        return sApplication;
    }

    private static void initDownloadManager() {
        FileDownloadLog.NEED_LOG = isDebug;
        FileDownloader.setup(getAppContext());
    }


}
