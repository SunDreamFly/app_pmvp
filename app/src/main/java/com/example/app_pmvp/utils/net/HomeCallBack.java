package com.example.app_pmvp.utils.net;

public interface HomeCallBack<B> {
    void onSuccess(B b);

    void onFail(String error);
}
