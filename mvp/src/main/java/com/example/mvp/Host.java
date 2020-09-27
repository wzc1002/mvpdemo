package com.example.mvp;

import android.content.Context;

public class Host {


    public static final int API_TYPE = 3;//1,内测  2，外测  3，外正

    public static String AD_OPENAPI;
    public static String FOOLOW_LIST_OPENAPI;
    public static String BBS_URL;
    public static String BBS_OPENAPI;
    public static String WEBRULE_URL;
    public static String UPLOAD_PHOTO;
    public static String MESSAGE;
    public static String MESSAGE_API;
    public static String MESSAGE_OPENAPI;
    public static String PASSPORT;
    public static String PASSPORT_API;
    public static String PASSPORT_OPENAPI;
    public static String WEIBO;
    public static String WEIBO_API;
    public static String WEIBO_OPENAPI;
    public static String EDU_URL;
    public static String EDU_API;
    public static String EDU_OPENAPI;
    public static String PASSPORT_OPENAPI_USER;
    public static String BLOG_API;
    public static String S_URL;
    public static String TOPIC_OPENAPI;
    public static String ALL_OPENAPI;
    public static String INFO_OPENAPI;
    public static String PAYMENT_AGREEMENT_API;
    public static String E_PAYMENT_AGREEMENT_API;
    public static String VIP_LIST_OPENAPI;
    public static String FX_OPENAPI;
    public static String PHOTO_URL;
    public static String PHOTO_OPENAPI;
    public static String BBS_API;
    public static String WX_OAUTH;

    /**
     * 静态代码块，优先于对象的创建而执行，且只执行一次
     */
    static {
        if (API_TYPE == 1){
            AD_OPENAPI = "";
            PHOTO_OPENAPI=PHOTO_URL;
        }
        if (API_TYPE == 2){
            AD_OPENAPI = "";
            PHOTO_OPENAPI=AD_OPENAPI;
        }
        if (API_TYPE == 3){
            AD_OPENAPI = "https://a.zhulong.com/openapi/";
        }
    }
}
