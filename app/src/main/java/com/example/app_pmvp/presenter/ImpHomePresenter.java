package com.example.app_pmvp.presenter;

import com.example.app_pmvp.base.BasePresenter;
import com.example.app_pmvp.bean.HomeBean;
import com.example.app_pmvp.contract.MainContract;
import com.example.app_pmvp.model.ImpModel;
import com.example.app_pmvp.utils.net.HomeCallBack;

public class ImpHomePresenter extends BasePresenter<MainContract.HomeMolder<HomeBean>,MainContract.HomeView> implements MainContract.HomePresenter {
    public ImpHomePresenter(MainContract.HomeView view) {
        super(view);
    }

    @Override
    protected MainContract.HomeMolder<HomeBean> getModel() {
        return new ImpModel<HomeBean>();
    }

    @Override
    public void getData(String url) {
        model.getData(url, new HomeCallBack<HomeBean>() {
            @Override
            public void onSuccess(HomeBean homeBean) {
                view.onSuccess(homeBean);
            }

            @Override
            public void onFail(String error) {
                view.onFail(error);
            }
        });
    }
}
