package com.app.controller.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.util.Base64;

import com.app.library.utils.Common;
import com.app.library.utils.FileUtil;
import com.app.library.utils.LogUtils;
import com.app.library.utils.NativeUtil;
import com.app.controller.CommonModule;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {

    private static final String Tag = "ImageUtil";

    /**
     * 从资源文件获取Bitmap
     *
     * @param context
     * @param fileName
     * @return
     */
    public static Bitmap getImageFromAssets(Context context, String fileName) {
        Bitmap image = null;
        AssetManager am = context.getResources().getAssets();
        try {
            InputStream is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    /**
     * 计算图片的缩放值
     */
    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height
                    / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSampleSize;
    }

    /**
     * 根据路径获得图片并压缩，返回bitmap用于显示
     */
    public static Bitmap getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
//        options.inSampleSize = calculateInSampleSize(options, 360, 600);
        options.inSampleSize = calculateInSampleSize(options, 720, 1200);
        options.inJustDecodeBounds = false;
        //添加
        Bitmap b = BitmapFactory.decodeFile(filePath, options);
        int degree = readPictureDegree(filePath);
        return rotaingImageView(degree, b);
//        return BitmapFactory.decodeFile(filePath, options);
    }

    /**
     * 根据路径获得图片并压缩，返回bitmap用于显示
     */
    public static Bitmap getSmallBitmap(String filePath, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    /**
     * 根据路径获得图片并压缩，返回bitmap用于显示
     *
     * @param sampleSize 压缩倍数
     */
    public static Bitmap getSmallBitmap(String filePath, int sampleSize) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeFile(filePath, options);
        options.inSampleSize = sampleSize;
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(filePath, options);
    }

    /**
     * 根据路径获得图片并压缩，返回bitmap用于显示,解密加载
     */
    public static Bitmap getSmallBitmapAesEncrypt(String filePath, int sampleSize, String aesKey) {
        byte[] bytes = FileUtil.simpleDecrypt(filePath, aesKey);
        if (bytes != null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = sampleSize;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        }
        return null;
    }

    /**
     * 从本地加载一个特效资源
     *
     * @param uris       文件名
     * @param tagFile    文件夹
     * @param sampleSize 压缩倍数
     * @return
     */
    public static Drawable[] getDrawableInFile(String tagFile, String[] uris, int sampleSize, String aesKey) {
        Drawable[] bitmap1 = new Drawable[uris.length];
        for (int i = 0; i < uris.length; i++) {
            Bitmap smallBitmapAesEncrypt = getSmallBitmapAesEncrypt(tagFile + uris[i], sampleSize, aesKey);
            if (smallBitmapAesEncrypt != null) {
                bitmap1[i] = new BitmapDrawable(smallBitmapAesEncrypt);
            }
        }
        return bitmap1;
    }


    /**
     * 从本地加载一个特效资源
     *
     * @param tagFiles   文件名数组
     * @param sampleSize 压缩倍数
     * @return
     */
    public static Drawable[] getDrawableInFile(String[] tagFiles, int sampleSize, String aesKey) {
        Drawable[] bitmap1 = new Drawable[tagFiles.length];
        for (int i = 0; i < tagFiles.length; i++) {
            bitmap1[i] = new BitmapDrawable(ImageUtil.getSmallBitmapAesEncrypt(tagFiles[i], sampleSize, aesKey));
        }
        return bitmap1;
    }

    /**
     * 获取特效资源的宽高，但是用的时候要乘以一定的倍数
     *
     * @param drawables
     * @return
     */
    public static int[] getDrawableWh(Drawable[] drawables) {
        int[] i = new int[2];
        if (drawables != null && drawables.length != 0) {
            i[0] = Common.dip2px(CommonModule.getAppContext(), drawables[0].getMinimumWidth());
            i[1] = Common.dip2px(CommonModule.getAppContext(), drawables[0].getMinimumHeight());
        }

        return i;
    }

    /**
     * 方法说明：保存裁剪之后的图片数据
     */
    public static void savePicToView(Bitmap photo, File file) {
        if (photo == null) {
            return;
        }
        try {
            // 创建文件
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 定义文件输出流
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 将bitmap存储为jpg格式的图片
        photo.compress(Bitmap.CompressFormat.JPEG, 30, fOut);
        try {
            // 刷新文件流
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 关闭文件流
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File saveImage(File fromFile, File tagFile) {
        Bitmap b = getSmallBitmap(fromFile.getAbsolutePath());

        savePicToView(b, tagFile);
        return tagFile;
    }

    public static byte[] getBitmapByte(String filePath) {
        Bitmap bitmap = getSmallBitmap(filePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 30, baos);
        byte[] b = baos.toByteArray();
        return b;
    }


    /**
     * 二次采样类
     *
     * @param inputStream
     * @param destWidth
     * @param destHeight
     * @return
     */
    public static Bitmap getBitmapFromStream(InputStream inputStream, int destWidth, int destHeight) {

        //第一采样

        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;

        Rect outPadding = new Rect();
        outPadding.left = 2;
        outPadding.right = 2;
        BitmapFactory.decodeStream(inputStream, outPadding, options);

        int outWidth = options.outWidth;

        int outHeight = options.outHeight;

        int sampleSize = 1;

        while ((outWidth / sampleSize > destWidth) || (outHeight / sampleSize > destHeight)) {

            sampleSize *= 2;

        }

        //第二次采样

        options.inJustDecodeBounds = false;

        options.inSampleSize = sampleSize;

        options.inPreferredConfig = Bitmap.Config.RGB_565;

        return BitmapFactory.decodeStream(inputStream, outPadding, options);

    }


    /**
     * 读取图片属性：旋转的角度
     *
     * @param path 图片绝对路径
     * @return degree旋转的角度
     */
    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 旋转图片
     *
     * @param angle
     * @param bitmap
     * @return Bitmap
     */
    public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        //旋转图片 动作
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        LogUtils.d(Tag, "angle2=" + angle);
        // 创建新的图片
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizedBitmap;
    }

    /**
     * libjpeg压缩图像
     *
     * @param quality  压缩大小 1-100
     * @param readPath 图片读取路径
     * @param savePath 保存路径
     * @return 返回图片文件
     */
    public static File nativegetBitmap(int quality, String readPath, final String savePath) {
        try {
            File f = new File(readPath);
            InputStream in = new FileInputStream(f);
            Bitmap bit = BitmapFactory.decodeStream(in);
            NativeUtil.compressBitmap(bit, quality, savePath, true);
            File file = new File(savePath);//压缩后文件
            return file;
//            InputStream is = new FileInputStream(file);
//            Bitmap bitmap = BitmapFactory.decodeStream(is);//压缩后图片
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * libjpeg压缩图像
     *
     * @param quality  压缩大小 1-100
     * @param savePath 保存路径
     * @return 返回图片文件
     */
    public static String nativeCompressBitmap(Bitmap bitmap, int quality, final String savePath) {
        ByteArrayOutputStream os = null;
        FileInputStream inputStream = null;
        try {
            NativeUtil.compressBitmap(bitmap, quality, savePath, true);
            File file = new File(savePath);//压缩后文件
            inputStream = new FileInputStream(file);
            os = new ByteArrayOutputStream();
            byte[] tempCache = new byte[1024];
            int tempReadSize = inputStream.read(tempCache);
            while (tempReadSize != -1) {
                os.write(tempCache, 0, tempReadSize);
                tempReadSize = inputStream.read(tempCache);
            }
            byte[] buffer = os.toByteArray();
            return Base64.encodeToString(buffer, 0, buffer.length, Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * libjpeg压缩图像
     *
     * @param quality  压缩大小 1-100
     * @param readPath 图片读取路径
     * @param savePath 保存路径
     * @return 返回路径
     */
    public static String nativegetBitmapReturnPath(int quality, String readPath, final String savePath) {
        try {
            File f = new File(readPath);
            InputStream in = new FileInputStream(f);
            Bitmap bit = BitmapFactory.decodeStream(in);
            NativeUtil.compressBitmap(bit, quality, savePath, true);
//            File file = new File(savePath);//压缩后文件
            return savePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
