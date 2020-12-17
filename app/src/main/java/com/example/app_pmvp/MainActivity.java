package com.example.app_pmvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.app_pmvp.adapter.HomeAdapter;
import com.example.app_pmvp.base.BaseActivity;
import com.example.app_pmvp.bean.HomeBean;
import com.example.app_pmvp.contract.MainContract;
import com.example.app_pmvp.presenter.ImpHomePresenter;
import com.example.app_pmvp.utils.net.URLConstant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ImpHomePresenter> implements MainContract.HomeView<HomeBean> {


    private RecyclerView rv;
    private ArrayList<HomeBean.DataDTO> list;
    private HomeAdapter homeAdapter;

    @Override
    protected void initData() {
        presenter.getData(URLConstant.HOMELIST);
    }

    @Override
    protected void initView() {
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        homeAdapter = new HomeAdapter(list, this);
        rv.setAdapter(homeAdapter);
    }

    @Override
    protected ImpHomePresenter getPresenter() {
        return new ImpHomePresenter(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(HomeBean homeBean) {
        List<HomeBean.DataDTO> data = homeBean.getData();
        list.addAll(data);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {

    }
}