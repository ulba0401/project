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

import com.example.networkdic.task.indexList.IndexableListView;
import com.example.networkdic.task.indexList.StringMatcher;
import com.example.networkdic.vos.DiclistVO;

import static com.example.networkdic.R.layout.asc_main_fragment;

public class Asc_main extends Fragment {
    MainActivity activity;
    private ArrayList<DiclistVO> mItems;
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

        mItems = new ArrayList<DiclistVO>();
        //사용할 데이터 집어넣기

        for (int i = 0; i < 10; i++){

            Collections.sort(mItems);
        }
        ContentAdapter adapter = new ContentAdapter(getContext(), R.layout.list_drawer_listview, mItems);

        mListView = rootView.findViewById(R.id.asc_list);
        mListView.setAdapter(adapter);
        mListView.setFastScrollEnabled(true);
        return rootView;
    }

    private class ContentAdapter extends ArrayAdapter<DiclistVO> implements SectionIndexer {

        private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public ContentAdapter(Context context, int textViewResourceId,
                              List<DiclistVO> objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public int getPositionForSection(int section) {
            // If there is no item for current section, previous section will be selected
            for (int i = section; i >= 0; i--) {
                for (int j = 0; j < getCount(); j++) {
                    if (i == 0) {
                        // For numeric section
                        for (int k = 0; k <= 9; k++) {
                            if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)), String.valueOf(k)))
                                return j;
                        }
                    } else {
                        if (StringMatcher.match(String.valueOf(getItem(j).charAt(0)), String.valueOf(mSections.charAt(i))))
                            return j;
                    }
                }
            }
            return 0;
        }

        @Override
        public int getSectionForPosition(int position) {
            return 0;
        }

        @Override
        public Object[] getSections() {
            String[] sections = new String[mSections.length()];
            for (int i = 0; i < mSections.length(); i++)
                sections[i] = String.valueOf(mSections.charAt(i));
            return sections;
        }
    }
}
