package com.example.Backend.mailServerSystem.FacadeDesignPattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.Backend.mailServerSystem.CommandDesignPattern.mailServerAccess;

public class createUserFolderFacade {
    private Long id;
    private String name;

    mailServerAccess access;

    public createUserFolderFacade(Long id, String name) {
        this.id = id;
        this.name = name;
        access = new mailServerAccess(this.id);
    }

    public void create() {
        JSONObject obj = new JSONObject();
        JSONArray arr =new JSONArray();
        obj.put("emails", arr);
        obj.put("name", name);

        access.createFolder(obj);
}
}
