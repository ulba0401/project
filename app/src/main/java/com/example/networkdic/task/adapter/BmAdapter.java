package com.example.networkdic.task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.networkdic.R;
import com.example.networkdic.vos.DiclistVO;

public class BmAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<DiclistVO> arrayList;
    LayoutInflater inflater;

    public BmAdapter(Context context, int layout, ArrayList<DiclistVO> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final BmViewHolder viewHolder;

        if (convertView == null){
            convertView = inflater.inflate(layout, parent, false);

            viewHolder = new BmViewHolder();

            viewHolder.abb = convertView.findViewById(R.id.list_title);
        }else{
            viewHolder = (BmViewHolder) convertView.getTag();
        }

        viewHolder.abb.setText(arrayList.get(position).getAbbword());

        return convertView;
    }

    public static class BmViewHolder{
        public TextView abb;
    }
}
