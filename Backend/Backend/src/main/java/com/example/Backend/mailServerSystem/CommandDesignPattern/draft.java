package com.example.Backend.mailServerSystem.CommandDesignPattern;



public class draft implements command{
    mailServerButtons draft;

    public draft(mailServerButtons draft) {
        this.draft = draft;
    }

    public String execute(){
        return draft.getData("draft");
    }

}
