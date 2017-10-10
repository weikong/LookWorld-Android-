package com.look.world.httptask;

import com.look.world.config.UrlConfig;
import com.squareup.okhttp.Request;

import java.io.File;
import java.io.IOException;

/**
 * Created by kongwei on 2017/3/10.
 */

public class HttpTaskUtil {

    private ResultListener resultListener;

    private HttpTaskUtil mInstance;

//    public HttpTaskUtil getInstance() {
//        if (mInstance == null) {
//            synchronized (HttpTaskUtil.class) {
//                if (mInstance == null) {
//                    mInstance = new HttpTaskUtil();
//                }
//            }
//        }
//        return mInstance;
//    }

    public interface ResultListener {
        public void onResponse(String response);

        public void onFailure(Request request, Exception e);
    }

    public HttpTaskUtil setResultListener(ResultListener resultListener) {
        this.resultListener = resultListener;
        return this;
    }

    public void UploadImagesTask(File[] files, String[] fileKeys, OkHttpClientManager.StringCallback callback) {
        try {
            OkHttpClientManager.postAsyn(UrlConfig.HTTP_UPLOAD_IMAGE, callback, files, fileKeys);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void UploadImageTask(File file, String fileKeys, OkHttpClientManager.StringCallback callback) {
        try {
            OkHttpClientManager.postAsyn(UrlConfig.HTTP_UPLOAD_IMAGE, callback, file, fileKeys);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OkHttpClientManager.Param setLocateParam(String key, String value) {
        OkHttpClientManager.Param param = new OkHttpClientManager.Param(key, value);
        return param;
    }
}
