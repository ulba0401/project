package com.example.networkdic.task.common;

import android.util.JsonReader;

import com.example.networkdic.vos.DiclistVO;
import com.example.networkdic.vos.UserVO;

import java.io.IOException;

public class ReadMessage {
    public DiclistVO wordReadMessage(JsonReader reader) throws IOException{
        String abb = "", full = "", expln = "", koword = "", unit="";

        reader.beginObject();
        while (reader.hasNext()){
            String readStr = reader.nextName();
            if(readStr.equals("abbword")){
                abb = reader.nextString();
            }else if (readStr.equals("fullname")){
                full = reader.nextString();
            }else if (readStr.equals("explanation")){
                expln = reader.nextString();
            }else if (readStr.equals("korword")){
                koword = reader.nextString();
            }else if (readStr.equals("unit")){
                unit = reader.nextString();
            }else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new DiclistVO(abb, full, expln, koword, unit);
    }

    public UserVO userReadMessage(JsonReader reader) throws IOException {
        String id="", pw="", email="", admin="", name="";

        reader.beginObject();
        while (reader.hasNext()){
            String readStr = reader.nextName();
            if(readStr.equals("id")){
                id = reader.nextString();
            }else if (readStr.equals("pw")){
                pw = reader.nextString();
            }else if (readStr.equals("email")){
                email = reader.nextString();
            }else if (readStr.equals("admin")){
                admin = reader.nextString();
            }else if (readStr.equals("name")){
                name = reader.nextString();
            }else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new UserVO(id, pw, name, email, admin);

    }
}
