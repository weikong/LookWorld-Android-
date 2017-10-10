package com.look.world;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.look.world.until.ImageLoadOption;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by xinzhendi-031 on 2017/9/14.
 */
public class App extends Application {

    public static Activity appActivity;
    public static Context appContext;

    public static App instance = null;
    public static final boolean DEVELOPER_MODE = false;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (DEVELOPER_MODE
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll().penaltyDialog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll().penaltyDeath().build());
        }
        initImageLoader(getApplicationContext());
    }

    public static App getInstance() {
        return instance;
    }

    public App setAppActivity(Activity appActivity) {
        this.appActivity = appActivity;
        return this;
    }

    public App setAppContext(Context appContext) {
        this.appContext = appContext;
        return this;
    }

    public Activity getAppActivity() {
        return appActivity;
    }

    public Context getAppContext() {
        return appContext;
    }

    public static void initImageLoader(Context context) {
        int maxMemory = 0;
        int maxImageMemoryCacheSize = (maxMemory == 0) ? ImageLoadOption.MAX_IMAGE_DISK_CACHE_SIZE : (maxMemory / 8);
//		File cacheDir = StorageUtils.getOwnCacheDirectory(appContext, "Melinked/imageloader/Cache");
// 				.diskCache(new UnlimitedDiskCache(cacheDir)) //自定义缓存路径
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).memoryCache(new LruMemoryCache(maxImageMemoryCacheSize))
                .memoryCacheExtraOptions(ImageLoadOption.MAX_IMAGE_WIDTH, ImageLoadOption.MAX_IMAGE_HEIGHT)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
//				.diskCacheSize(ImageLoaderOptions.MAX_IMAGE_DISK_CACHE_SIZE)//缓存的文件占sdcard大小
//				.diskCacheFileCount(ImageLoaderOptions.MAX_IMAGE_DISK_FILE_COUNT)//缓存的文件数量
//                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO) //LIFO:后进先出 --  FIFO:先入先出
                .build();

        ImageLoader.getInstance().init(config);
    }
}
