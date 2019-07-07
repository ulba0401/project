package com.example.networkdic.login;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.widget.Toast;

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

import static com.example.networkdic.task.common.CommonMethod.ipConfig;


public class LoginRequest extends AsyncTask<Void,Void,Integer> {

    Context context;
    public static UserVO vo = new UserVO();
    private String id;
    private String pw;
    private String admin;
    boolean is_check = true;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    public LoginRequest(String id, String pw, Context context){
        this.id = id;
        this.pw = pw;
        this.context = context;
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        HttpResponse httpResponse = null;
        HttpEntity httpEntity = null;

        String postURL = ipConfig+"/AA/AloginRequest?id="+id+"&pw="+pw;
        try {
            //MultipartEntityBuild  생성
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

            //전송
            InputStream inputStream = null;
            httpClient = AndroidHttpClient.newInstance("Android");
            httpPost = new HttpPost(postURL);
            httpPost.setEntity(builder.build());

            httpResponse = httpClient.execute(httpPost);
            httpEntity = httpResponse.getEntity();
            inputStream = httpEntity.getContent();
            /*String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            line = br.readLine();
            if(line.equals("fail")){
                is_check = false;
                return 0;
            }else{
                is_check = true;
            }*/
            readJsonStream(inputStream);
        } catch (Exception e){
            e.printStackTrace();
        }finally {

            ((AndroidHttpClient) httpClient).close();
            if(vo.getResult() != null && vo.getResult().equals("fail")){
                return 0;
            }
            vo.setLogintype(true);
            return 1;
        }
    }

    private void readJsonStream(InputStream inputStream) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));

        try {
            reader.beginObject();
            while (reader.hasNext()){
                readMessage(reader);
            }
            reader.endObject();
        }finally {
            reader.close();
        }
    }

    @Override
    protected void onPostExecute(Integer check) {
        super.onPostExecute(check);
        if(!is_check) {
            Toast.makeText(context, "아이디와 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    private void readMessage(JsonReader reader) throws IOException {
        String name = "", phone="", addr="", id="", pw="", email="", admin="", result="";

        while (reader.hasNext()){
            String readStr = reader.nextName();
            if(readStr.equals("result")){
                result = reader.nextString();
                vo.setResult(result);
            }else if(readStr.equals("name")){
                name = reader.nextString();
                vo.setName(name);
                vo.setResult("success");
            }else if (readStr.equals("id")){
                id = reader.nextString();
                vo.setId(id);
            }else if (readStr.equals("pw")){
                pw = reader.nextString();
                vo.setPw(pw);
            }else if (readStr.equals("email")){
                email = reader.nextString();
                vo.setEmail(email);
            }else if(readStr.equals("admin")){
                admin=reader.nextString();
                vo.setAdmin(admin);
            }else{
                reader.skipValue();
            }
        }

    }
}
