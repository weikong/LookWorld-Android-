package com.look.world.until;

import android.graphics.Bitmap;

import com.look.world.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by xinzhendi-031 on 2015/12/7.
 */
public class ImageLoadOption {

    public static final int MAX_IMAGE_WIDTH = 480; // The max pixels of image width
    public static final int MAX_IMAGE_HEIGHT = 800; // The max pixels of image height
    public static final int MAX_IMAGE_MEMORY_CACHE_SIZE = 2 * 1024 * 1024; // 2MB memory cache of images
    public static final int MAX_IMAGE_DISK_CACHE_SIZE = 200 * 1024 * 1024; // 200MB SD card cache of images

    /**
     * 图片圆角像素
     */
    private static final int NONE_CORNER_RADIUS_PIXELS = 0;
    private static final int CONTENT_CORNER_RADIUS_PIXELS = 4;
    private static final int HEADER_CORNER_RADIUS_PIXELS = 100;

    /**
     * 用户头像和群组头像
     */
    public static DisplayImageOptions optionsImageNone = getDisplayImageOptions(R.drawable.load_default);
    public static DisplayImageOptions optionsImageSquare = getDisplayImageOptions(R.drawable.load_default_square);
    public static DisplayImageOptions optionsImageContent = getDisplayImageOptions(R.drawable.load_default, UITools.dp2px(CONTENT_CORNER_RADIUS_PIXELS));
    public static DisplayImageOptions optionsUserHeader = getDisplayImageOptions(R.drawable.me_touxiang, UITools.dp2px(HEADER_CORNER_RADIUS_PIXELS));

    /**
     * Obtain the ImageLoader display parameters
     *
     * @param imageResId         The resource ID of image
     * @param cornerRadiusPixels The rounded corners of image
     * @return DisplayImageOptions
     */
//    private static DisplayImageOptions getDisplayImageOptions(int imageResId, int... cornerRadiusPixels) {
//        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
//        builder.showImageOnLoading(imageResId);
//        builder.showImageForEmptyUri(imageResId);
//        builder.showImageOnFail(imageResId);
//        builder.cacheInMemory(true);
//        builder.cacheOnDisc(true);
//        builder.bitmapConfig(Bitmap.Config.RGB_565);
//        builder.imageScaleType(ImageScaleType.EXACTLY);
//        if (null != cornerRadiusPixels && cornerRadiusPixels.length > 0) {
//            builder.displayer(new RoundedBitmapDisplayer(cornerRadiusPixels[0]));
//        }
//        builder.resetViewBeforeLoading(true);
//        return builder.build();
//    }
    private static DisplayImageOptions getDisplayImageOptions(int imageResId, int... cornerRadiusPixels) {
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        builder.showImageOnLoading(imageResId);
        builder.showImageForEmptyUri(imageResId);
        builder.cacheInMemory(true);
        builder.cacheOnDisk(true);
        builder.bitmapConfig(Bitmap.Config.RGB_565);
        builder.imageScaleType(ImageScaleType.EXACTLY);
        if (null != cornerRadiusPixels && cornerRadiusPixels.length > 0) {
            builder.displayer(new RoundedBitmapDisplayer(cornerRadiusPixels[0]));
        }
        builder.resetViewBeforeLoading(false);
        return builder.build();
    }
}
