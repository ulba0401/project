package com.example.networkdic.menu.asc;

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

import com.example.networkdic.MainActivity;
import com.example.networkdic.R;

import java.util.ArrayList;

import com.example.networkdic.task.crud.SelectList;
import com.example.networkdic.task.crud.WordDetail;
import com.example.networkdic.task.indexList.ContentAdapter;
import com.example.networkdic.task.indexList.IndexableListView;
import com.example.networkdic.vos.DiclistVO;

import static com.example.networkdic.R.layout.asc_main_fragment;

public class Asc_main extends Fragment {
    MainActivity activity;
    ArrayList<DiclistVO> dlist = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    private IndexableListView mListView;
    SelectList select;

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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(asc_main_fragment, container, false);

        //사용할 데이터 조회해서 집어넣기
        try {
            select = new SelectList(dlist, "asc");
            dlist = select.execute().get();

            for (int i = 0; i < dlist.size(); i++){
                list.add(dlist.get(i).getAbbword());
            }

            final ContentAdapter adapter =
                    new ContentAdapter(getContext(), R.layout.list_drawer_listview, list);

            mListView = rootView.findViewById(R.id.asc_list);
            mListView.setAdapter(adapter);
            mListView.setFastScrollEnabled(true);

            //각 항목 클릭시 상세화면으로 이동
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    DiclistVO vo = (DiclistVO) dlist.get(position);
                    Intent intent = new Intent(getActivity(), WordDetail.class);
                    intent.putExtra("vo", vo);
                    startActivity(intent);
                }
        });

        } catch (Exception e){
            e.getMessage();
        }

        return rootView;
    }


}
