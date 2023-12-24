package com.example.Backend.mailServerSystem;


public class sent implements command{

    mailServerButtons sent;

    public sent(mailServerButtons sent) {
        this.sent = sent;
    }

    public String execute() {
        return sent.getSentMails();
    }
}
