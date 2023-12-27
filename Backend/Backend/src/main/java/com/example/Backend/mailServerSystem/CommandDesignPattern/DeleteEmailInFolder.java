package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class DeleteEmailInFolder implements command{
    mailServerButtons delete;

    public DeleteEmailInFolder(mailServerButtons delete) {
        this.delete = delete;
    }

    public String execute(){
        return delete.deleteEmailInFolder();
    }
}
