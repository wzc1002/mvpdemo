package com.example.mvp;

import com.example.data.MainBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * create by 吴张成 on 2020/8/30
 */

public interface ApiService {
    @GET()
    Observable<MainBean> getMainData(@Url String url);
}
