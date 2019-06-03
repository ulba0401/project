package com.example.networkdic.task.common;

import android.util.JsonReader;

import com.example.networkdic.vos.DiclistVO;

import java.io.IOException;

public class ReadMessage {
    public DiclistVO ascReadMessage(JsonReader reader) throws IOException{
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
}
