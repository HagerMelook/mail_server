package com.example.Backend.mailServerSystem.CommandDesignPattern;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class mailServer implements mailServerButtons {

    private JSONArray usersArray;
    private Long userId;
    private Long mailId;
    private String folderName;
    
    public mailServer(Long mailId, String folderName, Long userId) {
        this.mailId = mailId;
        this.folderName = folderName;
        this.userId = userId;
    }

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

    public String getData(String folderName) {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray Mails = (JSONArray) obj.get(folderName);
                return Mails.toJSONString();
            }
        }
        return null;
    }

    public String getMail() {
        setUsersArray();
        for (int i = 0; i < usersArray.size(); i++) {
            JSONObject obj = (JSONObject) usersArray.get(i);
            if (obj.get("id").equals(userId)) {
                JSONArray Mails = (JSONArray) obj.get(folderName);
                for(int j = 0; j < Mails.size(); j++){
                    JSONObject theMail = (JSONObject) Mails.get(j);
                    if(theMail.get("id").equals(mailId))
                        return theMail.toJSONString();
                }
            }
        }
        return null;
    }

}
