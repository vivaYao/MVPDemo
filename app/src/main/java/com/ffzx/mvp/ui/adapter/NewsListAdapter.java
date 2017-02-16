package com.ffzx.mvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ffzx.mvp.R;
import com.ffzx.mvp.model.bean.NewsListBean;
import com.ffzx.mvp.utils.ImageLoaderUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/2/14.
 */

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<NewsListBean> mData;

    private Context mContext;

    public NewsListAdapter(Context context) {
        mContext = context;
    }

    public void setmData(List<NewsListBean> mData) {
        this.mData = mData;
        this.notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View news = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false);
        ItemViewHolder vh = new ItemViewHolder(news);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            NewsListBean dataBean = mData.get(position);
            ((ItemViewHolder) holder).mTitle.setText(dataBean.getTitle());
            ((ItemViewHolder) holder).mDesc.setText(dataBean.getDigest());
            ImageLoaderUtils.display(mContext, ((ItemViewHolder) holder).mNewsImg, dataBean.getImgsrc());
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTitle;
        public TextView mDesc;
        public ImageView mNewsImg;

        public ItemViewHolder(View v) {
            super(v);
            mTitle = (TextView) v.findViewById(R.id.tvTitle);
            mDesc = (TextView) v.findViewById(R.id.tvDesc);
            mNewsImg = (ImageView) v.findViewById(R.id.ivNews);
            v.setOnClickListener(this);//给item注册点击监听 必须写
        }

        @Override
        public void onClick(View v) {

        }
    }
}
