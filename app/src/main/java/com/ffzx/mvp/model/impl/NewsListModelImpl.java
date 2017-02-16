package com.ffzx.mvp.model.impl;

import com.ffzx.mvp.model.INewsListModel;
import com.ffzx.mvp.model.bean.NewsListBean;
import com.ffzx.mvp.utils.NewsJsonUtils;
import com.ffzx.mvp.utils.OkHttpUtils;

import java.util.List;

/**
 * M层的实现类
 * Created by Administrator on 2017/2/14.
 */
public class NewsListModelImpl implements INewsListModel {

    private String url = "http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html";
    private String id = "T1348647909107";

    @Override
    public void getNewsList(final OnLoadNewsDataListener listener) {

        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<NewsListBean> dataBeans = NewsJsonUtils.readJsonDataBeans(response, id);
                listener.onSuccess(dataBeans);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("数据加载异常", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    /**
     * 回调接口
     */
    public interface OnLoadNewsDataListener {
        void onSuccess(List<NewsListBean> list);

        void onFailure(String str, Exception e);
    }

}
