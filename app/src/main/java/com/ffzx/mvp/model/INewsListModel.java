package com.ffzx.mvp.model;

import com.ffzx.mvp.model.impl.NewsListModelImpl;

/**
 * Created by Administrator on 2017/2/14.
 */

public interface INewsListModel {

    void getNewsList(NewsListModelImpl.OnLoadNewsDataListener listener);
}
