package com.example.Backend.mailServerSystem.FacadeDesignPattern;

import org.json.simple.JSONArray;

public class userFoldersClass {
    private String name;
    private JSONArray emails;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public JSONArray getEmails() {
        return emails;
    }
    public void setEmails(JSONArray emails) {
        this.emails = emails;
    }
    
    
}
