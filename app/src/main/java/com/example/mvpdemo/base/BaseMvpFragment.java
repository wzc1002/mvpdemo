package com.example.mvpdemo.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mvp.mvputils.CommonPresenter;
import com.example.mvp.mvputils.ICommonModel;
import com.example.mvp.mvputils.ICommonView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * create by 吴张成 on 2020/8/30
 */


public abstract class BaseMvpFragment<M extends ICommonModel> extends BaseFragment implements ICommonView {
    private M mModel;
    public CommonPresenter mPresenter;
    private Unbinder mBind;
    private boolean isInit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(setLayoutId(), container, false);
        mBind = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpView();
        if (mModel == null) mModel = setModel();
        if (mPresenter == null) mPresenter = new CommonPresenter(this, mModel);
        if (!isInit) {
            setUpData();
            isInit = true;
        }
    }

    public abstract M setModel();

    public abstract int setLayoutId();

    public abstract void setUpView();

    public abstract void setUpData();

    public void initListener() {
    }

    public abstract void netSuccess(int whichApi, Object[] pD);

    public void netFailed(int whichApi, Throwable pThrowable) {
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
    public void onDestroy() {
        super.onDestroy();
        mPresenter.clear();
        if (mBind != null) mBind.unbind();
    }
}
