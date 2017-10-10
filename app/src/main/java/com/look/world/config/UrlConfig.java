package com.look.world.config;

/**
 * Created by kongwei on 2017/9/16.
 */

public class UrlConfig {

    public static String HTTP_ROOT = "http://174677bk23.iask.in:14151/";

    /**
     * 景区查询
     */
    public static String HTTP_SCENIC = HTTP_ROOT + "scenic-api/listAll?offset=%d&limit=20";

    /**
     * 上传图片接口
     */
    public static String HTTP_UPLOAD_IMAGE = HTTP_ROOT + "upload";

}
