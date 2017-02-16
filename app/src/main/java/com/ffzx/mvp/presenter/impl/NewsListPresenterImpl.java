package com.ffzx.mvp.presenter.impl;

import com.ffzx.mvp.model.INewsListModel;
import com.ffzx.mvp.model.bean.NewsListBean;
import com.ffzx.mvp.model.impl.NewsListModelImpl;
import com.ffzx.mvp.presenter.INewsListPresenter;
import com.ffzx.mvp.view.NewsListView;

import java.util.List;

/**
 * 业务逻辑的实现类
 * Created by Administrator on 2017/2/14.
 */

public class NewsListPresenterImpl implements INewsListPresenter {
    /**
     * 控制界面的view层
     */
    private NewsListView newsListView;
    /**
     * 获取数据的M层
     */
    private INewsListModel newsListModel;

    public NewsListPresenterImpl(NewsListView newsListView) {
        this.newsListView = newsListView;
        this.newsListModel = new NewsListModelImpl();
    }


    @Override
    public void getNewsList() {
        newsListView.showLoading();
        newsListModel.getNewsList(new NewsListModelImpl.OnLoadNewsDataListener() {
            @Override
            public void onSuccess(List<NewsListBean> list) {
                newsListView.hideLoading();
                newsListView.showNewsList(list);
            }

            @Override
            public void onFailure(String str, Exception e) {
                newsListView.hideLoading();
                newsListView.showTips(str);
            }
        });
    }
}
