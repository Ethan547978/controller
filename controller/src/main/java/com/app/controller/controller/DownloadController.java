package com.app.controller.controller;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadQueueSet;
import com.liulishuo.filedownloader.FileDownloader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Description : 下载Controller
 * Creator : ZST
 * Data : 2017/8/28.
 */
public class DownloadController {

    private DownloadController() {
    }

    private static class SingletonHolder {
        public static final DownloadController INSTANCE = new DownloadController();
    }

    public static DownloadController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private final Map<String, BaseDownloadTask> mDownloadingTasks = new ConcurrentHashMap<>();


    private FileDownloadListener fileDownloadListener(final DownloadListener downloadListener) {
        return new FileDownloadListener() {

            @Override
            protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                if (downloadListener != null) {
                    downloadListener.pending(task, soFarBytes, totalBytes);
                }
            }

            @Override
            protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {
                super.connected(task, etag, isContinue, soFarBytes, totalBytes);
                if (downloadListener != null) {
                    downloadListener.connected(task, etag, isContinue, soFarBytes, totalBytes);
                }
            }

            @Override
            protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                if (downloadListener != null) {
                    downloadListener.progress(task, soFarBytes, totalBytes);
                }
            }

            @Override
            protected void blockComplete(BaseDownloadTask task) throws Throwable {
                super.blockComplete(task);
                mDownloadingTasks.remove(task.getUrl());
                if (downloadListener != null) {
                    downloadListener.blockComplete(task);
                }
            }

            @Override
            protected void completed(BaseDownloadTask task) {
                mDownloadingTasks.remove(task.getUrl());
                if (downloadListener != null) {
                    downloadListener.completed(task);
                }
            }

            @Override
            protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                mDownloadingTasks.remove(task.getUrl());
                if (downloadListener != null) {
                    downloadListener.paused(task, soFarBytes, totalBytes);
                }
            }

            @Override
            protected void retry(BaseDownloadTask task, Throwable ex, int retryingTimes, int soFarBytes) {
                super.retry(task, ex, retryingTimes, soFarBytes);
                if (downloadListener != null) {
                    downloadListener.retry(task, ex, retryingTimes, soFarBytes);
                }
            }

            @Override
            protected void error(BaseDownloadTask task, Throwable e) {
                mDownloadingTasks.remove(task.getUrl());
                if (downloadListener != null) {
                    downloadListener.error(task, e);
                }
            }

            @Override
            protected void warn(BaseDownloadTask task) {
                mDownloadingTasks.remove(task.getUrl());
                if (downloadListener != null) {
                    downloadListener.warn(task);
                }
            }
        };
    }

    /**
     * 单任务下载，不需要回调
     *
     * @param url      下载url
     * @param savePath 保存路径
     */
    public void download(String url, File savePath) {
        if (url == null || savePath == null) {
            return;
        }

        if (mDownloadingTasks.containsKey(url)) {
            return;
        }

        BaseDownloadTask task = FileDownloader.getImpl()
                .create(url)
                .setPath(savePath.getAbsolutePath())
                .setListener(fileDownloadListener(null));

        task.setCallbackProgressTimes(20);

        mDownloadingTasks.put(url, task);
        task.start();
    }

    /**
     * 单任务下载，有回调
     *
     * @param url              下载url
     * @param savePath         保存路径
     * @param downloadListener
     */
    public void download(String url, File savePath, DownloadListener downloadListener) {
        if (url == null || savePath == null) {
            return;
        }

        if (mDownloadingTasks.containsKey(url)) {
            return;
        }

        BaseDownloadTask task = FileDownloader.getImpl()
                .create(url)
                .setPath(savePath.getAbsolutePath())
                .setListener(fileDownloadListener(downloadListener));

        task.setCallbackProgressTimes(20);

        mDownloadingTasks.put(url, task);
        task.start();
    }

    /**
     * 多任务下载
     */
    public void downloadSequentially(ArrayList<String> urls, String savePath, DownloadListener downloadListener) {
        FileDownloadQueueSet queueSet = new FileDownloadQueueSet(fileDownloadListener(downloadListener));
        List<BaseDownloadTask> tasks = new ArrayList<>();
        for (int i = 0; i < urls.size(); i++) {
            tasks.add(FileDownloader.getImpl().create(urls.get(i)).setPath(savePath));
        }

        // 由于是队列任务, 这里是我们假设了现在不需要每个任务都回调`FileDownloadListener#progress`,
        // 我们只关系每个任务是否完成, 所以这里这样设置可以很有效的减少ipc.
        queueSet.disableCallbackProgressTimes();
        // 所有任务在下载失败的时候都自动重试一次
        queueSet.setAutoRetryTimes(1);

//        if (serial) {// 串行执行该任务队列
//            queueSet.downloadSequentially(tasks);
//            // 如果你的任务不是一个List，可以考虑使用下面的方式，可读性更强
////      queueSet.downloadSequentially(
////              FileDownloader.getImpl().create(url).setPath(...),
////              FileDownloader.getImpl().create(url).addHeader(...,...),
////              FileDownloader.getImpl().create(url).setPath(...)
////      );
//        } else if (parallel) {// 并行执行该任务队列
        queueSet.downloadTogether(tasks);
//            // 如果你的任务不是一个List，可以考虑使用下面的方式，可读性更强
////    queueSet.downloadTogether(
////            FileDownloader.getImpl().create(url).setPath(...),
////            FileDownloader.getImpl().create(url).setPath(...),
////            FileDownloader.getImpl().create(url).setSyncCallback(true)
////    );
//        }
    }

    /**
     * 获取task
     *
     * @param url 下载URL
     * @return task
     */
    public BaseDownloadTask getRunningDownloadTask(String url) {
        if (url == null) {
            return null;
        }
        return mDownloadingTasks.get(url);
    }

    /**
     * 回调方法，不需要的可以关掉
     */
    public interface DownloadListener {

        //等待，已经进入下载队列
        void pending(BaseDownloadTask task, int soFarBytes, int totalBytes);

        //已经连接上
        void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes);

        //下载进度回调
        void progress(BaseDownloadTask task, int soFarBytes, int totalBytes);

        //在完成前同步调用该方法，此时已经下载完成
        void blockComplete(BaseDownloadTask task);

        //完成整个下载过程
        void completed(BaseDownloadTask task);

        //暂停下载
        void paused(BaseDownloadTask task, int soFarBytes, int totalBytes);

        //下载出现错误
        void error(BaseDownloadTask task, Throwable e);

        //重试之前把将要重试是第几次回调回来
        void retry(BaseDownloadTask task, Throwable ex, int retryingTimes, int soFarBytes);

        //在下载队列中(正在等待/正在下载)已经存在相同下载连接与相同存储路径的任务
        void warn(BaseDownloadTask task);
    }
}
