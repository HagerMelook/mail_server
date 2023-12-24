package com.example.Backend.mailServerSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class mailServer implements mailServerButtons {

    private JSONArray usersArray;
    private Long userId;
    
    public mailServer(Long userId) {
        this.userId = userId;
    }

    private void setUsersArray(){
        usersArray = readJSONSystem();
    }

    private JSONArray readJSONSystem() {
        File file = new File("C:\\Users\\noura\\OneDrive\\Desktop\\mailServer\\mail_server\\Backend\\Backend\\users.json");
        JSONParser jp = new JSONParser();
        JSONArray array;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            if (file.length() == 0) {
                array = new JSONArray();
            } else {
                array = (JSONArray) jp.parse(br);
            }
            br.close();
            return array;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getInboxMails() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray inboxMails = (JSONArray) obj.get("inbox");
                return inboxMails.toJSONString();
            }
        }
        return null;
    }

    public String getTrashMails() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray trashMails = (JSONArray) obj.get("trash");
                return trashMails.toJSONString();
            }
        }
        return null;
    }

    public String getDraftMails() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray draftMails = (JSONArray) obj.get("draft");
                return draftMails.toJSONString();
            }
        }
        return null;
    }

    public String getSentMails() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray draftMails = (JSONArray) obj.get("sent");
                return draftMails.toJSONString();
            }
        }
        return null;
    }

    public String getContacts() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray draftMails = (JSONArray) obj.get("contacts");
                return draftMails.toJSONString();
            }
        }
        return null;
    }


}
