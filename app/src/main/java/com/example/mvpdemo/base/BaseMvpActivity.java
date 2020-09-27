package com.example.mvpdemo.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mvp.mvputils.CommonPresenter;
import com.example.mvp.mvputils.ICommonModel;
import com.example.mvp.mvputils.ICommonView;

import butterknife.ButterKnife;

/**
 * create by 吴张成 on 2020/8/30
 */


public  abstract class BaseMvpActivity<M extends ICommonModel> extends BaseActivity implements ICommonView {
    private M mModel;
    public CommonPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        ButterKnife.bind(this);
        mModel = setModel();
        mPresenter = new CommonPresenter(this, mModel);
        setUpView();
        setUpData();
    }

    public abstract M setModel();

    public abstract int setLayoutId();

    public abstract void setUpView();

    public abstract void setUpData();

    public abstract void netSuccess(int whichApi, Object[] pD);

    public void netFailed(int whichApi, Throwable pThrowable) {
        Log.e("ERROF", "netFailed: "+pThrowable );
    }

    @Override
    public void onSuccess(int whichApi, Object[] pD) {
        netSuccess(whichApi, pD);
    }

    @Override
    public void onFailed(int whichApi, Throwable pThrowable) {
        showLog("net work error: " + whichApi + "error content" + pThrowable != null && !TextUtils.isEmpty(pThrowable.getMessage()) ? pThrowable.getMessage() : "不明错误类型");
        netFailed(whichApi, pThrowable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.clear();
    }
}
