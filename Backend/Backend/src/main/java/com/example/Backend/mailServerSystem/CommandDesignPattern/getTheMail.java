package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class getTheMail implements command{
    mailServerButtons theMail;

    public getTheMail(mailServerButtons theMail) {
        this.theMail = theMail;
    }

    public String execute(){
        return theMail.getMail();
    }
    
}
