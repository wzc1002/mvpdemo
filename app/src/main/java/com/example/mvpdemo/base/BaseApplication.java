package com.example.mvpdemo.base;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.yiyatech.utils.UtilsApplication;

public class BaseApplication extends UtilsApplication {
    private static BaseApplication mApplication1907;
    private RefWatcher mRefWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication1907 = this;
        MultiDex.install(this);
        mRefWatcher = setupLeakCanary();
    }

    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this) /*|| API_TYPE == 3*/) {
            return RefWatcher.DISABLED;
        }
        //调用install方法后，首先程序会检测是否安装对应该程序的监听附件程序，如果没有安装进行安装
        //其次方法内部自动实现了对activity内部生命周期的监听，包括activity内部的fragment
        return LeakCanary.install(this);
    }

    public BaseApplication getApplication(){
        return mApplication1907;
    }

    public static Context get07ApplicationContext(){
        return mApplication1907.getApplicationContext();
    }
    /**
     * 除了activity以外，其他对象如果监听自身是否存在内存泄漏，如要在该对象销毁的时候调用该方法，并通过watch方法开始监听。
     * RefWatcher refWatcher = Application1907.getRefWatcher(this);
     * refWatcher.watch(this);
     *
     * @param context
     * @return
     */
    public static RefWatcher getRefWatcher(Context context) {
        BaseApplication leakApplication = (BaseApplication) context.getApplicationContext();
        return leakApplication.mRefWatcher;
    }

}
