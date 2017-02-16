package com.ffzx.mvp.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ffzx.mvp.R;
import com.ffzx.mvp.model.bean.NewsListBean;
import com.ffzx.mvp.presenter.INewsListPresenter;
import com.ffzx.mvp.presenter.impl.NewsListPresenterImpl;
import com.ffzx.mvp.ui.adapter.NewsListAdapter;
import com.ffzx.mvp.view.NewsListView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class MainActivity extends AppCompatActivity implements NewsListView {

    /**
     * 列表控件
     */
    private RecyclerView recyclerView;
    /**
     * 进度框加载
     */
    private ProgressDialog progressDialog;
    /**
     * 新闻列表的业务处理类
     */
    private INewsListPresenter mPresenter;
    /**
     * 列表数据适配器
     */
    private NewsListAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /**
     * 初始化控件
     */
    private void initViews() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("加载中，请稍候...");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_news);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManger = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManger);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new NewsListAdapter(this);
        recyclerView.setAdapter(mAdapter);

        mPresenter = new NewsListPresenterImpl(this);
        mPresenter.getNewsList();
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showNewsList(List<NewsListBean> list) {
        mAdapter.setmData(list);
    }

    @Override
    public void showTips(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
