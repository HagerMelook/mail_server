package com.example.Backend.mailServerSystem.CommandDesignPattern;


public class sent implements command{

    mailServerButtons sent;

    public sent(mailServerButtons sent) {
        this.sent = sent;
    }

    public String execute() {
        return sent.getData("sent");
    }
}
