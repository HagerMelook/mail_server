package com.example.Backend.mailServerSystem.FacadeDesignPattern;

import org.json.simple.JSONObject;

import com.example.Backend.mailServerSystem.CommandDesignPattern.mailServerAccess;

public class ContactCreatorFacade {
    private Long id;
    private Contact body;

    mailServerAccess access;

    public ContactCreatorFacade(Long id, Contact body) {
        this.id = id;
        this.body = body;
        access = new mailServerAccess();
    }

    public void create() {
        JSONObject obj = new JSONObject();
        obj.put("email", body.getEmail());
        obj.put("name", body.getName());

        access.addJSONEamilToUser(obj, id, "contacts");

    }
    
}
