package com.example.app_pmvp.model;

import com.example.app_pmvp.contract.MainContract;
import com.example.app_pmvp.utils.net.HomeCallBack;
import com.example.app_pmvp.utils.net.RetrofitUtils;

public class ImpModel<T> implements MainContract.HomeMolder<T> {

    @Override
    public void getData(String url, HomeCallBack<T> callBack) {
        RetrofitUtils retrofitUtils = RetrofitUtils.getRetrofitUtils();
        retrofitUtils.get(url,callBack);
    }
}
