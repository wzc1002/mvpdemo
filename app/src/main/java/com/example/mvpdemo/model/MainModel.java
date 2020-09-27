package com.example.mvpdemo.model;

import com.example.mvp.ParamHashMap;
import com.example.mvp.mvputils.ICommonModel;
import com.example.mvp.mvputils.ICommonPresenter;
import com.example.mvp.mvputils.NetManger;

/**
 * create by 吴张成 on 2020/8/30
 */


public class MainModel implements ICommonModel {
    @Override
    public void getData(ICommonPresenter pPresenter, int whichApi, Object[] params) {
        switch (whichApi){
            case 1:
                ParamHashMap map = (ParamHashMap) params[0];
                NetManger.getInstance().netWork(NetManger.mService.getMainData((String) map.get("url")),pPresenter,whichApi);
                break;
        }
    }
}
