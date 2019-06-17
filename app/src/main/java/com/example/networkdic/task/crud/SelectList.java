package com.example.networkdic.task.crud;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.networkdic.task.adapter.UnitAdapter;
import com.example.networkdic.task.common.ReadMessage;
import com.example.networkdic.task.indexList.ContentAdapter;
import com.example.networkdic.vos.DiclistVO;
import com.example.networkdic.vos.UserVO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import static com.example.networkdic.task.common.CommonMethod.ipConfig;

public class SelectList extends AsyncTask<ArrayList<DiclistVO>, Void, ArrayList<DiclistVO>> {

    ArrayList<DiclistVO> dlist;
    UnitAdapter adapter;
    String methode;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dlist.clear();
    }

    @Override
    protected void onPostExecute(ArrayList<DiclistVO> diclistVOS) {
        super.onPostExecute(diclistVOS);
        if (methode.equals("unit")){
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected ArrayList<DiclistVO> doInBackground(ArrayList<DiclistVO>... voids) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        HttpResponse httpResponse = null;
        HttpEntity httpEntity = null;

        String result = "";
        String postURL = "";

        postURL = ipConfig + "/cnd/wordselect?methode=" + methode;


        try {
            //MultipartEntityBuild  생성
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.setCharset(Charset.forName("UTF-8"));

            //전송
            InputStream inputStream = null;
            httpClient = AndroidHttpClient.newInstance("Android");
            httpPost = new HttpPost(postURL);
            httpPost.setEntity(builder.build());

            httpResponse = httpClient.execute(httpPost);
            httpEntity = httpResponse.getEntity();
            inputStream = httpEntity.getContent();

            readJsonStream(inputStream);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if(httpEntity != null){
                httpEntity = null;
            }
            if(httpResponse != null){
                httpResponse = null;
            }
            if(httpPost != null){
                httpPost = null;
            }
            ((AndroidHttpClient) httpClient).close();
        }

        return dlist;
    }

    private void readJsonStream(InputStream inputStream)throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

        try {
            reader.beginArray();

            while (reader.hasNext()) {
                dlist.add(new ReadMessage().wordReadMessage(reader));
            }

        } finally {
            reader.close();
        }
    }

    public SelectList(ArrayList<DiclistVO> dlist, UnitAdapter adapter, String methode){
        this.dlist = dlist;
        this.adapter = adapter;
        this.methode = methode;
    }

    public SelectList(ArrayList<DiclistVO> dlist, String methode){
        this.dlist = dlist;
        this.methode = methode;
    }
}
