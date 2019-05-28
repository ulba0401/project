package com.example.networkdic.task.crud;

import android.os.AsyncTask;

import com.example.networkdic.vos.DiclistVO;

import java.util.ArrayList;

public class Select extends AsyncTask<Void, Void, Void> {

    ArrayList<DiclistVO> dlist;

    DiclistAdapter dadapter;

    int controller;
    String id;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (controller == 1) { dlist.clear(); }
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (controller == 1) {dadapter.notifyDataSetChanged();}
    }
}
