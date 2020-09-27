package com.example.mvpdemo.view;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.BaseMvpActivity;
import com.example.mvpdemo.model.CommonHomeModel;

public class HomeActivity extends BaseMvpActivity<CommonHomeModel> {
    //作为fragment依附的住activvity存在
    @Override
    public CommonHomeModel setModel() {
        return null;
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

    }

    @Override
    public void netSuccess(int whichApi, Object[] pD) {

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
