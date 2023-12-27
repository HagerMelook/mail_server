package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class DeleteFolder implements command{
    mailServerButtons delete;

    public DeleteFolder(mailServerButtons delete) {
        this.delete = delete;
    }

    public String execute(){
        return delete.deleteFolder();
    }
    
}

