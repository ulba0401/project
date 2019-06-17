package com.example.networkdic.menu.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.networkdic.MainActivity;
import com.example.networkdic.R;

import static com.example.networkdic.R.layout.main_main_fragment;

public class Main_main extends Fragment {
    MainActivity activity;
    Button btn_asc, btn_unit, btn_notice, btn_bookmark;

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
        ViewGroup rootView = (ViewGroup) inflater.inflate(main_main_fragment, container, false);
        btn_asc = rootView.findViewById(R.id.btn_asc);
        btn_unit = rootView.findViewById(R.id.btn_unit);
        btn_notice = rootView.findViewById(R.id.btn_notice);
        btn_bookmark = rootView.findViewById(R.id.btn_bookmark);

        btn_asc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(2);
            }
        });

        btn_bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(4);
            }
        });

        btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(5);
            }
        });

        btn_unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChange(3);
            }
        });
        return rootView;
    }
}
