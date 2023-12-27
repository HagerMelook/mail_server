package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class contact implements command{
    mailServerButtons contacts;

    public contact(mailServerButtons contacts) {
        this.contacts = contacts;
    }

    public String execute(){
        return contacts.getData("contacts");
    }

}
