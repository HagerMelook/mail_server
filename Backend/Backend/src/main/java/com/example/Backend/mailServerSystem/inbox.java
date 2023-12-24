package com.example.Backend.mailServerSystem;


public class inbox implements command{

    mailServerButtons inbox;

    public inbox(mailServerButtons inbox) {
        this.inbox = inbox;
    }

    public String execute() {
        return inbox.getInboxMails();
    }
}
