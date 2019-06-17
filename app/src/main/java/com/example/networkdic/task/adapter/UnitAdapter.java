package com.example.networkdic.task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.networkdic.R;
import com.example.networkdic.vos.DiclistVO;

import java.util.ArrayList;

public class UnitAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<DiclistVO> arrayList;
    LayoutInflater inflater;

    public UnitAdapter(Context context, int layout, ArrayList<DiclistVO> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
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
        final UnitViewHolder viewHolder;

        if (convertView == null){
            convertView = inflater.inflate(layout, parent, false);

            viewHolder = new UnitViewHolder();
            viewHolder.abb = convertView.findViewById(R.id.uabb);
            viewHolder.unit = convertView.findViewById(R.id.uunit);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (UnitViewHolder) convertView.getTag();
        }

        viewHolder.abb.setText(arrayList.get(position).getAbbword());
        viewHolder.unit.setText(arrayList.get(position).getUnit());

        return convertView;
    }
    public  static class UnitViewHolder{
        public TextView abb;
        public TextView unit;
    }
}
