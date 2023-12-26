package com.example.Backend.mailServerSystem.FacadeDesignPattern;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MailHeader {

    private String to;
    private String from;
    private String about;
    private String date; 
    private String importance;

    public MailHeader(String to, String from, String about, String date, String importance) {
        this.to = to;
        this.from = from;
        this.about = about;
        this.date = date;
        this.importance = importance;
    }

    public JSONObject getHeader(){
        JSONObject obj = new JSONObject();
        obj.put("sender", from);
        obj.put("receiver", to);
        obj.put("date", date);
        obj.put("importance", importance);
        obj.put("subject", about);
        return obj;
    }
}
