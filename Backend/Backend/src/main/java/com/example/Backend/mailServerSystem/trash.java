package com.example.Backend.mailServerSystem;


public class trash implements command {

    mailServerButtons trash;

    public trash(mailServerButtons trash) {
        this.trash = trash;
    }

    public String execute() {
        return trash.getTrashMails();
    }

}
