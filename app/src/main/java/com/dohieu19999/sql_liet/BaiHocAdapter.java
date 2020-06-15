package com.dohieu19999.sql_liet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BaiHocAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<BaiHoc> baiHocList;

    public BaiHocAdapter(Context context, int layout, List<BaiHoc> baiHocList) {
        this.context = context;
        this.layout = layout;
        this.baiHocList = baiHocList;
    }

    @Override
    public int getCount() {
        return baiHocList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        TextView tvTen;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            viewHolder.tvTen = convertView.findViewById(R.id.tvName);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        BaiHoc baiHoc = baiHocList.get(position);
        viewHolder.tvTen.setText(baiHoc.getNameBaiHoc());
        return convertView;
    }
}
