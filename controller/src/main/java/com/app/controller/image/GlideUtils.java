package com.app.controller.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.app.controller.R;
import com.app.library.utils.ScreenUtils;

import java.io.File;


public class GlideUtils {

    public static void showImageView(Context context, int errorimg, String url, ImageView imgeview) {
        Glide.with(context).load(url)// 加载图片
                .error(errorimg)// 设置错误图片
                .placeholder(errorimg)// 设置占位图
                .centerCrop()
                .into(imgeview);
    }

    public static void showImageViewFitCenter(Context context, int errorimg, String url, ImageView imgeview) {
        Glide.with(context).load(url)// 加载图片
                .error(errorimg)// 设置错误图片
                .fitCenter()
                .placeholder(errorimg)// 设置占位图
                .into(imgeview);
    }

    public static void showImageView(Context context, int errorimg, String url, ImageView imgeview, RequestListener<Drawable> requestListener) {
        Glide.with(context).load(url)// 加载图片
                .listener(requestListener)
                .error(errorimg)// 设置错误图片
                .fitCenter()
//                .placeholder(errorimg)// 设置占位图
                .into(imgeview);

    }

    public static void showImageView(Context context, File file,ImageView imgeview){
        Glide.with(context).load(file).into(imgeview);
    }

    public static void showImageViewToCircle(Context context, int errorimg, String url, ImageView imgeview) {
        Drawable placeholderimg = imgeview.getDrawable() == null ? context.getResources().getDrawable(errorimg) : imgeview.getDrawable();
        Glide.with(context).load(url)
                // 加载图片
                .error(errorimg)
                .centerCrop()
                // 设置错误图片
                .placeholder(placeholderimg)
                // 设置占位图
                .transform(new CircleTransform())//圆角
                .into(imgeview);
    }

    /**
     * 圆形图片
     */
    public static void showImageViewToCircle(Context context, String url, int sex, ImageView imgeview) {
        int errorimg = com.app.library.R.drawable.common_default_circle_avater_icon;
        if (sex == 1) {
            errorimg = R.drawable.icon_boy;
        } else if (sex == 2) {
            errorimg = com.app.library.R.drawable.icon_girl;
        }
        Glide.with(context).load(url)
                .error(errorimg)
                .placeholder(errorimg)
                .centerCrop()
                .transform(new CircleTransform())
                .into(imgeview);
    }

    /**
     * 矩形圆角
     */
    public static void showImageViewToRoundedCorners(Context context, int errorimg, String url,int radius, ImageView imageview) {
        Glide.with(context)
                .load(url)
                .error(errorimg)
                .placeholder(errorimg)
                .apply(new RequestOptions().transforms(new CenterCrop(), new RoundedCorners(ScreenUtils.dp2px(context,radius))))
                .into(imageview);
    }
}
