package com.example.Backend.mailServerSystem.FacadeDesignPattern;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.example.Backend.Attachment;

public class attachment{

    private List<Attachment> attachments;
    private boolean attachment;
    
    public attachment(List<Attachment> attachments, boolean attachment) {
        System.out.println(attachments.get(0));
        this.attachments = new ArrayList<>(attachments);
        this.attachment = attachment;
    }

    public JSONObject getAttachement(JSONObject obj) {
        obj.put("attachment", attachment);
        obj.put("attachments", attachments);
        return obj;
    }
    
}
