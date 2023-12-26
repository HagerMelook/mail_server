package com.example.Backend.mailServerSystem.FacadeDesignPattern;

import org.json.simple.JSONObject;

public class MailBody {

    private String body;

    public MailBody(String body) {
        this.body = body;
    }

    public JSONObject getBody(JSONObject obj) {
        obj.put("text", body);
        return obj;
    }

}
