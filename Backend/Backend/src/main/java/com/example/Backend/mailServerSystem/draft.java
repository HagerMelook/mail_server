package com.example.Backend.mailServerSystem;



public class draft implements command{
    mailServerButtons draft;

    public draft(mailServerButtons draft) {
        this.draft = draft;
    }

    public String execute(){
        return draft.getDraftMails();
    }

}
