package com.example.Backend.mailServerSystem.CommandDesignPattern;


public class inbox implements command{

    mailServerButtons inbox;

    public inbox(mailServerButtons inbox) {
        this.inbox = inbox;
    }

    public String execute() {
        return inbox.getData("inbox");
    }
}
