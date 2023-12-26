package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class userMail{
    public static mailServerButtons getButton(Long idU){
        return new mailServerAccess(idU);
    }
     public static mailServerButtons getMail(Long idD, String foldeName, Long idU){
        return new mailServerAccess(idD, foldeName, idU);
    }
    public static mailServerButtons userFolders(Long idU, String folderName){
        return new mailServerAccess(idU,folderName);
    }
}
