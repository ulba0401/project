package com.example.networkdic.menu.notice;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.networkdic.MainActivity;
import com.example.networkdic.R;

import static com.example.networkdic.R.layout.notice_main_fragment;

public class Notice_main extends Fragment {
    MainActivity activity;
    ListView notice_list;

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
        ViewGroup rootView = (ViewGroup) inflater.inflate(notice_main_fragment, container, false);

        notice_list = rootView.findViewById(R.id.notice_list);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(), R.array.notice, R.layout.notice_drawer_listview);
        notice_list.setAdapter(adapter);

        return rootView;
    }
}
