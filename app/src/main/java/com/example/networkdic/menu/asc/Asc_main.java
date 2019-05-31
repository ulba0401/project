package com.example.networkdic.menu.asc;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SectionIndexer;

import com.example.networkdic.MainActivity;
import com.example.networkdic.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.networkdic.task.indexList.ContentAdapter;
import com.example.networkdic.task.indexList.IndexableListView;
import com.example.networkdic.task.indexList.StringMatcher;
import com.example.networkdic.vos.DiclistVO;

import static com.example.networkdic.R.layout.asc_main_fragment;

public class Asc_main extends Fragment {
    MainActivity activity;
    private ArrayList<DiclistVO> dlist;
    private IndexableListView mListView;

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
        ViewGroup rootView = (ViewGroup) inflater.inflate(asc_main_fragment, container, false);

        //사용할 데이터 집어넣기
        dlist = new ArrayList<>();

        ContentAdapter adapter = new ContentAdapter(getContext(), R.layout.list_drawer_listview, dlist);

        mListView = rootView.findViewById(R.id.asc_list);
        mListView.setAdapter(adapter);
        mListView.setFastScrollEnabled(true);



        return rootView;
    }


}
