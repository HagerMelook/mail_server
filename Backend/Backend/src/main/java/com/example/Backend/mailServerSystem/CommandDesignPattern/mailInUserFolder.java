package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class mailInUserFolder implements command{
    mailServerButtons theMail;

    public mailInUserFolder(mailServerButtons theMail) {
        this.theMail = theMail;
    }

    public String execute(){
        return theMail.getEmailInUserFolder();
    }

}
