package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class getAllUserFolders implements command{
    mailServerButtons userFolder;

    public getAllUserFolders(mailServerButtons userFolder) {
        this.userFolder = userFolder;
    }

    public String execute() {
        return userFolder.getData("userFolders");
    }
}