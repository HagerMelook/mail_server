package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class getFolder implements command {
    mailServerButtons userFolder;

    public getFolder(mailServerButtons userFolder) {
        this.userFolder = userFolder;
    }

    public String execute() {
        return userFolder.getUserFolder();
    }
    
}
