package com.example.Backend.mailServerSystem.CommandDesignPattern;

public interface mailServerButtons {
    public String getData(String folderName);
    public String getMail();
    public void createFolder();
    public String getUserFolder();
    public String getEmailInUserFolder();
}
