package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class userFolders implements command{
    mailServerButtons userFolder;

    public userFolders(mailServerButtons userFolder) {
        this.userFolder = userFolder;
    }

    public String execute() {
        userFolder.createFolder();
        return null;
    }
}
