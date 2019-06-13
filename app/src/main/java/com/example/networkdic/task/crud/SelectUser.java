package com.example.networkdic.task.crud;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.JsonReader;

import com.example.networkdic.task.common.ReadMessage;
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

public class SelectUser extends AsyncTask <ArrayList<UserVO>, Void, ArrayList<UserVO>> {

    ArrayList<UserVO> ulist;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        ulist.clear();
    }


    @Override
    protected ArrayList<UserVO> doInBackground(ArrayList<UserVO>... voids) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        HttpResponse httpResponse = null;
        HttpEntity httpEntity = null;

        String postURL = "";

        postURL = ipConfig + "/cnd/userselect";


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
        return ulist;
    }

    private void readJsonStream(InputStream inputStream)throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

        try {
            reader.beginArray();

            while (reader.hasNext()) {
                ulist.add(new ReadMessage().userReadMessage(reader));
        }

        } finally {
            reader.close();
        }
    }
}
