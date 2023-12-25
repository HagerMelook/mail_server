package com.example.Backend.mailServerSystem.CommandDesignPattern;

public class userMail{
    public static mailServerButtons getButton(Long id){
        return new mailServer(id);
    }
     public static mailServerButtons getMail(Long idD, String foldeName, Long idU){
        return new mailServer(idD, foldeName, idU);
    }
}
