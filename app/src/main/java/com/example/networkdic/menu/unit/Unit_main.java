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
import android.widget.Button;
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
    Button  unit1, unit2, unit3, unit4, unit5, unit6, unit7, unit8, unit9, unit10,
            unit11, unit12, unit13, unit14, unit15, unit16, unit17, unit18, unit19, unit20,
            unit21, unit22, unit23, unit24, unit25, unit26, unit27, unit28, unit29, unit30,
            unit31, unit32, unit33, unit34, unit35, unit36;

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
        listView = rootView.findViewById(R.id.unit_list);//에러아님;;

        dlist = new ArrayList<>();
        adapter = new UnitAdapter(getActivity(), R.layout.unit_drawer_listview, dlist);
        listView.setAdapter(adapter);

        unit1 = rootView.findViewById(R.id.unit1);
        unit2 = rootView.findViewById(R.id.unit2);
        unit3 = rootView.findViewById(R.id.unit3);
        unit4 = rootView.findViewById(R.id.unit4);
        unit5 = rootView.findViewById(R.id.unit5);
        unit6 = rootView.findViewById(R.id.unit6);
        unit7 = rootView.findViewById(R.id.unit7);
        unit8 = rootView.findViewById(R.id.unit8);
        unit9 = rootView.findViewById(R.id.unit9);
        unit10 = rootView.findViewById(R.id.unit10);
        unit11 = rootView.findViewById(R.id.unit11);
        unit12 = rootView.findViewById(R.id.unit12);
        unit13 = rootView.findViewById(R.id.unit13);
        unit14 = rootView.findViewById(R.id.unit14);
        unit15 = rootView.findViewById(R.id.unit15);
        unit16 = rootView.findViewById(R.id.unit16);
        unit17 = rootView.findViewById(R.id.unit17);
        unit18 = rootView.findViewById(R.id.unit18);
        unit19 = rootView.findViewById(R.id.unit19);
        unit20 = rootView.findViewById(R.id.unit20);
        unit21 = rootView.findViewById(R.id.unit21);
        unit22 = rootView.findViewById(R.id.unit22);
        unit23 = rootView.findViewById(R.id.unit23);
        unit24 = rootView.findViewById(R.id.unit24);
        unit25 = rootView.findViewById(R.id.unit25);
        unit26 = rootView.findViewById(R.id.unit26);
        unit27 = rootView.findViewById(R.id.unit27);
        unit28 = rootView.findViewById(R.id.unit28);
        unit29 = rootView.findViewById(R.id.unit29);
        unit30 = rootView.findViewById(R.id.unit30);
        unit31 = rootView.findViewById(R.id.unit31);
        unit32 = rootView.findViewById(R.id.unit32);
        unit33 = rootView.findViewById(R.id.unit33);
        unit34 = rootView.findViewById(R.id.unit34);
        unit35 = rootView.findViewById(R.id.unit35);
        unit36 = rootView.findViewById(R.id.unit36);


        //각 단원별 이동 START
        unit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 1);
                select.execute();
            }
        });

        unit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 2);
                select.execute();
            }
        });

        unit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 3);
                select.execute();
            }
        });

        unit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 4);
                select.execute();
            }
        });

        unit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 5);
                select.execute();
            }
        });

        unit6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 6);
                select.execute();
            }
        });

        unit7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 7);
                select.execute();
            }
        });

        unit8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 8);
                select.execute();
            }
        });

        unit9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 9);
                select.execute();
            }
        });

        unit10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 10);
                select.execute();
            }
        });

        unit11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 11);
                select.execute();
            }
        });

        unit12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 12);
                select.execute();
            }
        });

        unit13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 13);
                select.execute();
            }
        });

        unit14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 14);
                select.execute();
            }
        });

        unit15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 15);
                select.execute();
            }
        });

        unit16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 16);
                select.execute();
            }
        });

        unit17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 17);
                select.execute();
            }
        });

        unit18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 18);
                select.execute();
            }
        });

        unit19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 19);
                select.execute();
            }
        });

        unit20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 20);
                select.execute();
            }
        });

        unit21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 21);
                select.execute();
            }
        });

        unit22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 22);
                select.execute();
            }
        });

        unit23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 23);
                select.execute();
            }
        });

        unit24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 24);
                select.execute();
            }
        });

        unit25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 25);
                select.execute();
            }
        });

        unit26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 26);
                select.execute();
            }
        });

        unit27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 27);
                select.execute();
            }
        });

        unit28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 28);
                select.execute();
            }
        });

        unit29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 29);
                select.execute();
            }
        });

        unit30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 30);
                select.execute();
            }
        });

        unit31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 31);
                select.execute();
            }
        });

        unit32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 32);
                select.execute();
            }
        });

        unit33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 33);
                select.execute();
            }
        });

        unit34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 34);
                select.execute();
            }
        });

        unit35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 35);
                select.execute();
            }
        });

        unit36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = new SelectList(dlist, adapter, "unit", 36);
                select.execute();
            }
        });




        //전체 리스트 조회
        select = new SelectList(dlist, adapter, "unit");
        select.execute();


        //상세페이지 이동
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
