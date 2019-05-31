package com.example.networkdic.task.common;

import android.util.JsonReader;

import com.example.networkdic.vos.DiclistVO;

import java.io.IOException;

public class ReadMessage {
    public DiclistVO ascReadMessage(JsonReader reader) throws IOException{
        String abb = "", full = "", expln = "", koword = "";

        reader.beginObject();
        while (reader.hasNext()){
            String readStr = reader.nextName();
            if(readStr.equals("ABBWORK")){
                abb = reader.nextString();
            }else if (readStr.equals("FULLNAME")){
                full = reader.nextString();
            }else if (readStr.equals("EXPLANATION")){
                expln = reader.nextString();
            }else if (readStr.equals("KORWORD")){
                koword = reader.nextString();
            }else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new DiclistVO(abb, full, expln, koword);
    }
}
