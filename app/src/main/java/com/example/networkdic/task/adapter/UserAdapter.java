package com.example.networkdic.task.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networkdic.R;
import com.example.networkdic.vos.UserVO;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<UserVO> arrayList;
    LayoutInflater inflater;

    public UserAdapter(Context context, int layout, ArrayList<UserVO> arrayList){
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arrayList = arrayList;
        this.layout = layout;
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
        final UserViewHolder viewHolder;

        if (convertView == null){
            convertView = inflater.inflate(layout,parent,false);

            viewHolder = new UserViewHolder();
            viewHolder.id = convertView.findViewById(R.id.uid);
            viewHolder.name = convertView.findViewById(R.id.uname);
            viewHolder.isadmin = convertView.findViewById(R.id.isadmin);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (UserViewHolder) convertView.getTag();
        }
        viewHolder.id.setText(arrayList.get(position).getId());
        viewHolder.name.setText(arrayList.get(position).getName());
        if (arrayList.get(position).getAdmin().equals("1")) {
            viewHolder.isadmin.setVisibility(View.VISIBLE);
        } else if (arrayList.get(position).getAdmin().equals("0")) {
            viewHolder.isadmin.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    public static class UserViewHolder{
        public TextView id;
        public TextView name;
        public ImageView isadmin;
    }
}
