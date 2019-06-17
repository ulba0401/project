package com.example.networkdic.menu.unit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.networkdic.MainActivity;
import com.example.networkdic.R;
import com.example.networkdic.task.adapter.UnitAdapter;
import com.example.networkdic.task.crud.SelectList;
import com.example.networkdic.task.crud.WordDetail;
import com.example.networkdic.vos.DiclistVO;

import java.util.ArrayList;

import static com.example.networkdic.R.layout.unit_main_fragment;

public class Unit_main extends Fragment {
    MainActivity activity;
    ArrayList<DiclistVO> dlist;
    SelectList select;
    UnitAdapter adapter;
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(unit_main_fragment, container, false);
        listView = rootView.findViewById(R.id.unit_list);

        dlist = new ArrayList<>();
        adapter = new UnitAdapter(getActivity(), R.layout.unit_drawer_listview, dlist);
        listView.setAdapter(adapter);

        select = new SelectList(dlist, adapter, "unit");
        select.execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DiclistVO vo = (DiclistVO) adapter.getItem(position);
                Intent intent = new Intent(getActivity(), WordDetail.class);
                intent.putExtra("vo", vo);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
