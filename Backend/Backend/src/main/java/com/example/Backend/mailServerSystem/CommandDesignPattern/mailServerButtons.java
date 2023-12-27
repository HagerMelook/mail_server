package com.example.Backend.mailServerSystem.CommandDesignPattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface mailServerButtons {
    public String getData(String folderName);
    public String getMail();
    public void createFolder(JSONObject folder);
    public String getUserFolder();
    public String getEmailInUserFolder();
    public String deleteEmail();
    public String deleteFolder();
    public String deleteEmailInFolder();
}
