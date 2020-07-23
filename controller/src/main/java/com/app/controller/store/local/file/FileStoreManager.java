package com.app.controller.store.local.file;

import android.os.Environment;
import com.app.controller.CommonModule;

import com.app.controller.account.Account;
import com.app.library.utils.EnvironmentUtils;


import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * Description : File store
 * Creator : ZST
 * Data : 2017/8/25.
 */
public class FileStoreManager {
    private Account mAccount;
    private long mLastCalculateCacheTime = 0;
    private long mLastCalculateCacheSize = 0;

    public FileStoreManager(Account account) {
        mAccount = account;
    }

    public long calculateCacheSize(boolean hasCache) {
        long currentMills = System.currentTimeMillis();
        //当前时间比上次检查时间长5分钟则再次计算，否则直接返回上次结果
        if (hasCache && mLastCalculateCacheSize > 0 && currentMills - mLastCalculateCacheTime > 1000 * 60 * 5L) {
            return mLastCalculateCacheSize;
        }

        File cacheDir = getTmpDir(false, true, null);
        if (cacheDir != null && cacheDir.exists()) {
            long size = FileUtils.sizeOfDirectory(cacheDir) / 3;
            mLastCalculateCacheTime = currentMills;
            mLastCalculateCacheSize = size;
            return size;
        } else {
            return 0;
        }
    }

    public void clearFileCache() {
        File cacheDir = getTmpDir(false, true, null);
        if (cacheDir != null) {
            File newCacheDir = new File(cacheDir.getAbsolutePath() + "_" + System.currentTimeMillis());
            if (cacheDir.renameTo(newCacheDir)) {
                FileUtils.deleteQuietly(newCacheDir);
                mLastCalculateCacheTime = 0;
                mLastCalculateCacheSize = 0;
            }
        }
    }

    public void clearImageFileCache() {
        File cacheDir = getImageProcessCacheDir();
        if (cacheDir != null) {
            File newCacheDir = new File(cacheDir.getAbsolutePath() + "_" + System.currentTimeMillis());
            if (cacheDir.renameTo(newCacheDir)) {
               FileUtils.deleteQuietly(newCacheDir);
                mLastCalculateCacheTime = 0;
            }
        }
    }


    /**
     * Http接口访问的数据缓存文件夹
     *
     * @return
     */
    public File getHttpCacheDir() {
        File dir = new File(getTmpDir(true, true, null), "http_cache");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        com.app.library.utils.FileUtils.makeNoMediaFile(dir);
        return dir;
    }

    /**
     * 图片存储临时目录
     *
     * @return
     */
    public File getImageProcessCacheDir() {
        File dir = new File(getTmpDir(false, true, null), "image_cache");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        com.app.library.utils.FileUtils.makeNoMediaFile(dir);
        return dir;
    }


    /**
     * 获取临时目录
     *
     * @param onlySdcard 是否只取sd卡上的目录
     * @param isCache    是否是缓存文件
     * @param type       {@link Environment#DIRECTORY_MUSIC},
     *                   {@link Environment#DIRECTORY_PODCASTS},
     *                   {@link Environment#DIRECTORY_RINGTONES},
     *                   {@link Environment#DIRECTORY_ALARMS},
     *                   {@link Environment#DIRECTORY_NOTIFICATIONS},
     *                   {@link Environment#DIRECTORY_PICTURES}, or
     *                   {@link Environment#DIRECTORY_MOVIES}.
     * @return
     */
    private File getTmpDir(boolean onlySdcard, boolean isCache, String type) {
        // 判断sd卡是否存在
        boolean sdCardExist = EnvironmentUtils.isExternalStorageExist();
        boolean sdCardEnable = EnvironmentUtils.isExternalStorageMountedReadWrite();
        if (onlySdcard && (!sdCardExist || !sdCardEnable)) {
            return null;//仅使用sd卡,但此时sd卡不可用
        }

        File rootDir = isCache ? EnvironmentUtils.getExternalCacheDir(CommonModule.getAppContext()) : EnvironmentUtils.getExternalFilesDir(CommonModule.getAppContext(), type);
        if (rootDir != null) {
            //sd卡可用
            if (!rootDir.exists() && !rootDir.mkdirs()) {
                //sd卡目录不可用
                File newRootDir = new File(rootDir.getPath().replace("/sdcard/", "/sdcard-ext/"));
                if (newRootDir.mkdirs()) {
                    //sd卡兼容目录可用
                    rootDir = newRootDir;
                }
            }
        }

        if (rootDir == null || !rootDir.exists() || !rootDir.canRead() || !rootDir.canWrite()) {
            if (onlySdcard) {
                return null;
            } else {
                rootDir = isCache ? CommonModule.getAppContext().getCacheDir() : CommonModule.getAppContext().getFilesDir();
            }
        }

        File tmpDir = new File(rootDir, "temp");
        if (!tmpDir.exists()) {
            tmpDir.mkdirs();
        }

        // 分用户
        tmpDir = new File(tmpDir, String.valueOf(mAccount.getUid()));

        return tmpDir;
    }

}
