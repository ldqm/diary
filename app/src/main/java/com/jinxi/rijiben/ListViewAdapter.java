package com.jinxi.rijiben;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListViewAdapter extends BaseAdapter {


    private List<DiaryBean> mList;
    private Context mContext;


    public ListViewAdapter(List<DiaryBean> mList, Context context) {
        this.mList = mList;
        this.mContext = context;
    }


    /**
     * 获取适配器显示数据源的个数
     *
     * @return
     */
    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 获取某个位置上的数据
     */
    @Override
    public DiaryBean getItem(int position) {
        if (mList == null) {
            return null;
        }
        return mList.get(position);
    }

    /**
     * 更新某个位置上的数据
     */
    public void setItem(int position, DiaryBean item) {
        if (mList == null) {
            mList = new ArrayList<DiaryBean>();
        }
        mList.set(position, item);
        notifyDataSetChanged();
    }


    /**
     * 获取每一项的视图
     *
     * @param position
     * @param view
     * @param viewGroup
     * @return
     */
    @SuppressLint({"ViewHolder", "InflateParams", "SetTextI18n"})
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.tvDate = (TextView) view.findViewById(R.id.tvDate);
            holder.tvYear = (TextView) view.findViewById(R.id.tvYear);
            holder.tvContent = (TextView) view.findViewById(R.id.tvContent);
            holder.tvWeather = (TextView) view.findViewById(R.id.tvWeather);
            holder.tvMood = (TextView) view.findViewById(R.id.tvMood);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }


        DiaryBean diaryBean = mList.get(position);

        holder.tvDate.setText(diaryBean.getMonth() + "/" + diaryBean.getDay());
        holder.tvYear.setText(diaryBean.getYear());
        holder.tvContent.setText(diaryBean.getContent());
        holder.tvWeather.setText(diaryBean.getWeather());
        holder.tvMood.setText(diaryBean.getMood());

        return view;
    }


    class ViewHolder {
        TextView tvDate;
        TextView tvYear;
        TextView tvContent;
        TextView tvWeather;
        TextView tvMood;
    }

}
