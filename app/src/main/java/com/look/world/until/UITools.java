package com.look.world.until;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.look.world.App;

/**
 * Created by xinzhendi-031 on 2015/12/7.
 */
public class UITools {
    /**
     * Device pixels
     */
    public static int SCREEN_WIDTH = 480;
    public static int SCREEN_HEIGHT = 800;
    private static final int DESIGN_WIDTH = 480;
    private static final int DESIGN_HEIGHT = 800;
    /**
     * Pixel density
     */
    public static float mainScale = 1.0f;
    public static float density = 1.0f;

    public static float MaxImageWidth = 160.0f;
    public static float MinImageWidth = 80.0f;

    public static int KeyBoardHeight = 0;
    public final static String KEY_BOARD_HEIGHT = "KeyBoardHeight";

    public static void getScreenWH(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        SCREEN_WIDTH = metric.widthPixels;     // 屏幕宽度（像素）
        SCREEN_HEIGHT = metric.heightPixels;   // 屏幕高度（像素）
        density = metric.density;      // 屏幕密度（0.75 / 1.0 / 1.5）
    }

    public static int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                App.getInstance().getResources().getDisplayMetrics());
    }

    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }

}
