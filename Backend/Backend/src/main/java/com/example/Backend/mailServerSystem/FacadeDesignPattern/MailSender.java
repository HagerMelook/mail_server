package com.example.Backend.mailServerSystem.FacadeDesignPattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.Backend.mailServerSystem.CommandDesignPattern.mailServerAccess;

public class MailSender {
    private String sendee;
    private JSONArray array;
    private mailServerAccess obj;

    public MailSender(String sendee) {
        this.sendee = sendee;
        obj = new mailServerAccess();
    }

    public void send(JSONObject email) {
        array = obj.readJSONSystem();
        for(int i = 0; i < array.size(); i++){
            JSONObject obj = (JSONObject)array.get(i);
            // for(int k = 0; k < sendee.size(); k++){
                if(obj.get("email").equals(sendee)){
                JSONArray folder = (JSONArray)obj.get("inbox");
                email.put("id", folder.size() + 1);
                folder.add(email);
                break;
            }
            // }
           
        }
       obj.updateJSON(array);
    }
    

}
