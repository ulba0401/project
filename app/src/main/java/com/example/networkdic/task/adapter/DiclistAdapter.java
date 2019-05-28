package com.example.networkdic.task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.networkdic.R;
import com.example.networkdic.vos.DiclistVO;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DiclistAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<DiclistVO> arrayList;
    LayoutInflater inflater;

    public DiclistAdapter(Context context, int layout, ArrayList<DiclistVO> arrayList) {
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout;
        this.arrayList = arrayList;
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
        final DiclistViewHolder viewHolder;

        if (convertView == null){
            convertView = inflater.inflate(layout, parent, false);

            viewHolder = new DiclistViewHolder();
            viewHolder.abb = convertView.findViewById(R.layout.list_drawer_listview);
        }

        return null;
    }

    public static class DiclistViewHolder{
        public TextView abb;


    }

}
