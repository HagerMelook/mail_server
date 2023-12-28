package com.example.Backend.mailServerSystem.FacadeDesignPattern;

import java.util.Queue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.Backend.mailServerSystem.CommandDesignPattern.mailServerAccess;

public class MailSender {
    private Queue<String> sendee;
    private JSONArray array;
    private mailServerAccess obj;

    public MailSender(Queue<String> sendee) {
        this.sendee = sendee;
        obj = new mailServerAccess();
    }

    public void send(JSONObject email) {
        array = obj.readJSONSystem();
        for(String receiver : sendee) {
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = (JSONObject) array.get(i);
                System.out.println(obj.get("email").equals(receiver));
                if (obj.get("email").equals(receiver)) {
                    JSONArray folder = (JSONArray) obj.get("inbox");
                    email.put("id", folder.size() + 1);
                    folder.add(email);
                    break;
                }
            }
        }
        obj.updateJSON(array);
    }

}
