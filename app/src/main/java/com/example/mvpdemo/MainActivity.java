package com.example.mvpdemo;

import android.os.Bundle;
import android.widget.TextView;

import com.example.data.MainBean;
import com.example.mvp.ParamHashMap;
import com.example.mvpdemo.base.BaseMvpActivity;
import com.example.mvpdemo.model.MainModel;

import butterknife.BindView;
import butterknife.ButterKnife;
//
public class MainActivity extends BaseMvpActivity<MainModel> {


    @BindView(R.id.tv)
    TextView tv;

    @Override
    public MainModel setModel() {
        return new MainModel();
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setUpView() {

    }

    @Override
    public void setUpData() {
        //1是请求的标识
        //https://www.wanandroid.com/navi/json
        ParamHashMap url = new ParamHashMap().add("url", "https://www.wanandroid.com/navi/json");
        mPresenter.getData(1,url);
    }

    @Override
    public void netSuccess(int whichApi, Object[] pD) {
        switch (whichApi){
            case 1:
                MainBean bean = (MainBean) pD[0];
                tv.setText(bean.getData().toString());
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}