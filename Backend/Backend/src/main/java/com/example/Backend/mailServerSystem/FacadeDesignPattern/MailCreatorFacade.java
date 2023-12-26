package com.example.Backend.mailServerSystem.FacadeDesignPattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.example.Backend.Email;
import com.example.Backend.mailServerSystem.CommandDesignPattern.mailServerAccess;

public class MailCreatorFacade {

    private Email mail;
    private Long userId;
    private String folderName;

    MailSender sender;
    attachment attachment;
    MailBody body;
    MailHeader header;

    mailServerAccess access = new mailServerAccess();

    public MailCreatorFacade(Email mail, Long userId, String folderName) {
        this.userId = userId;
        this.mail = mail;
        this.folderName = folderName;

        sender = new MailSender(this.mail.getReceiver());
        attachment = new attachment(this.mail.getAttachments(), this.mail.hasAttachments());
        body = new MailBody(this.mail.getText());
        header = new MailHeader(this.mail.getReceiver(), this.mail.getSender(), this.mail.getSubject(), this.mail.getDate(),
                this.mail.getImportance());
    }

    public void create(){
        JSONObject obj = header.getHeader();
        obj = body.getBody(obj);
        //obj = attachment.getAttachement(obj);
        if(folderName.equals("sent"))
            sender.send(obj);
        access.addJSONEamilToUser(obj, userId, folderName);
    }

}
