package com.example.networkdic.menu.user;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.networkdic.MainActivity;
import com.example.networkdic.R;
import com.example.networkdic.task.adapter.UserAdapter;
import com.example.networkdic.task.crud.SelectUser;
import com.example.networkdic.vos.UserVO;

import java.io.Serializable;
import java.util.ArrayList;


public class User_main extends Fragment implements Serializable {
    MainActivity activity;
    ArrayList<UserVO> ulist;
    SelectUser select;
    UserAdapter adapter;
    ListView listView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.user_main_fragment, container, false);
        listView = rootView.findViewById(R.id.user_list);

        //사용할 데이터 집어넣기
        ulist = new ArrayList<>();
        adapter = new UserAdapter(getActivity(), R.layout.user_drawer_listview, ulist);
        listView.setAdapter(adapter);

        select = new SelectUser(ulist, adapter);
        select.execute();


        return rootView;
    }
}
