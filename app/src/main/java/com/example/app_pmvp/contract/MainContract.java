package com.example.app_pmvp.contract;

import com.example.app_pmvp.utils.net.HomeCallBack;

public class MainContract {
    public interface HomeMolder<B> {
        void getData(String url, HomeCallBack<B> callBack);
    }

    public interface HomePresenter {
        void getData(String url);
    }

    public interface HomeView<T> {
        void onSuccess(T t);

        void onFail(String error);
    }
}
