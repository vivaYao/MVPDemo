package com.ffzx.mvp.view;

import com.ffzx.mvp.model.bean.NewsListBean;

import java.util.List;

/**
 * 新闻列表的View
 * Created by Administrator on 2017/2/14.
 */

public interface NewsListView {
    /**
     * 显示加载框
     */
    void showLoading();
    /**
     * 隐藏加载框
     */
    void hideLoading();
    /**
     * 显示新闻列表
     *
     * @param list 数据
     */
    void showNewsList(List<NewsListBean> list);
    /**
     * 显示提示语
     *
     * @param msg
     */
    void showTips(String msg);
}
