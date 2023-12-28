package com.example.Backend.mailServerSystem.FacadeDesignPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class attachment {

    private boolean attachment;

    public attachment(boolean attachment) {
        this.attachment = attachment;
    }

    public JSONObject getAttachement(JSONObject obj) {
        File file = new File(
                "C:\\Users\\noura\\OneDrive\\Desktop\\mailServer\\mail_server\\Backend\\Backend\\src\\main\\java\\com\\example\\Backend\\file_metadata.json");
        JSONParser jp = new JSONParser();
        JSONArray array;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            array = (JSONArray) jp.parse(br);
            br.close();
            obj.put("attachment", attachment);
            obj.put("attachments", array);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
